package com.example.chaingateway.config;

//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.host("**.abc.org").and().path("/image/png") // ③
                        .filters(f ->
                                f.addResponseHeader("X-TestHeader", "foobar")) // ④
                        .uri("http://httpbin.org:80") //
                )

                .route(r -> r.host("**.abc.org").and().path("/image/png") // ③
                        .filters(f ->
                                f.addResponseHeader("X-TestHeader", "foobar")) // ④
                        .uri("http://httpbin.org:80") //
                )

                .route(r -> r.host("**.abc.org").and().path("/image/png") // ③
                        .filters(f ->
                                f.addResponseHeader("X-TestHeader", "foobar")) // ④
                        .uri("http://httpbin.org:80") //
                )

                .route(r -> r.host("**.abc.org").and().path("/image/png") // ③
                        .filters(f ->
                                f.addResponseHeader("X-TestHeader", "foobar")) // ④
                        .uri("http://httpbin.org:80") //
                )

                .route(r -> r.host("**.abc.org").and().path("/image/png") // ③
                        .filters(f ->
                                f.addResponseHeader("X-TestHeader", "foobar")) // ④
                        .uri("http://httpbin.org:80") //
                )

                .route(r -> r.host("**.abc.org").and().path("/image/png") // ③
                        .filters(f ->
                                f.addResponseHeader("X-TestHeader", "foobar")) // ④
                        .uri("http://httpbin.org:80") //
                )

                .route(r -> r.host("**.abc.org").and().path("/image/png") // ③
                        .filters(f ->
                                f.addResponseHeader("X-TestHeader", "foobar")) // ④
                        .uri("http://httpbin.org:80") //
                )

                .route(r -> r.host("**.abc.org").and().path("/image/png") // ③
                        .filters(f ->
                                f.addResponseHeader("X-TestHeader", "foobar")) // ④
                        .uri("http://httpbin.org:80") //
                )

                .route(r -> r.host("**.abc.org").and().path("/image/png") // ③
                        .filters(f ->
                                f.addResponseHeader("X-TestHeader", "foobar")) // ④
                        .uri("http://httpbin.org:80") //
                )

                .route(r -> r.host("**.abc.org").and().path("/image/png") // ③
                        .filters(f ->
                                f.addResponseHeader("X-TestHeader", "foobar")) // ④
                        .uri("http://httpbin.org:80") //
                )

                .route(r -> r.host("**.abc.org").and().path("/image/png") // ③
                        .filters(f ->
                                f.addResponseHeader("X-TestHeader", "foobar")) // ④
                        .uri("http://httpbin.org:80") //
                )

                .route(r -> r.host("**.abc.org").and().path("/image/png") // ③
                        .filters(f ->
                                f.addResponseHeader("X-TestHeader", "foobar")) // ④
                        .uri("http://httpbin.org:80") //
                )

                .route(r -> r.host("**.abc.org").and().path("/image/png") // ③
                        .filters(f ->
                                f.addResponseHeader("X-TestHeader", "foobar")) // ④
                        .uri("http://httpbin.org:80") //
                )

                .route(r -> r.host("**.abc.org").and().path("/image/png") // ③
                        .filters(f ->
                                f.addResponseHeader("X-TestHeader", "foobar")) // ④
                        .uri("http://httpbin.org:80") //
                )

                .route(r -> r.host("**.abc.org").and().path("/image/png") // ③
                        .filters(f ->
                                f.addResponseHeader("X-TestHeader", "foobar")) // ④
                        .uri("http://httpbin.org:80") //
                )

                .route(r -> r.host("**.abc.org").and().path("/image/png") // ③
                        .filters(f ->
                                f.addResponseHeader("X-TestHeader", "foobar")) // ④
                        .uri("http://httpbin.org:80") //
                )

                .route(r -> r.host("**.abc.org").and().path("/image/png") // ③
                        .filters(f ->
                                f.addResponseHeader("X-TestHeader", "foobar")) // ④
                        .uri("http://httpbin.org:80") //
                )

                .route(r -> r.host("**.abc.org").and().path("/image/png") // ③
                        .filters(f ->
                                f.addResponseHeader("X-TestHeader", "foobar")) // ④
                        .uri("http://httpbin.org:80") //
                )
                .build();

    }
}
