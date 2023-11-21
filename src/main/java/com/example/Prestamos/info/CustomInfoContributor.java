package com.example.Prestamos.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        // Agregar información personalizada sobre Java y el sistema operativo
        builder.withDetail("java", System.getProperty("java.version"));
        builder.withDetail("os", System.getProperty("os.name"));
    }
}
