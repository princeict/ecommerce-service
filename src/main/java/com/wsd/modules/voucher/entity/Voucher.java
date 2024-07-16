package com.wsd.modules.voucher.entity;


import com.wsd.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity(name = "vouchers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Voucher extends BaseEntity implements Serializable {
    private String voucherNo;
    private Double totalPrice;
    private LocalDateTime voucherDate;
    private Long voucherTypeId;
    private Long targetCustomerId;
    private Long paymentTypeId;
}
