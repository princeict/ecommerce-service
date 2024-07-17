package com.wsd.modules.order.repository;

import com.wsd.modules.order.dto.MaxSaleDateResponseDTO;
import com.wsd.modules.order.dto.TotalSaleAmountResponseDTO;
import com.wsd.modules.order.dto.TotalSellingProductResponseDTO;
import com.wsd.modules.order.mapper.MaxSaleDateResponseMapper;
import com.wsd.modules.order.mapper.TotalSaleResponseMapper;
import com.wsd.modules.order.mapper.TotalSellingResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@RequiredArgsConstructor
@Repository
public class OrderJdbcRepositoryImpl implements OrderJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public TotalSaleAmountResponseDTO totalSaleAmount(String startDate, String endDate) {
        String sql = "SELECT SUM(total_amount) AS total_sale " +
                    "FROM orders " +
                    "WHERE order_date BETWEEN " +
                    "'"+startDate+"' AND '"+endDate+"'";

        return  jdbcTemplate.queryForObject(sql, new TotalSaleResponseMapper());
    }

    @Override
    public MaxSaleDateResponseDTO maxSaleDay(String startDate, String endDate) {
        String sql = "SELECT o.order_date, SUM(o.total_amount) AS total_amount" +
                        " FROM orders o WHERE o.order_date BETWEEN " +
                        "'"+startDate+"' AND '"+endDate+"' " +
                        "GROUP BY o.order_date ORDER BY SUM(o.total_amount) DESC limit 1";

        try{
            return  jdbcTemplate.queryForObject(sql, new MaxSaleDateResponseMapper());
        }
        catch(Exception e){
            return new MaxSaleDateResponseDTO();
        }
    }

    @Override
    public List<TotalSellingProductResponseDTO> topSellingProducts(Integer limit) {
        String sql = "SELECT p.id as product_id, SUM(od.total_amount) AS total_sale, p.name as product_name " +
                    "FROM order_details od " +
                    "LEFT JOIN products AS p ON p.id = od.product_id " +
                    "GROUP BY p.id ORDER BY total_sale DESC LIMIT "+limit;

        return jdbcTemplate.query(sql, new TotalSellingResponseMapper());
    }

    @Override
    public List<TotalSellingProductResponseDTO> topSellingProductsByTimeRange(String startDate, String endDate, Integer limit) {
        String sql = "SELECT p.id as product_id," +
                    "SUM(od.quantity) AS total_quantity, p.name as product_name " +
                    "FROM order_details od " +
                    "LEFT JOIN products AS p ON p.id = od.product_id " +
                    "LEFT JOIN orders AS o ON o.id = od.order_id " +
                    "WHERE order_date BETWEEN '"+startDate+"' AND '"+endDate+"' "  +
                    "GROUP BY p.id, p.name ORDER BY total_quantity DESC LIMIT "+limit;

        return jdbcTemplate.query(sql, new TotalSellingResponseMapper());
    }
}
