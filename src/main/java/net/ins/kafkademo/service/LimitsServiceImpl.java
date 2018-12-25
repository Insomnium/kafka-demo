package net.ins.kafkademo.service;

import lombok.RequiredArgsConstructor;
import net.ins.kafkademo.domain.Limit;
import net.ins.kafkademo.repo.LimitRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class LimitsServiceImpl implements LimitsService {

    private final LimitRepo limitRepo;

    @Override
    public Flux<Limit> listLimits() {
        return limitRepo.findAll();
    }

    @Transactional
    @Override
    public Mono<Limit> setupLimit(String account, BigDecimal min, BigDecimal max) {
        return limitRepo.findByAccount(account)
                .defaultIfEmpty(Limit.builder()
                        .account(account)
                        .build()
                        .setMin(min)
                        .setMax(max))
                .flatMap(limitRepo::save);
    }
}
