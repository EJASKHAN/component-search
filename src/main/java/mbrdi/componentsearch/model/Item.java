
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
		"distance",
		"title",
		"averageRating",
		"category",
		"icon",
		"vicinity",
		"having",
		"type",
		"href",
		"id",
		"chainIds"
})
public class Item implements Serializable {

	@JsonProperty("position")
	private List<Double> position = null;
	@JsonProperty("distance")
	private int distance;
	@JsonProperty("title")
	private String title;
	@JsonProperty("averageRating")
	private double averageRating;
	@JsonProperty("category")
	private Category category;
	@JsonProperty("icon")
	private String icon;
	@JsonProperty("vicinity")
	private String vicinity;
	@JsonProperty("having")
	private List<Object> having = null;
	@JsonProperty("type")
	private String type;
	@JsonProperty("href")
	private String href;
	@JsonProperty("id")
	private String id;
	@JsonProperty("chainIds")
	private List<String> chainIds = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -4739252220793507091L;

	@JsonProperty("position")
	public List<Double> getPosition() {
		return position;
	}

	@JsonProperty("position")
	public void setPosition(List<Double> position) {
		this.position = position;
	}

	public Item withPosition(List<Double> position) {
		this.position = position;
		return this;
	}

	@JsonProperty("distance")
	public int getDistance() {
		return distance;
	}

	@JsonProperty("distance")
	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Item withDistance(int distance) {
		this.distance = distance;
		return this;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	public Item withTitle(String title) {
		this.title = title;
		return this;
	}

	@JsonProperty("averageRating")
	public double getAverageRating() {
		return averageRating;
	}

	@JsonProperty("averageRating")
	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public Item withAverageRating(double averageRating) {
		this.averageRating = averageRating;
		return this;
	}

	@JsonProperty("category")
	public Category getCategory() {
		return category;
	}

	@JsonProperty("category")
	public void setCategory(Category category) {
		this.category = category;
	}

	public Item withCategory(Category category) {
		this.category = category;
		return this;
	}

	@JsonProperty("icon")
	public String getIcon() {
		return icon;
	}

	@JsonProperty("icon")
	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Item withIcon(String icon) {
		this.icon = icon;
		return this;
	}

	@JsonProperty("vicinity")
	public String getVicinity() {
		return vicinity;
	}

	@JsonProperty("vicinity")
	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}

	public Item withVicinity(String vicinity) {
		this.vicinity = vicinity;
		return this;
	}

	@JsonProperty("having")
	public List<Object> getHaving() {
		return having;
	}

	@JsonProperty("having")
	public void setHaving(List<Object> having) {
		this.having = having;
	}

	public Item withHaving(List<Object> having) {
		this.having = having;
		return this;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	public Item withType(String type) {
		this.type = type;
		return this;
	}

	@JsonProperty("href")
	public String getHref() {
		return href;
	}

	@JsonProperty("href")
	public void setHref(String href) {
		this.href = href;
	}

	public Item withHref(String href) {
		this.href = href;
		return this;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	public Item withId(String id) {
		this.id = id;
		return this;
	}

	@JsonProperty("chainIds")
	public List<String> getChainIds() {
		return chainIds;
	}

	@JsonProperty("chainIds")
	public void setChainIds(List<String> chainIds) {
		this.chainIds = chainIds;
	}

	public Item withChainIds(List<String> chainIds) {
		this.chainIds = chainIds;
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

	public Item withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return "Item{" +
				"position=" + position +
				", distance=" + distance +
				", title='" + title + '\'' +
				", averageRating=" + averageRating +
				", category=" + category +
				", icon='" + icon + '\'' +
				", vicinity='" + vicinity + '\'' +
				", having=" + having +
				", type='" + type + '\'' +
				", href='" + href + '\'' +
				", id='" + id + '\'' +
				", chainIds=" + chainIds +
				", additionalProperties=" + additionalProperties +
				'}';
	}
}
