# component-search
This repo contains the search component code.

component-search uses the Here Maps Places Search API’s to find Parking spots, Charging Stations and Restaurants near the user provided location.

User has to provide the location in latitude and longitude format , for example : 52.5159,13.3882.

Rest End point exposed is /api/component-search/places/discover/explore by default on port 8761
params1 : at (location) , mandatory = true
params2 : apiKey , mandatory = false. (if not provided a default apiKey will be use)

Sample Url : http://localhost:8761/api/component-search/places/discover/explore?at=52.5159,13.3882

#Steps for Running the Application

1.clone the repo :  git clone https://github.com/EJASKHAN/component-search.git
2.clean build :  gradlew clean build
3.bootRun :  gradlew bootRun

#Steps for creating docker image

1.gradlew bootBuildImage --imageName=mbrdi/component-search-ejaskhan

#Running latest image of this component
1.docker pull ejaskhan/component-search-mbrdi:latest
