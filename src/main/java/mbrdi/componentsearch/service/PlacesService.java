package mbrdi.componentsearch.service;

import mbrdi.componentsearch.model.PlacesDTO;
import org.springframework.http.ResponseEntity;

/**
 * @author Ejaskhan
 * @Date 20 July 2020
 */
public interface PlacesService {

	/**
	 * Fetch the nearby POIs by category (restaurant,parking-facility,charging-facility)
	 *
	 * @param location location to search
	 * @param apiKey   user provided authentication key
	 * @return ResponseEntity<PlacesDTO> response entity of type PlacesDTO
	 */
	ResponseEntity<PlacesDTO> findNearbyPOIs(String location, String apiKey);
}
