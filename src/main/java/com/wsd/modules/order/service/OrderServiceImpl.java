package com.wsd.modules.order.service;


import com.wsd.exception.ObjectNotFoundException;
import com.wsd.modules.order.dto.MaxSaleDateResponseDTO;
import com.wsd.modules.order.dto.TotalSaleAmountResponseDTO;
import com.wsd.modules.order.dto.TotalSellingProductResponseDTO;
import com.wsd.modules.order.repository.OrderJdbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderJdbcRepository orderJdbcRepository;
    @Override
    public TotalSaleAmountResponseDTO fetchTotalSaleAmount(String startDate, String endDate) {
        LocalDate now = LocalDate.now();
        String formatStartDate = (startDate != null ? startDate : now.toString()) + " 00:00:00";
        String formatEndDate = (endDate != null ? endDate : now.toString()) + " 23:59:59";
        TotalSaleAmountResponseDTO returnValue = orderJdbcRepository.totalSaleAmount(formatStartDate, formatEndDate);
        return returnValue;
    }

    @Override
    public MaxSaleDateResponseDTO fetchMaxSaleDayByDateRange(String startDate, String endDate) {
        String formatStartDate = startDate+" 00:00:00";
        String formatEndDate   = endDate+" 23:59:59";
        MaxSaleDateResponseDTO returnValue= orderJdbcRepository.maxSaleDay(formatStartDate, formatEndDate);
        return returnValue;
    }

    @Override
    public List<TotalSellingProductResponseDTO> fetchTopSellingProductByLimit(Integer limit) {
        List<TotalSellingProductResponseDTO> returnValue = orderJdbcRepository.topSellingProducts(limit);
        return returnValue;
    }

    @Override
    public List<TotalSellingProductResponseDTO> fetchTopSellingProductByLimitAndTime(String startDate, String endDate, Integer limit) {
        LocalDate now = LocalDate.now();
        YearMonth lastMonth = YearMonth.from(now).minusMonths(1);
        LocalDate startOfLastMonth = lastMonth.atDay(1);
        LocalDate endOfLastMonth = lastMonth.atEndOfMonth();
        String formatStartDate = (startDate != null ? startDate : startOfLastMonth.toString()) + " 00:00:00";
        String formatEndDate = (endDate != null ? endDate : endOfLastMonth.toString()) + " 23:59:59";
        List<TotalSellingProductResponseDTO> returnValue = orderJdbcRepository.topSellingProductsByTimeRange(formatStartDate, formatEndDate, limit);
        return returnValue;
    }
}
