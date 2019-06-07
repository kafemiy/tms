/**
 * 
 */
package com.neumtah.tms.api;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.neumtah.tms.services.TimeService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * @author kafemiy
 *
 */
@Component
@Slf4j
public class TimeHandler {

	@Autowired
	private TimeService timeSvc;

	public Mono<ServerResponse> getDate(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromObject(LocalDateTime.now().toLocalDate()));
	}

	/**
	 * @param request
	 * @return
	 */
	public Mono<ServerResponse> getRemoteFullDate(ServerRequest request) {
		Mono<String> rtimeMono = timeSvc.getRemoteFullDate();

		return rtimeMono.flatMap(rtime -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromObject(rtime)));
	}
}
