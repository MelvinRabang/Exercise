package com.melvinrabang.parcel.delivery.controller;

import com.melvinrabang.parcel.delivery.dto.ParcelDeliveryCostResponse;
import com.melvinrabang.parcel.delivery.exception.WeightTooHeavyException;
import com.melvinrabang.parcel.delivery.service.ParcelDeliveryCostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {
        ParcelDeliveryCostController.class,
        ParcelDeliveryCostService.class
})
public class ParcelDeliveryCostControllerTest {

    @MockBean
    private ParcelDeliveryCostService parcelDeliveryCostService;

    @Autowired
    private ParcelDeliveryCostController parcelDeliveryCostController;

    @Test
    public void returnParcelScoreWhenValidWeight() throws Exception {
        when(parcelDeliveryCostService.getParcelDeliveryCost(anyInt(), anyInt(), anyInt(), anyInt(), anyString()))
                .thenReturn(ParcelDeliveryCostResponse.builder()
                        .parcelCost(new BigDecimal(30))
                        .parcelCostInPhp("PHP 30")
                        .build());

        ParcelDeliveryCostResponse parcelDeliveryCostResponse =
                parcelDeliveryCostController.getParcelDeliveryCost(15, 10, 10, 10, "MEL");

        assertThat(parcelDeliveryCostResponse.getParcelCost()).isNotNull();
        assertThat(parcelDeliveryCostResponse).isNotNull();
        assertThat(parcelDeliveryCostResponse.getParcelCostInPhp()).isNotNull();
        assertThat(parcelDeliveryCostResponse.getParcelCostInPhp()).isEqualTo("PHP 30");
    }

    @Test
    public void returnExceptionWhenNotValidWeight() throws Exception {
        when(parcelDeliveryCostService.getParcelDeliveryCost(anyInt(), anyInt(), anyInt(), anyInt(), anyString()))
                .thenThrow(WeightTooHeavyException.class);

        assertThatThrownBy(() -> parcelDeliveryCostController.getParcelDeliveryCost(78, 10, 10, 10, "MEL"))
                .isInstanceOf(WeightTooHeavyException.class);
    }

}
