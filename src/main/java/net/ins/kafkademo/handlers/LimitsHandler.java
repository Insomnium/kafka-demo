package net.ins.kafkademo.handlers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.ins.kafkademo.events.EventType;
import net.ins.kafkademo.events.LimitChangedEvent;
import net.ins.kafkademo.events.LimitEvent;
import net.ins.kafkademo.handlers.meta.LimitsProcessor;
import net.ins.kafkademo.service.LimitsService;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class LimitsHandler {

    private final LimitsService limitsService;

    @StreamListener(LimitsProcessor.INPUT)
    @SendTo(LimitsProcessor.OUTPUT)
    public LimitChangedEvent applyLimit(LimitEvent limitEvent) {
        if (limitEvent.getType() == EventType.CHANGED) {
            changeLimit(limitEvent);
            return new LimitChangedEvent(EventType.CHANGED, limitEvent.getId(), limitEvent.getAccount(), LocalDateTime.now());
        }

        throw new IllegalArgumentException(String.format("Limit of type %s is not supported", limitEvent.getType()));
    }

    private void changeLimit(LimitEvent limitEvent) {
        limitsService.setupLimit(limitEvent.getAccount(), limitEvent.getMin(), limitEvent.getMax())
                .subscribe();
    }
}
