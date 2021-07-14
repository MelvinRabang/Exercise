package com.melvinrabang.parcel.delivery.helper;

import java.math.BigDecimal;

public class VolumeCalculatorHelper {

    private VolumeCalculatorHelper() {}

    public static BigDecimal calculateVolume(Integer height, Integer width, Integer length) {
        return new BigDecimal(height).multiply(new BigDecimal(width)).multiply(new BigDecimal(length));
    }
}
