package com.melvinrabang.parcel.delivery.service;

import com.melvinrabang.parcel.delivery.dto.ParcelDeliveryCostResponse;

public interface ParcelDeliveryCostService {

    ParcelDeliveryCostResponse getParcelDeliveryCost(Integer weight, Integer height, Integer width, Integer length,
                                                     String voucherCode) throws Exception;
}
