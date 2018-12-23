package net.ins.kafkademo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.stream.Stream;

@RestController
@RequestMapping("/tick")
public class SampleController {

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<ZonedDateTime> tick(@RequestParam(value = "times", defaultValue = "3", required = false) Integer times) {
        return Flux.zip(
                Flux.interval(Duration.ofSeconds(1)),
                Flux.fromStream(Stream.generate(ZonedDateTime::now).limit(times))
        ).map(Tuple2::getT2);
    }
}
