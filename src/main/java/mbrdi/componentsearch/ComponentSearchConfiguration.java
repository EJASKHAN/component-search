package mbrdi.componentsearch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;

/**
 * @author Ejaskhan
 * @Date 20 July 2020
 */
@Configuration
@EnableAsync
public class ComponentSearchConfiguration {

	@Bean(name = "asyncExternalServiceCall")
	public Executor asyncExternalServiceCall() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(3);
		executor.setMaxPoolSize(3);
		executor.setQueueCapacity(100);
		executor.setThreadNamePrefix("asyncESThread -");
		executor.initialize();
		return executor;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
