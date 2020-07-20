package mbrdi.componentsearch.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ejaskhan
 * @Date 20 July 2020
 */
public class PlacesDTO implements Serializable {

	private final static long serialVersionUID = 5928104026833348201L;

	@JsonProperty("places")
	private List<ItemsDTO> itemsDTOS = null;

	@JsonProperty("places")
	public List<ItemsDTO> getItemsDTOS() {
		return itemsDTOS;
	}

	@JsonProperty("places")
	public void setItemsDTOS(List<ItemsDTO> itemsDTOS) {
		this.itemsDTOS = itemsDTOS;
	}

	@Override
	public String toString() {
		return "PlacesDTO{" +
				"itemsDTOS=" + itemsDTOS +
				'}';
	}
}
