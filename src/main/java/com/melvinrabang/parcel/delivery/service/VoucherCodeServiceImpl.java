package com.melvinrabang.parcel.delivery.service;

import com.melvinrabang.parcel.delivery.integration.VoucherCodeClient;
import com.melvinrabang.parcel.delivery.dto.VoucherCodeResponse;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoucherCodeServiceImpl implements VoucherCodeService {

    private final VoucherCodeClient voucherCodeClient;

    @Value("${voucher-code.client.key}")
    private String apiKey;

    private static final int ONE_HUNDRED = 100;

    @Override
    public Optional<BigDecimal> getVoucherDiscountCode(String voucherCode) {
        Optional<BigDecimal> voucherCodeDiscount;
        try {
            VoucherCodeResponse voucherCodeResponse = voucherCodeClient.getVoucherCode(voucherCode, apiKey);
            voucherCodeDiscount = Optional.of(new BigDecimal(ONE_HUNDRED)
                    .subtract(new BigDecimal(voucherCodeResponse.getDiscount()))
                    .divide(new BigDecimal(ONE_HUNDRED)));
        } catch (FeignException e) {
            voucherCodeDiscount = Optional.empty();
        }
        return voucherCodeDiscount;
    }
}
