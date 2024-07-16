package com.wsd.modules.paymenttype.entity;


import com.wsd.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import javax.persistence.Entity;
import java.io.Serializable;


@Entity(name = "payment_types")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class PaymentType extends BaseEntity implements Serializable {
    private String name;
}
