package com.melvinrabang.parcel.delivery.integration;

import com.melvinrabang.parcel.delivery.dto.VoucherCodeResponse;
import com.melvinrabang.parcel.delivery.integration.config.VoucherCodeClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
    url = "${voucher-code.client.base-url}",
    name = "VoucherCodeClient",
    configuration = VoucherCodeClientConfig.class
)
public interface VoucherCodeClient {

    @GetMapping("/{voucherCode}")
    VoucherCodeResponse getVoucherCode(@PathVariable("voucherCode") String voucherCode,
                                       @RequestParam("key") String key);
}
