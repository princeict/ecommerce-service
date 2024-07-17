package com.wsd.modules.order.mapper;

import com.wsd.modules.order.dto.MaxSaleDateResponseDTO;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MaxSaleDateResponseMapper implements RowMapper<MaxSaleDateResponseDTO> {

    @Override
    public MaxSaleDateResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        MaxSaleDateResponseDTO response = new MaxSaleDateResponseDTO();
        response.setDate(rs.getString("order_date"));
        response.setTotalSaleAmount(rs.getDouble("total_amount"));

        return response;
    }
}
