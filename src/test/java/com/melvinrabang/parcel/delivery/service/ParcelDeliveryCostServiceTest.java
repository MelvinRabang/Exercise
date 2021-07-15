package com.melvinrabang.parcel.delivery.service;

import com.melvinrabang.parcel.delivery.dto.ParcelDeliveryCostResponse;
import com.melvinrabang.parcel.delivery.property.ParcelConfigurationProperty;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {
      ParcelDeliveryCostServiceImpl.class,
      VoucherCodeService.class
})
@TestPropertySource(locations="classpath:test.yml")
public class ParcelDeliveryCostServiceTest {

    @MockBean
    ParcelConfigurationProperty parcelConfigurationProperty;

    @MockBean
    VoucherCodeService voucherCodeService;

    @Autowired
    ParcelDeliveryCostServiceImpl parcelDeliveryCostService;

    @Before
    public void initMock(){
        Mockito.when(parcelConfigurationProperty.getHeavyWeight()).thenReturn(50);
    }

    @Ignore
    public void testParcelCostWithoutVoucherCode() throws Exception {
        ParcelDeliveryCostResponse parcelDeliveryCostResponse =
                parcelDeliveryCostService.getParcelDeliveryCost(5, 10, 10, 10, null);

        assertThat(parcelDeliveryCostResponse).isInstanceOf(ParcelDeliveryCostResponse.class);
    }

}
