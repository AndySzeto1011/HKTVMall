package com.example.demo.service; 

import com.example.demo.model.Parcel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingCalculatorService {

    // Calculate the total shipping fee for a list of parcels
    public double calculateShippingFee(List<Parcel> parcels) {
        double totalFee = 0.0;
        
        for (Parcel parcel : parcels) {
            // Calculate the volumetric weight
            double volumetricWeight = (parcel.getLength() * parcel.getWidth() * parcel.getHeight()) / 5000;
            // Get the chargeable weight (whichever is higher between physical weight with user input and volumetric weight)
            double chargeableWeight = Math.max(parcel.getWeight(), volumetricWeight);
            
            // Get the shipping rate for the parcel based on temperature condition and chargeable weight
            double rate = getShippingRate(chargeableWeight, parcel.getTemperature());
            
            // Calculate total fee for the parcel based on rate and quantity
            totalFee += rate * parcel.getQuantity();
        }

        return totalFee;
    }

    // Calculate the shipping rate based on temperature condition and chargeable weight
    private double getShippingRate(double chargeableWeight, String temperatureCondition) {
        if ("Ambient".equalsIgnoreCase(temperatureCondition)) {
            // $10 per kg for Ambient <= 5 kg, $15 for Ambient > 5 kg
            return (chargeableWeight <= 5) ? 10 : 15; 
        } else if ("Chill".equalsIgnoreCase(temperatureCondition)) {
            // $20 per kg for Chill <= 5 kg, $30 for Chill > 5 kg
            return (chargeableWeight <= 5) ? 20 : 30;
        }
        // Default case (although in your business logic, temperature should always be either "Ambient" or "Chill")
        return 0.0; 
    }
}
