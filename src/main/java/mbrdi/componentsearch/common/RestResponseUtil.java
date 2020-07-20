package mbrdi.componentsearch.common;

import mbrdi.componentsearch.model.Item;
import mbrdi.componentsearch.model.Items;
import mbrdi.componentsearch.model.ItemsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Ejaskhan
 * @Date 20 July 2020
 */
public class RestResponseUtil {

	/**
	 * Build restaurant itemsDTO from ResponseEntity<Items>
	 *
	 * @param  itemsResponseEntity ResponseEntity of type Items
	 *@return ItemsDTO
	 */
	public static ItemsDTO buildRestaurantsResponseDTO(ResponseEntity<Items> itemsResponseEntity) {

		ItemsDTO itemsDTO = new ItemsDTO();;
		if (Objects.nonNull(itemsResponseEntity) &&
				!CollectionUtils.isEmpty(itemsResponseEntity.getBody().getResults().getItems())) {
			itemsDTO.setItems(itemsResponseEntity.getBody().getResults().getItems()
					.stream().sorted(Comparator.comparing(Item::getDistance))
					.collect(Collectors.toList()));

			itemsDTO.setMessage(!itemsDTO.getItems().isEmpty() ?
					PlacesConstants.RESTAURANT_SUCCESS_MESSAGE :
					PlacesConstants.RESTAURANT_FAIL_MESSAGE);

			itemsDTO.setCategoryId(PlacesConstants.RESTAURANT);
			return  itemsDTO;
		}
		itemsDTO.setMessage(PlacesConstants.RESTAURANT_FAIL_MESSAGE);
		itemsDTO.setCategoryId(PlacesConstants.RESTAURANT);
		return itemsDTO;
	}

	/**
	 * Build parking spot itemsDTO from ResponseEntity<Items>
	 *
	 * @param  itemsResponseEntity ResponseEntity of type Items
	 *@return ItemsDTO
	 */
	public static ItemsDTO buildParkingSpotsResponseDTO(ResponseEntity<Items> itemsResponseEntity) {

		ItemsDTO itemsDTO = new ItemsDTO();
		if (Objects.nonNull(itemsResponseEntity) &&
				!CollectionUtils.isEmpty(itemsResponseEntity.getBody().getResults().getItems())) {
			itemsDTO.setItems(itemsResponseEntity.getBody().getResults().getItems()
					.stream().sorted(Comparator.comparing(Item::getDistance))
					.collect(Collectors.toList()));

			itemsDTO.setMessage(!itemsDTO.getItems().isEmpty() ?
					PlacesConstants.PARKING_FACILITY_SUCCESS_MESSAGE :
					PlacesConstants.PARKING_FACILITY_FAIL_MESSAGE);

			itemsDTO.setCategoryId(PlacesConstants.PARKING_FACILITY);
			return itemsDTO;
		}
		itemsDTO.setMessage(PlacesConstants.PARKING_FACILITY_FAIL_MESSAGE);
		itemsDTO.setCategoryId(PlacesConstants.PARKING_FACILITY);
		return itemsDTO;
	}

	/**
	 * Build charging stations itemsDTO from ResponseEntity<Items>
	 *
	 * @param  itemsResponseEntity ResponseEntity of type Items
	 *@return ItemsDTO
	 */
	public static ItemsDTO buildChargingStationsResponseDTO(ResponseEntity<Items> itemsResponseEntity) {

		ItemsDTO itemsDTO = new ItemsDTO();;
		if (Objects.nonNull(itemsResponseEntity) &&
				!CollectionUtils.isEmpty(itemsResponseEntity.getBody().getResults().getItems())) {
			;itemsDTO.setItems(itemsResponseEntity.getBody().getResults().getItems()
					.stream().sorted(Comparator.comparing(Item::getDistance))
					.collect(Collectors.toList()));

			itemsDTO.setMessage(!itemsDTO.getItems().isEmpty() ?
					PlacesConstants.CHARGING_STATION_SUCCESS_MESSAGE :
					PlacesConstants.CHARGING_STATION_FAIL_MESSAGE);

			itemsDTO.setCategoryId(PlacesConstants.CHARGING_STATION);
			return itemsDTO;
		}
		itemsDTO.setMessage(PlacesConstants.CHARGING_STATION_FAIL_MESSAGE);
		itemsDTO.setCategoryId(PlacesConstants.CHARGING_STATION);
		return itemsDTO;
	}


}
