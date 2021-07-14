package com.melvinrabang.parcel.delivery.controller;

import com.melvinrabang.parcel.delivery.dto.ParcelDeliveryCostResponse;
import com.melvinrabang.parcel.delivery.service.ParcelDeliveryCostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/parcel-cost")
public class ParcelDeliveryCostController {

    private final ParcelDeliveryCostService parcelDeliveryCostService;

    @GetMapping
    public ParcelDeliveryCostResponse getParcelDeliveryCost(@RequestParam(required = true) Integer weight,
                                                            @RequestParam(required = true) Integer height,
                                                            @RequestParam(required = true) Integer width,
                                                            @RequestParam(required = true) Integer length,
                                                            @RequestParam(required = false) String voucherCode) throws Exception {
        return parcelDeliveryCostService.getParcelDeliveryCost(weight, height, width, length, voucherCode);

    }

}
