package com.wsd.modules.order.controller;

import com.wsd.common.ResponseHandler;
import com.wsd.modules.order.dto.MaxSaleDateResponseDTO;
import com.wsd.modules.order.dto.TotalSaleAmountResponseDTO;
import com.wsd.modules.order.dto.TotalSellingProductResponseDTO;
import com.wsd.modules.order.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void fetchTotalSaleAmount() {
        String startDate = "2023-01-01";
        String endDate = "2023-12-31";
        TotalSaleAmountResponseDTO responseDTO = new TotalSaleAmountResponseDTO();

        when(orderService.fetchTotalSaleAmount(startDate, endDate)).thenReturn(responseDTO);

        ResponseEntity<?> response = orderController.fetchTotalSaleAmount(startDate, endDate);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseHandler.generateResponse(HttpStatus.OK, true, "Data Found", responseDTO), response);
        verify(orderService, times(1)).fetchTotalSaleAmount(startDate, endDate);
    }

    @Test
    void fetchMaxSaleAmount_DataFound() {
        String startDate = "2023-01-01";
        String endDate = "2023-12-31";
        MaxSaleDateResponseDTO responseDTO = new MaxSaleDateResponseDTO();
        responseDTO.setDate("2023-07-15");

        when(orderService.fetchMaxSaleDayByDateRange(startDate, endDate)).thenReturn(responseDTO);

        ResponseEntity<?> response = orderController.fetchMaxSaleAmount(startDate, endDate);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseHandler.generateResponse(HttpStatus.OK, true, "Data Found", responseDTO), response);
        verify(orderService, times(1)).fetchMaxSaleDayByDateRange(startDate, endDate);
    }

    @Test
    void fetchMaxSaleAmount_NoDataFound() {
        String startDate = "2023-01-01";
        String endDate = "2023-12-31";
        MaxSaleDateResponseDTO responseDTO = new MaxSaleDateResponseDTO();
        responseDTO.setDate(null);

        when(orderService.fetchMaxSaleDayByDateRange(startDate, endDate)).thenReturn(responseDTO);

        ResponseEntity<?> response = orderController.fetchMaxSaleAmount(startDate, endDate);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, false, "No Data Found", new ArrayList<>()), response);
        verify(orderService, times(1)).fetchMaxSaleDayByDateRange(startDate, endDate);
    }

    @Test
    void fetchTopSellingProduct_NoDataFound() {
        Integer limit = 10;
        when(orderService.fetchTopSellingProductByLimit(limit)).thenReturn(new ArrayList<>());

        ResponseEntity<?> response = orderController.fetchTopSellingProduct(limit);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseHandler.generateResponse(HttpStatus.OK, false, "No Data Found", new ArrayList<>()), response);
        verify(orderService, times(1)).fetchTopSellingProductByLimit(limit);
    }

    @Test
    void fetchTopSellingProduct_DataFound() {
        Integer limit = 10;
        List<TotalSellingProductResponseDTO> productList = new ArrayList<>();
        productList.add(new TotalSellingProductResponseDTO());

        when(orderService.fetchTopSellingProductByLimit(limit)).thenReturn(productList);

        ResponseEntity<?> response = orderController.fetchTopSellingProduct(limit);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseHandler.generateResponse(HttpStatus.OK, true, "Data Found", productList), response);
        verify(orderService, times(1)).fetchTopSellingProductByLimit(limit);
    }

    @Test
    void fetchTopSellingProductByTime_NoDataFound() {
        String startDate = "2023-01-01";
        String endDate = "2023-12-31";
        Integer limit = 10;
        when(orderService.fetchTopSellingProductByLimitAndTime(startDate, endDate, limit)).thenReturn(new ArrayList<>());

        ResponseEntity<?> response = orderController.fetchTopSellingProductByTime(startDate, endDate, limit);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseHandler.generateResponse(HttpStatus.OK, false, "No Data Found", new ArrayList<>()), response);
        verify(orderService, times(1)).fetchTopSellingProductByLimitAndTime(startDate, endDate, limit);
    }

    @Test
    void fetchTopSellingProductByTime_DataFound() {
        String startDate = "2023-01-01";
        String endDate = "2023-12-31";
        Integer limit = 10;
        List<TotalSellingProductResponseDTO> productList = new ArrayList<>();
        productList.add(new TotalSellingProductResponseDTO());

        when(orderService.fetchTopSellingProductByLimitAndTime(startDate, endDate, limit)).thenReturn(productList);

        ResponseEntity<?> response = orderController.fetchTopSellingProductByTime(startDate, endDate, limit);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseHandler.generateResponse(HttpStatus.OK, true, "Data Found", productList), response);
        verify(orderService, times(1)).fetchTopSellingProductByLimitAndTime(startDate, endDate, limit);
    }
}