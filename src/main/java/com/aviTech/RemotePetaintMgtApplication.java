package com.aviTech;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "RemotePatientMgt",version = "1.0",description = "Online patient management"))
public class RemotePetaintMgtApplication {

	public static void main(String[] args) {
		SpringApplication.run(RemotePetaintMgtApplication.class, args);
	}

}
