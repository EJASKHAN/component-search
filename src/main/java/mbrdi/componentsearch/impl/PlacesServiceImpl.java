package mbrdi.componentsearch.impl;

import mbrdi.componentsearch.common.RestResponseUtil;
import mbrdi.componentsearch.communication.api.ExternalService;
import mbrdi.componentsearch.model.Items;
import mbrdi.componentsearch.model.ItemsDTO;
import mbrdi.componentsearch.model.PlacesDTO;
import mbrdi.componentsearch.service.PlacesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


/**
 * @author Ejaskhan
 * @Date 20 July 2020
 */
@Component
public class PlacesServiceImpl implements PlacesService {

	private static final Logger logger = LoggerFactory.getLogger(PlacesServiceImpl.class);

	private ExternalService externalService;

	@Autowired
	public PlacesServiceImpl(ExternalService externalService) {
		this.externalService = externalService;
	}

	@Override
	public ResponseEntity<PlacesDTO> findNearbyPOIs(String location, String apiKey) {

		logger.trace(" >> findNearbyPOIs() ");
		PlacesDTO placesDTO = new PlacesDTO();
		List<ItemsDTO> itemsDTOS = new ArrayList<>();


		CompletableFuture<ResponseEntity<Items>> restaurantsDTOCompletableFuture = externalService
				.getNearByRestaurantsFromHereMaps(location, apiKey);
		CompletableFuture<ResponseEntity<Items>> chargingStationsDTOCompletableFuture = externalService.
				getNearByChargingStationsFromHereMaps(location, apiKey);
		CompletableFuture<ResponseEntity<Items>> parkingSpotsDTOCompletableFuture = externalService.
				getNearByParkingSpotsFromHereMaps(location, apiKey);

		CompletableFuture.allOf(restaurantsDTOCompletableFuture, chargingStationsDTOCompletableFuture
				, parkingSpotsDTOCompletableFuture).join();

		try {
			itemsDTOS.add(RestResponseUtil.buildRestaurantsResponseDTO(restaurantsDTOCompletableFuture.get()));
			itemsDTOS.add(RestResponseUtil.buildChargingStationsResponseDTO(chargingStationsDTOCompletableFuture.get()));
			itemsDTOS.add(RestResponseUtil.buildParkingSpotsResponseDTO(parkingSpotsDTOCompletableFuture.get()));
		}
		catch (InterruptedException interruptedException) {
			logger.error(interruptedException.getMessage());
		} catch (ExecutionException executionException) {
			logger.error(executionException.getMessage());
		}

		placesDTO.setItemsDTOS(itemsDTOS);
		logger.trace(" << findNearbyPOIs() ");
		return new ResponseEntity<>(placesDTO, HttpStatus.OK);


	}


}
