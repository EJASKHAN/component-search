
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
		"results",
		"search"
})
public class Items implements Serializable {

	@JsonProperty("results")
	private Results results;
	@JsonProperty("search")
	private Search search;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -894861182234884501L;

	@JsonProperty("results")
	public Results getResults() {
		return results;
	}

	@JsonProperty("results")
	public void setResults(Results results) {
		this.results = results;
	}

	public Items withResults(Results results) {
		this.results = results;
		return this;
	}

	@JsonProperty("search")
	public Search getSearch() {
		return search;
	}

	@JsonProperty("search")
	public void setSearch(Search search) {
		this.search = search;
	}

	public Items withSearch(Search search) {
		this.search = search;
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

	public Items withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return "Items{" +
				"results=" + results +
				", search=" + search +
				", additionalProperties=" + additionalProperties +
				'}';
	}
}
