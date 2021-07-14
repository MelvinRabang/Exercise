package com.melvinrabang.parcel.delivery;

import com.melvinrabang.parcel.delivery.integration.VoucherCodeClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(clients = {
		VoucherCodeClient.class
})
@EnableConfigurationProperties
@SpringBootApplication
public class ParcelDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParcelDeliveryApplication.class, args);
	}

}
