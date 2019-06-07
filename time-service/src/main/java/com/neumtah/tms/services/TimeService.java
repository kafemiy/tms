/**
 * 
 */
package com.neumtah.tms.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * @author kafemiy
 *
 */
@Service("timeSvc")
@Slf4j
public class TimeService {

	private WebClient REMOTEDATEWC = WebClient.create("http://worldclockapi.com");
	
	public Mono<LocalDate> getDate(ServerRequest request) {
		return Mono.just((LocalDateTime.now().toLocalDate()));
	}

	/**
	 * @param request
	 * @return
	 */
	public Mono<String> getRemoteFullDate() {
				Mono<String> rtimeMono = REMOTEDATEWC.get()
				.uri("/api/json/utc/now")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(String.class);

		return rtimeMono;
	}
}
