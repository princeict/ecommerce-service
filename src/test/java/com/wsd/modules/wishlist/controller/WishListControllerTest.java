package com.wsd.modules.wishlist.controller;

import com.wsd.common.ResponseHandler;
import com.wsd.modules.wishlist.dto.CustomerWishListResponseDTO;
import com.wsd.modules.wishlist.service.WishListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WishListControllerTest {

    @Mock
    private WishListService wishListService;

    @InjectMocks
    private WishListController wishListController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllByCustomerId_NoDataFound() {
        Long customerId = 2L;
        when(wishListService.fetchByCustomerId(customerId)).thenReturn(new ArrayList<>());

        ResponseEntity<?> response = wishListController.findAllByCustomerId(customerId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseHandler.generateResponse(HttpStatus.OK, false, "No Data Found", new ArrayList<>()), response);
        verify(wishListService, times(1)).fetchByCustomerId(customerId);
    }

    @Test
    void findAllByCustomerId_DataFound() {
        Long customerId = 1L;
        List<CustomerWishListResponseDTO> wishList = new ArrayList<>();
        wishList.add(new CustomerWishListResponseDTO());

        when(wishListService.fetchByCustomerId(customerId)).thenReturn(wishList);

        ResponseEntity<?> response = wishListController.findAllByCustomerId(customerId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseHandler.generateResponse(HttpStatus.OK, true, "Data Found", wishList), response);
        verify(wishListService, times(1)).fetchByCustomerId(customerId);
    }
}