package net.ins.kafkademo.controller;

import lombok.RequiredArgsConstructor;
import net.ins.kafkademo.domain.Limit;
import net.ins.kafkademo.service.LimitsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/limits")
@RequiredArgsConstructor
public class LimitsController {

    private final LimitsService limitsService;

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Limit> listLimits() {
        return limitsService.listLimits();
    }
}
