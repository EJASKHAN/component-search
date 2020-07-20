package mbrdi.componentsearch.communication.impl;

import mbrdi.componentsearch.common.PlacesConstants;
import mbrdi.componentsearch.communication.api.ExternalService;
import mbrdi.componentsearch.model.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.concurrent.CompletableFuture;

/**
 * @author Ejaskhan
 * @Date 20 July 2020
 */
@Service
public class ExternalServiceImpl implements ExternalService {

	private static final Logger logger = LoggerFactory.getLogger(ExternalServiceImpl.class);
	@Autowired
	RestTemplate restTemplate;

	protected final ParameterizedTypeReference<Items> parameterizedTypeReferenceItems =
			new ParameterizedTypeReference<Items>() {
			};


	@Override
	@Cacheable(value = "parkingSpotCache",key = "#location")
	@Async("asyncExternalServiceCall")
	public CompletableFuture<ResponseEntity<Items>> getNearByParkingSpotsFromHereMaps(String location, String apiKey) {

		logger.trace(" >> getNearByParkingSpotsFromHereMaps()");
		return CompletableFuture.completedFuture(restTemplate.exchange
				(getUriComponentsBuilder(PlacesConstants.CHARGING_STATION, location, apiKey)
								.build(false).toUriString(), HttpMethod.GET, null,
						parameterizedTypeReferenceItems));
	}

	@Override
	@Cacheable(value = "chargingSpotCache",key = "#location")
	@Async("asyncExternalServiceCall")
	public CompletableFuture<ResponseEntity<Items>> getNearByChargingStationsFromHereMaps(String location, String apiKey) {

		logger.trace(" >> getNearByChargingStationsFromHereMaps()");
		return CompletableFuture.completedFuture(restTemplate.exchange(
				getUriComponentsBuilder(PlacesConstants.CHARGING_STATION, location, apiKey)
						.build(false).toUriString(), HttpMethod.GET, null,
				parameterizedTypeReferenceItems));
	}

	@Override
	@Cacheable(value = "restaurantCache",key = "#location")
	@Async("asyncExternalServiceCall")
	public CompletableFuture<ResponseEntity<Items>> getNearByRestaurantsFromHereMaps(String location, String apiKey) {

		logger.trace(" >> getNearByRestaurantsFromHereMaps()");
		return CompletableFuture.completedFuture(restTemplate.exchange(
				getUriComponentsBuilder(PlacesConstants.RESTAURANT, location, apiKey)
						.build(false).toUriString(), HttpMethod.GET, null,
				parameterizedTypeReferenceItems));
	}

	private UriComponentsBuilder getUriComponentsBuilder(String category, String location, String apiKey) {

		return UriComponentsBuilder.fromHttpUrl(PlacesConstants.HERE_MAP_URL)
				.queryParam("at", location)
				.queryParam("cat", category)
				.queryParam("apiKey", StringUtils.isEmpty(apiKey) ? PlacesConstants.API_KEY : apiKey.trim())
				.queryParam("size", 3);


	}
}
