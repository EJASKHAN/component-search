package mbrdi.componentsearch.controller;

import mbrdi.componentsearch.service.PlacesService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author Ejaskhan
 * @Date 20 July 2020
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PlacesController.class)
public class PlacesControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PlacesService placesService;

	@Test
	void getPopularPlacesByCategoryTest() throws Exception {


		MvcResult mvcResult = mockMvc.perform
				(MockMvcRequestBuilders.get("/api/component-search/places/discover/explore")
						.queryParam("at", "52.5159,13.3777")
						.accept(MediaType.APPLICATION_JSON))
				.andReturn();

		Assert.assertEquals(mvcResult.getResponse().getStatus(), HttpStatus.OK.value());
	}
}