package com.example.demo.controller; // Adjusted package name

import com.example.demo.model.Parcel;
import com.example.demo.service.ShippingCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/shipping")
public class ShippingCalculatorController {

    @Autowired
    private ShippingCalculatorService shippingCalculatorService;

    @PostMapping("/calculate")
    public Map<String, Double> calculateShipping(@RequestBody List<Parcel> parcels) {
        double totalFee = shippingCalculatorService.calculateShippingFee(parcels);
        return Map.of("total_shipping_fee", totalFee);
    }
}
