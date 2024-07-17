package com.wsd.modules.order.entity;


import com.wsd.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Order extends BaseEntity implements Serializable {
    private String orderNo;
    private Double totalAmount;
    private LocalDateTime orderDate;
    private Long userId;
    private Long paymentTypeId;
}
