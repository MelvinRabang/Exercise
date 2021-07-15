package com.melvinrabang.parcel.delivery.service;

import com.melvinrabang.parcel.delivery.dto.VoucherCodeResponse;
import com.melvinrabang.parcel.delivery.integration.VoucherCodeClient;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {
        VoucherCodeServiceImpl.class,
        VoucherCodeClient.class
})
public class VoucherCodeServiceTest {

    @MockBean
    VoucherCodeClient voucherCodeClient;

    @Autowired
    VoucherCodeServiceImpl voucherCodeService;

    @Test
    public void testWhenVoucherCodeInvalid() {
        when(voucherCodeClient.getVoucherCode(anyString(), anyString()))
                .thenThrow(FeignException.class);

        assertThat(voucherCodeService.getVoucherDiscountCode("ABA")).isInstanceOf(Optional.class);
    }

    @Test
    public void testWhenVoucherCodeValid() {
        when(voucherCodeClient.getVoucherCode(anyString(), anyString()))
                .thenReturn(VoucherCodeResponse.builder()
                        .code("MYNT")
                        .discount("12.5")
                        .build());

        assertThat(voucherCodeService.getVoucherDiscountCode("MYNT")).isInstanceOf(Optional.class);
        Optional<BigDecimal> voucherDiscountCode = voucherCodeService.getVoucherDiscountCode("MYNT");
        assertThat(voucherDiscountCode.get()).isEqualTo(new BigDecimal("0.875"));
    }

}
