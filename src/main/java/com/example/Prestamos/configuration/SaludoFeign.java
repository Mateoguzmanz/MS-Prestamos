package com.example.Prestamos.configuration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("spring-cloud-eureka-client")
public interface SaludoFeign {

    @RequestMapping("/saludo")
    String saludo();

}
