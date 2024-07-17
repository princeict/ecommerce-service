package com.wsd.modules.wishlist.controller;

import com.wsd.common.ResponseHandler;
import com.wsd.modules.wishlist.dto.CustomerWishListResponseDTO;
import com.wsd.modules.wishlist.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/wish-lists")
@RequiredArgsConstructor
public class WishListController {
    private final WishListService service;

    @GetMapping("/all")
    public ResponseEntity<?> findAllByCustomerId(@RequestParam("customerId") Long customerId){
        List<CustomerWishListResponseDTO> returnValue = service.fetchByCustomerId(customerId);
        if (returnValue.isEmpty()) {
            return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, false, "No Data Found", new ArrayList<>());
        }

        return ResponseHandler.generateResponse(HttpStatus.OK, true, "Data Found", returnValue);
    }
}
