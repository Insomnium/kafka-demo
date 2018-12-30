package net.ins.kafkademo.service;


import net.ins.kafkademo.domain.Limit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface LimitsService {
    Flux<Limit> listLimits();
    Mono<Limit> setupLimit(String account, BigDecimal min, BigDecimal max);
    Mono<Limit> findByAcc(String account);
}
