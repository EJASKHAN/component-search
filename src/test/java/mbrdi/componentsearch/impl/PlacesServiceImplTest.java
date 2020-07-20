package mbrdi.componentsearch.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import mbrdi.componentsearch.common.CommonTestUtills;
import mbrdi.componentsearch.common.PlacesConstants;
import mbrdi.componentsearch.communication.api.ExternalService;
import mbrdi.componentsearch.model.Items;
import mbrdi.componentsearch.model.ItemsDTO;
import mbrdi.componentsearch.model.PlacesDTO;
import mbrdi.componentsearch.service.PlacesService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;


@RunWith(MockitoJUnitRunner.class)
public class PlacesServiceImplTest {
	@Mock
	private ExternalService externalService;

	private PlacesService placesService;

	@Before
	public void init() {
		placesService = new PlacesServiceImpl(externalService);
	}

	@Test
	public void findNearbyPOIsTest() {
		mockExternalCalls();
		ResponseEntity<PlacesDTO> responseEntity = placesService.findNearbyPOIs
				("52.5159,13.3777", PlacesConstants.API_KEY);

		PlacesDTO placesDTO = responseEntity.getBody();

		Mockito.verify(externalService, Mockito.times(1))
				.getNearByRestaurantsFromHereMaps(Mockito.anyString(), Mockito.anyString());
		Mockito.verify(externalService, Mockito.times(1))
				.getNearByChargingStationsFromHereMaps(Mockito.anyString(), Mockito.anyString());
		Mockito.verify(externalService, Mockito.times(1))
				.getNearByParkingSpotsFromHereMaps(Mockito.anyString(), Mockito.anyString());

		List<ItemsDTO> itemsDTOS = placesDTO.getItemsDTOS().stream().collect(Collectors.toList());
		Assert.assertNotNull(placesDTO);
		Assert.assertTrue(placesDTO.getItemsDTOS().size() > 0);

		Assert.assertNotNull(itemsDTOS.stream().filter(items ->
				PlacesConstants.RESTAURANT.equalsIgnoreCase(items.getCategoryId())).findFirst());
		Assert.assertNotNull(itemsDTOS.stream().filter(items ->
				PlacesConstants.PARKING_FACILITY.equalsIgnoreCase(items.getCategoryId())).findFirst());
		Assert.assertNotNull(itemsDTOS.stream().filter(items ->
				PlacesConstants.CHARGING_STATION.equalsIgnoreCase(items.getCategoryId())).findFirst());


	}

	private void mockExternalCalls() {

		if (CommonTestUtills.fileResourceExists("restaurant.json")) {
			Items items = CommonTestUtills.readObject("restaurant.json",
					new TypeReference<Items>() {
					});

			Mockito.when(externalService.getNearByRestaurantsFromHereMaps(Mockito.anyString(), Mockito.anyString()))
					.thenReturn(CompletableFuture.completedFuture(new ResponseEntity<>(items, HttpStatus.OK)));
		}

		if (CommonTestUtills.fileResourceExists("parkingFacility.json")) {
			Items items = CommonTestUtills.readObject("parkingFacility.json",
					new TypeReference<Items>() {
					});

			Mockito.when(externalService.getNearByParkingSpotsFromHereMaps(Mockito.anyString(), Mockito.anyString()))
					.thenReturn(CompletableFuture.completedFuture(new ResponseEntity<>(items, HttpStatus.OK)));
		}

		if (CommonTestUtills.fileResourceExists("chargingStation.json")) {
			Items items = CommonTestUtills.readObject("chargingStation.json",
					new TypeReference<Items>() {
					});

			Mockito.when(externalService.getNearByChargingStationsFromHereMaps(Mockito.anyString(), Mockito.anyString()))
					.thenReturn(CompletableFuture.completedFuture(
							new ResponseEntity<>(items, HttpStatus.OK)));
		}

	}

}
