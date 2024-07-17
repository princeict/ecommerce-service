package com.wsd.modules.wishlist.service;


import com.wsd.modules.wishlist.dto.CustomerWishListResponseDTO;
import com.wsd.modules.wishlist.repository.WishListJdbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WishListServiceImpl implements WishListService {
    private final WishListJdbcRepository wishListJdbcRepository;
    @Override
    public List<CustomerWishListResponseDTO> fetchByCustomerId(Long customerId) {
        List<CustomerWishListResponseDTO> returnValue  = wishListJdbcRepository.findByCustomerId(customerId);
        return returnValue;
    }
}
