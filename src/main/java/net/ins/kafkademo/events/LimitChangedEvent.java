package net.ins.kafkademo.events;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class LimitChangedEvent extends AbstractEvent {

    private String changeEventId;
    private String account;
    private LocalDateTime timestamp;

    public LimitChangedEvent(EventType type, String changeEventId, String account, LocalDateTime timestamp) {
        super(type);
        this.changeEventId = changeEventId;
        this.account = account;
        this.timestamp = timestamp;
    }
}
