package com.wsd.modules.wishlist.repository;

import com.wsd.modules.wishlist.dto.CustomerWishListResponseDTO;
import com.wsd.modules.wishlist.mapper.WishListResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class WishListJdbcRepositoryImpl implements WishListJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<CustomerWishListResponseDTO> findByCustomerId(Long customerId) {
        String sql = "SELECT p.id AS product_id," +
                "p.name AS product_name, p.description AS product_description " +
                "FROM products AS p " +
                "INNER JOIN wish_lists AS w ON p.id = w.product_id " +
                "WHERE w.customer_id ="+ customerId;

        List<CustomerWishListResponseDTO> response = jdbcTemplate.query(sql, new WishListResponseMapper());
        return response;
    }
}
