package com.wsd.modules.wishlist.repository;


import com.wsd.modules.wishlist.dto.CustomerWishListResponseDTO;
import java.util.List;

public interface WishListJdbcRepository {
    List<CustomerWishListResponseDTO> findByCustomerId(Long customerId);
}
