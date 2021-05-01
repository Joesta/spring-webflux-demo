package com.semanticcode.webfluxdemo.service;

import com.semanticcode.webfluxdemo.dto.Response;
import com.semanticcode.webfluxdemo.util.SleepUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Joesta on 2021/05/01
 */

@Service
public class ReactiveMathService {

    public Mono<Response> findSquare(int input) {
        return Mono.fromSupplier(() -> input * input)
                .map(Response::new);
    }

    public Flux<Response> multiplication(int input) {
        return Flux.range(1, 10)
                .doOnNext(i -> SleepUtil.sleepSeconds(1))
                .doOnNext(i -> System.out.println("reactive-math-processing: " + i))
                .map(i -> new Response(i * input));
    }
}
