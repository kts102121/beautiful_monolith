package org.ron.beautiful_monolith.domain.order.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@ToString(of = { "" })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class OrderDTO implements Serializable {
    private Long id;
    private String productName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private OrderDTO(Builder builder) {
        id = builder.id;
        productName = builder.productName;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
    }

    public static OrderDTO.Builder builder() {
        return new OrderDTO.Builder();
    }

    public static class Builder {
        private Long id;
        private String productName;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        Builder() {

        }

        public OrderDTO.Builder id(final Long id) {
            this.id = id;
            return this;
        }

        public OrderDTO.Builder productName(final String productName) {
            this.productName = productName;
            return this;
        }

        public OrderDTO.Builder createdAt(final LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public OrderDTO.Builder updatedAt(final LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public OrderDTO build() { return new OrderDTO(this); }
    }
}
