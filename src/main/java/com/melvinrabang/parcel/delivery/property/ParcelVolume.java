package com.melvinrabang.parcel.delivery.property;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@Component
public class ParcelVolume {

    private String small;

    private String medium;

    private String smallcost;

    private String mediumcost;

    private String largecost;
}
