/**
 * 
 */
package com.neumtah.tms;

import java.time.LocalDateTime;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

/**
 * @author kafemiy
 *
 */
@Component
public class TimeHandler {
	public Mono<ServerResponse> getDate(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
			.body(BodyInserters.fromObject(LocalDateTime.now().toLocalDate()));
	}

}
