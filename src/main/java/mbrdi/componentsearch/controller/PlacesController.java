package mbrdi.componentsearch.controller;

import mbrdi.componentsearch.model.PlacesDTO;
import mbrdi.componentsearch.service.PlacesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ejaskhan
 * @Date 20 July 2020
 */
@RestController()
@RequestMapping("/api/component-search/places")
public class PlacesController {

	private static final Logger logger = LoggerFactory.getLogger(PlacesController.class);
	private PlacesService placesService;

	@Autowired
	public PlacesController(PlacesService placesService) {
		this.placesService = placesService;
	}

	@RequestMapping(value = "/discover/explore", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PlacesDTO> getPopularPlacesByCategory(@RequestParam(value = "at") String location,
																@RequestParam(value = "apiKey", required = false) String apiKey)
	{

		logger.trace( " >> .getPopularPlacesByCategory()");
		return placesService.findNearbyPOIs(location, apiKey);
	}
}
