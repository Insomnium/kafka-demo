package net.ins.kafkademo.repo;

import net.ins.kafkademo.domain.Limit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface LimitRepo extends ReactiveMongoRepository<Limit, String> {
    Mono<Limit> findByAccount(String account);
}
