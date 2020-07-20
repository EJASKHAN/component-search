
package mbrdi.componentsearch.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Ejaskhan
 * @Date 20 July 2020
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"next",
		"items"
})
public class Results implements Serializable {

	@JsonProperty("next")
	private String next;
	@JsonProperty("items")
	private List<Item> items = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 6423679568465082821L;

	@JsonProperty("next")
	public String getNext() {
		return next;
	}

	@JsonProperty("next")
	public void setNext(String next) {
		this.next = next;
	}

	public Results withNext(String next) {
		this.next = next;
		return this;
	}

	@JsonProperty("items")
	public List<Item> getItems() {
		return items;
	}

	@JsonProperty("items")
	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Results withItems(List<Item> items) {
		this.items = items;
		return this;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public Results withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return "Results{" +
				"next='" + next + '\'' +
				", items=" + items +
				", additionalProperties=" + additionalProperties +
				'}';
	}
}
