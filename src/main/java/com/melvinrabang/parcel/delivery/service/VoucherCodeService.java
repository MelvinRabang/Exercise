package com.melvinrabang.parcel.delivery.service;

import java.math.BigDecimal;
import java.util.Optional;

public interface VoucherCodeService {

    Optional<BigDecimal> getVoucherDiscountCode(String voucherCode);
}
