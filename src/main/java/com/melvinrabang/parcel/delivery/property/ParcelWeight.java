package com.melvinrabang.parcel.delivery.property;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@Component
public class ParcelWeight {

    private String reject;

    private String heavy;

    private String heavycost;
}
