package com.wsd.modules.order.service;

import com.wsd.modules.order.dto.MaxSaleDateResponseDTO;
import com.wsd.modules.order.dto.TotalSaleAmountResponseDTO;
import com.wsd.modules.order.dto.TotalSellingProductResponseDTO;
import java.util.List;

public interface OrderService {
    TotalSaleAmountResponseDTO fetchTotalSaleAmount(String startDate, String endDate);
    MaxSaleDateResponseDTO fetchMaxSaleDayByDateRange(String startDate, String endDate);
    List<TotalSellingProductResponseDTO> fetchTopSellingProductByLimit(Integer limit);
    List<TotalSellingProductResponseDTO> fetchTopSellingProductByLimitAndTime(String startDate, String endDate, Integer limit);
}
