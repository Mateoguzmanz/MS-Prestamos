package com.example.Prestamos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FeignController {

    @RequestMapping("/get-saludo")
    public String saludoFeign() {
        return "Hola";
    }
}
