package com.wsd.modules.orderdetail.entity;


import com.wsd.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import javax.persistence.Entity;
import java.io.Serializable;


@Entity(name = "order_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class OrderDetail extends BaseEntity implements Serializable {
    private Integer quantity;
    private Double amount;
    private Double totalAmount;
    private Long orderId;
    private Long productId;
}
