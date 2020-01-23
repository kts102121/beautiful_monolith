package org.ron.beautiful_monolith.domain.order.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.modelmapper.internal.util.ToStringBuilder;
import org.ron.beautiful_monolith.common.model.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Orders")
@Getter
@ToString(of = {""})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity implements Serializable {
    @Column(nullable = false)
    private String productName;

    @Builder
    public Order(String productName) {
        this.productName = productName;
    }
}
