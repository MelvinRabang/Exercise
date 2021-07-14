package com.melvinrabang.parcel.delivery.service;

import com.melvinrabang.parcel.delivery.dto.ParcelDeliveryCostResponse;
import com.melvinrabang.parcel.delivery.exception.WeightTooHeavyException;
import com.melvinrabang.parcel.delivery.property.ParcelConfigurationProperty;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ParcelDeliveryCostServiceImpl implements ParcelDeliveryCostService {

    private final ParcelConfigurationProperty parcelConfigurationProperty;

    private final VoucherCodeService voucherCodeService;

    @Override
    public ParcelDeliveryCostResponse getParcelDeliveryCost(Integer weight, Integer height, Integer width,
                                                            Integer length, String voucherCode) throws Exception {

        BigDecimal parcelCost = calculateParcelDeliveryCost(weight, height * width * length);
        if (Objects.nonNull(voucherCode)) {
            Optional<BigDecimal> voucherCodeDiscount = voucherCodeService.getVoucherDiscountCode(voucherCode);
            if (voucherCodeDiscount.isPresent()) {
                parcelCost = parcelCost.multiply(voucherCodeDiscount.get());
            }
        }

        return ParcelDeliveryCostResponse.builder()
                .parcelCost(parcelCost)
                .parcelCostInPhp("PHP " + parcelCost)
                .build();
    }

    private BigDecimal calculateParcelDeliveryCost(Integer weight, Integer volume) throws WeightTooHeavyException {
        BigDecimal totalCost;
        BigDecimal weightBigDecimal = new BigDecimal(weight);
        BigDecimal volumeBigDecimcal = new BigDecimal(volume);

        if (parcelConfigurationProperty.getRejectWeight() < weight) {

            throw new WeightTooHeavyException();

        } else if (parcelConfigurationProperty.getRejectWeight() > weight &&
                weight > parcelConfigurationProperty.getHeavyWeight()) {

            totalCost = new BigDecimal(parcelConfigurationProperty.getHeavyWeightCost()).multiply(weightBigDecimal);

        } else if (parcelConfigurationProperty.getSmallVolume() > volume) {

            totalCost = new BigDecimal(parcelConfigurationProperty.getSmallVolumeCost()).multiply(volumeBigDecimcal);

        } else if (parcelConfigurationProperty.getMediumVolume() > volume) {

            totalCost = new BigDecimal(parcelConfigurationProperty.getHeavyWeightCost()).multiply(volumeBigDecimcal);

        } else {

            totalCost = new BigDecimal(parcelConfigurationProperty.getLargeVolumeCost()).multiply(volumeBigDecimcal);

        }
        return totalCost;
    }

}
