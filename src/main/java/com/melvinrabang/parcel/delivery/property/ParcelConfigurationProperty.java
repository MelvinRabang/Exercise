package com.melvinrabang.parcel.delivery.property;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@Component
@ConfigurationProperties("parcel")
public class ParcelConfigurationProperty {

    private Integer rejectWeight;

    private Integer heavyWeight;

    private String heavyWeightCost;

    private Integer smallVolume;

    private Integer mediumVolume;

    private String smallVolumeCost;

    private String mediumVolumeCost;

    private String largeVolumeCost;

}
