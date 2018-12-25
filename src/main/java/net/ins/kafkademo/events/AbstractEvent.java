package net.ins.kafkademo.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class AbstractEvent {
    protected EventType type;
}
