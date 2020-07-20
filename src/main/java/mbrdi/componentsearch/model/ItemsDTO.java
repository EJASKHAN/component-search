package mbrdi.componentsearch.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ejaskhan
 * @Date 20 July 2020
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemsDTO implements Serializable {
	private final static long serialVersionUID = 5918104026833348201L;

	@JsonProperty("message")
	private String message;

	@JsonProperty("categoryId")
	private String categoryId;

	@JsonProperty("items")
	private List<Item> items = null;

	@JsonProperty("items")
	public List<Item> getItems() {
		return items;
	}

	@JsonProperty("items")
	public void setItems(List<Item> items) {
		this.items = items;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	@JsonProperty("categoryId")
	public String getCategoryId() {
		return categoryId;
	}

	@JsonProperty("categoryId")
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "ItemsDTO{" +
				"message='" + message + '\'' +
				", categoryId='" + categoryId + '\'' +
				", items=" + items +
				'}';
	}
}
