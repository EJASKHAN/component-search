
package mbrdi.componentsearch.model;

import java.io.Serializable;
import java.util.HashMap;
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
		"text",
		"house",
		"street",
		"postalCode",
		"district",
		"city",
		"county",
		"stateCode",
		"country",
		"countryCode"
})
public class Address implements Serializable {

	@JsonProperty("text")
	private String text;
	@JsonProperty("house")
	private String house;
	@JsonProperty("street")
	private String street;
	@JsonProperty("postalCode")
	private String postalCode;
	@JsonProperty("district")
	private String district;
	@JsonProperty("city")
	private String city;
	@JsonProperty("county")
	private String county;
	@JsonProperty("stateCode")
	private String stateCode;
	@JsonProperty("country")
	private String country;
	@JsonProperty("countryCode")
	private String countryCode;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -5799752586015626305L;

	@JsonProperty("text")
	public String getText() {
		return text;
	}

	@JsonProperty("text")
	public void setText(String text) {
		this.text = text;
	}

	public Address withText(String text) {
		this.text = text;
		return this;
	}

	@JsonProperty("house")
	public String getHouse() {
		return house;
	}

	@JsonProperty("house")
	public void setHouse(String house) {
		this.house = house;
	}

	public Address withHouse(String house) {
		this.house = house;
		return this;
	}

	@JsonProperty("street")
	public String getStreet() {
		return street;
	}

	@JsonProperty("street")
	public void setStreet(String street) {
		this.street = street;
	}

	public Address withStreet(String street) {
		this.street = street;
		return this;
	}

	@JsonProperty("postalCode")
	public String getPostalCode() {
		return postalCode;
	}

	@JsonProperty("postalCode")
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Address withPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	@JsonProperty("district")
	public String getDistrict() {
		return district;
	}

	@JsonProperty("district")
	public void setDistrict(String district) {
		this.district = district;
	}

	public Address withDistrict(String district) {
		this.district = district;
		return this;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	public Address withCity(String city) {
		this.city = city;
		return this;
	}

	@JsonProperty("county")
	public String getCounty() {
		return county;
	}

	@JsonProperty("county")
	public void setCounty(String county) {
		this.county = county;
	}

	public Address withCounty(String county) {
		this.county = county;
		return this;
	}

	@JsonProperty("stateCode")
	public String getStateCode() {
		return stateCode;
	}

	@JsonProperty("stateCode")
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public Address withStateCode(String stateCode) {
		this.stateCode = stateCode;
		return this;
	}

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	public Address withCountry(String country) {
		this.country = country;
		return this;
	}

	@JsonProperty("countryCode")
	public String getCountryCode() {
		return countryCode;
	}

	@JsonProperty("countryCode")
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Address withCountryCode(String countryCode) {
		this.countryCode = countryCode;
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

	public Address withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return "Address{" +
				"text='" + text + '\'' +
				", house='" + house + '\'' +
				", street='" + street + '\'' +
				", postalCode='" + postalCode + '\'' +
				", district='" + district + '\'' +
				", city='" + city + '\'' +
				", county='" + county + '\'' +
				", stateCode='" + stateCode + '\'' +
				", country='" + country + '\'' +
				", countryCode='" + countryCode + '\'' +
				", additionalProperties=" + additionalProperties +
				'}';
	}
}
