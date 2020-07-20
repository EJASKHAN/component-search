
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
		"position",
		"address"
})
public class Location implements Serializable {

	@JsonProperty("position")
	private List<Double> position = null;
	@JsonProperty("address")
	private Address address;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 5904580766594999132L;

	@JsonProperty("position")
	public List<Double> getPosition() {
		return position;
	}

	@JsonProperty("position")
	public void setPosition(List<Double> position) {
		this.position = position;
	}

	public Location withPosition(List<Double> position) {
		this.position = position;
		return this;
	}

	@JsonProperty("address")
	public Address getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(Address address) {
		this.address = address;
	}

	public Location withAddress(Address address) {
		this.address = address;
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

	public Location withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return "Location{" +
				"position=" + position +
				", address=" + address +
				", additionalProperties=" + additionalProperties +
				'}';
	}
}
