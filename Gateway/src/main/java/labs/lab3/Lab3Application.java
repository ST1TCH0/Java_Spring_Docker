package labs.lab3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class Lab3Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab3Application.class, args);
	}
	@CrossOrigin
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("marks", r -> r.host("172.18.0.2:8082")
						.and()
						.path("/marks/{name}", "/marks")
						.uri("http://172.18.0.2:8084"))
				.route("models", r -> r.host("172.18.0.2:8082")
						.and()
						.path("/models", "/models/{id}", "/models/mark/{name}")
						.uri("http://172.18.0.2:8083"))
				.build();
	}
}
