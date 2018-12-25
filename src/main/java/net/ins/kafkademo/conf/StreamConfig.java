package net.ins.kafkademo.conf;


import net.ins.kafkademo.handlers.meta.LimitsProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(LimitsProcessor.class)
public class StreamConfig {

}
