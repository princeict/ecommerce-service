package com.wsd.modules.voucherdetail.entity;


import com.wsd.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import javax.persistence.Entity;
import java.io.Serializable;


@Entity(name = "voucher_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class VoucherDetail extends BaseEntity implements Serializable {
    private Integer quantity;
    private Double unitPrice;
    private Double totalPrice;
    private Long voucherId;
    private Long productId;
}
