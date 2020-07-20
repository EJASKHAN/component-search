package mbrdi.componentsearch;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

@ComponentScan(lazyInit = true)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = ComponentSearchApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ComponentSearchApplicationTests {


	@Test
	void contextLoads() {
	}

}
