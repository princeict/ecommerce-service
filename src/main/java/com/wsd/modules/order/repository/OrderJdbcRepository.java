package com.wsd.modules.order.repository;


import com.wsd.modules.order.dto.MaxSaleDateResponseDTO;
import com.wsd.modules.order.dto.TotalSaleAmountResponseDTO;
import com.wsd.modules.order.dto.TotalSellingProductResponseDTO;
import java.util.List;

public interface OrderJdbcRepository {
    TotalSaleAmountResponseDTO totalSaleAmount(String startDate, String endDate);
    MaxSaleDateResponseDTO maxSaleDay(String startDate, String endDate);
    List<TotalSellingProductResponseDTO> topSellingProducts(Integer limit);
    List<TotalSellingProductResponseDTO> topSellingProductsByTimeRange(String startDate, String endDate, Integer limit);
}
