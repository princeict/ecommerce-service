package com.wsd.modules.wishlist.mapper;

import com.wsd.modules.wishlist.dto.CustomerWishListResponseDTO;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WishListResponseMapper implements RowMapper<CustomerWishListResponseDTO> {

    @Override
    public CustomerWishListResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        CustomerWishListResponseDTO response = new CustomerWishListResponseDTO();
        response.setProductId(rs.getLong("product_id"));
        response.setProductName(rs.getString("product_name"));
        response.setProductDescription(rs.getString("product_description"));

        return response;
    }
}
