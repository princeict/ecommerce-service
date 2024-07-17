package com.wsd.modules.wishlist.service;


import com.wsd.modules.wishlist.dto.CustomerWishListResponseDTO;
import java.util.List;

public interface WishListService {
    List<CustomerWishListResponseDTO> fetchByCustomerId(Long customerId);
}
