/**
 * 
 */
package com.neumtah.tms.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author kafemiy
 *
 */
@Configuration
public class TimeRouter {
	@Bean
	public RouterFunction<ServerResponse> route(TimeHandler timeHandler) {

		return RouterFunctions
			.route(RequestPredicates.GET("/date")
					.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), timeHandler::getDate)
			.andRoute(RequestPredicates.GET("/rfdate")
					.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), timeHandler::getRemoteFullDate);
	}
}
