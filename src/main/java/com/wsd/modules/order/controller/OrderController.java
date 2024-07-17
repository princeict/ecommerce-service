package com.wsd.modules.order.controller;

import com.wsd.common.ResponseHandler;
import com.wsd.modules.order.dto.MaxSaleDateResponseDTO;
import com.wsd.modules.order.dto.TotalSaleAmountResponseDTO;
import com.wsd.modules.order.dto.TotalSellingProductResponseDTO;
import com.wsd.modules.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @GetMapping("/total-sale")
    public ResponseEntity<?> fetchTotalSaleAmount(@RequestParam(value = "startDate", required = false) String startDate, @RequestParam(value = "endDate", required = false) String endDate){
        TotalSaleAmountResponseDTO returnValue = service.fetchTotalSaleAmount(startDate,endDate);
        return ResponseHandler.generateResponse(HttpStatus.OK, true, "Data Found", returnValue);
    }

    @GetMapping("/max-sale-date")
    public ResponseEntity<?> fetchMaxSaleAmount(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        MaxSaleDateResponseDTO returnValue = service.fetchMaxSaleDayByDateRange(startDate,endDate);
        if (returnValue.getDate()==null) {
            return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, false, "No Data Found", new ArrayList<>());
        }
        return ResponseHandler.generateResponse(HttpStatus.OK, true, "Data Found", returnValue);
    }

    @GetMapping("/top-selling-products")
    public ResponseEntity<?> fetchTopSellingProduct(@RequestParam("limit") Integer limit) {
        List<TotalSellingProductResponseDTO> returnValue = service.fetchTopSellingProductByLimit(limit);
        if (returnValue.isEmpty()) {
            return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, false, "No Data Found", new ArrayList<>());
        }

        return ResponseHandler.generateResponse(HttpStatus.OK, true, "Data Found", returnValue);
    }

    @GetMapping("/top-selling-products-time-range")
    public ResponseEntity<?> fetchTopSellingProductByTime(@RequestParam(value = "startDate", required = false) String startDate, @RequestParam(value = "endDate", required = false) String endDate,@RequestParam("limit") Integer limit) {
        List<TotalSellingProductResponseDTO> returnValue = service.fetchTopSellingProductByLimitAndTime(startDate, endDate, limit);
        if (returnValue.isEmpty()) {
            return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, false, "No Data Found", new ArrayList<>());
        }

        return ResponseHandler.generateResponse(HttpStatus.OK, true, "Data Found", returnValue);
    }
}