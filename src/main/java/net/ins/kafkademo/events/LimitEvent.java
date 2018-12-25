package net.ins.kafkademo.events;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;


@EqualsAndHashCode(callSuper = true)
@Data
public class LimitEvent extends AbstractEvent {
    private String id;
    private String account;
    private BigDecimal min = BigDecimal.ZERO;
    private BigDecimal max;

    public LimitEvent(EventType type, String id, String account, BigDecimal min, BigDecimal max) {
        super(type);
        this.id = id;
        this.account = account;
        this.min = min;
        this.max = max;
    }
}
