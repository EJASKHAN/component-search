package mbrdi.componentsearch.communication.api;

import mbrdi.componentsearch.model.Items;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.CompletableFuture;

/**
 * @author Ejaskhan
 * @Date 20 July 2020
 */
public interface ExternalService {


	/**
	 * Find the nearby by parking-spots
	 *
	 * @param location location to search
	 * @param apiKey   user provided authentication key
	 * @return ResponseEntity<Items> response entity of type Items
	 */
	CompletableFuture<ResponseEntity<Items>> getNearByParkingSpotsFromHereMaps(String location, String apiKey);

	/**
	 * Find the nearby by charging-stations
	 *
	 * @param location location to search
	 * @param apiKey   user provided authentication key
	 * @return ResponseEntity<Items> response entity of type Items
	 */
	CompletableFuture<ResponseEntity<Items>> getNearByChargingStationsFromHereMaps(String location, String apiKey);

	/**
	 * Find the nearby by restaurants
	 *
	 * @param location location to search
	 * @param apiKey   user provided authentication key
	 * @return ResponseEntity<Items> response entity of type Items
	 */
	CompletableFuture<ResponseEntity<Items>> getNearByRestaurantsFromHereMaps(String location, String apiKey);
}
