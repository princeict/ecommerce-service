package com.wsd.modules.order.mapper;

import com.wsd.modules.order.dto.TotalSaleAmountResponseDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TotalSaleResponseMapper implements RowMapper<TotalSaleAmountResponseDTO> {

    @Override
    public TotalSaleAmountResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        TotalSaleAmountResponseDTO response = new TotalSaleAmountResponseDTO();
        response.setTotalSaleAmount(rs.getDouble("total_sale"));

        return response;
    }
}
