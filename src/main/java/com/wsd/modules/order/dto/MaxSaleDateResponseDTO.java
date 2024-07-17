package com.wsd.modules.order.dto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MaxSaleDateResponseDTO {
    private String date;
    private Double totalSaleAmount;
}
