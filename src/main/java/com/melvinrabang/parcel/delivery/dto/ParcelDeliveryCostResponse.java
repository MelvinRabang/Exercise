package com.melvinrabang.parcel.delivery.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonPropertyOrder({
    "parcelCost",
    "parcelCostInPhp"
})
public class ParcelDeliveryCostResponse {

    private BigDecimal parcelCost;

    private String parcelCostInPhp;
}
