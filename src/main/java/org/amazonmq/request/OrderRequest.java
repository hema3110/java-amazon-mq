package org.amazonmq.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    @NotEmpty(message = "products cannot be empty")
    private String[] products;
}
