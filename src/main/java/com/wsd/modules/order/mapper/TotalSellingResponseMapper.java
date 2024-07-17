package com.wsd.modules.order.mapper;

import com.wsd.modules.order.dto.TotalSellingProductResponseDTO;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TotalSellingResponseMapper implements RowMapper<TotalSellingProductResponseDTO> {

    @Override
    public TotalSellingProductResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        TotalSellingProductResponseDTO response = new TotalSellingProductResponseDTO();
        response.setProductName(rs.getString("product_name"));

        return response;
    }
}
