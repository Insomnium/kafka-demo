package net.ins.kafkademo.domain;


import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Builder
@Accessors(chain = true)
@Document(collection = Limit.COLLECTION)
public class Limit {

    public static final String COLLECTION = "limits";
    private String id;
    private String account;
    private BigDecimal min;
    private BigDecimal max;
}
