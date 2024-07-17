package com.wsd.modules.wishlist.dto;

import lombok.*;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerWishListResponseDTO {
    private Long productId;
    private String productName;
    private String productDescription;
}
