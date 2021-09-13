package com.promotion;

import com.promotion.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import static org.springframework.web.reactive.function.client.WebClient.UriSpec;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;

@SpringBootTest
class PromotionApplicationTests {

    @Test
    public void validateSendMessageToCustomer(){
        WebClient client = WebClient.create("http://localhost:8080");

        UriSpec<WebClient.RequestBodySpec> uriSpec = client.method(HttpMethod.GET);

        WebClient.RequestBodySpec bodySpec = uriSpec.uri("/promotion/2015-04-03");

        WebClient.RequestHeadersSpec<?> headersSpec = (WebClient.RequestHeadersSpec<?>) bodySpec.bodyValue("data");

        WebClient.ResponseSpec responseSpec = headersSpec.header(
                        HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .acceptCharset(StandardCharsets.UTF_8)
                .ifNoneMatch("*")
                .ifModifiedSince(ZonedDateTime.now())
                .retrieve();

        Mono<Object> res = headersSpec.exchangeToMono( response -> {
            if (response.statusCode()
                    .equals(HttpStatus.OK)) {
                return response.bodyToMono(Object.class);
            } else if (response.statusCode()
                    .is4xxClientError()) {
                return Mono.just("Error response");
            } else {
                return response.createException()
                        .flatMap(Mono::error);
            }
        });

//        Mono<Customer[]> response = headersSpec.retrieve()
//                .bodyToMono(Customer[].class);
        Object customerList = res.block();
        System.out.println("--------FIN--------");
        System.out.println(customerList);
    }

}
