package org.amazonmq.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String[] products;
}
