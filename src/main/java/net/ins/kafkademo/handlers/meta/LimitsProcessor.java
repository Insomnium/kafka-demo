package net.ins.kafkademo.handlers.meta;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface LimitsProcessor {

    String INPUT = "limits";

    String OUTPUT = "limits-log";

    @Input(LimitsProcessor.INPUT)
    SubscribableChannel limitsInput();

    @Output(LimitsProcessor.OUTPUT)
    MessageChannel limitsLogOutput();
}
