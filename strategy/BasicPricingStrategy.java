package strategy;

import java.util.HashMap;
import java.util.Map;

import enums.VehicleType;

public class BasicPricingStrategy implements PricingStrategy {

  private Map<VehicleType, Double> hourlyRates;

  public BasicPricingStrategy() {
    hourlyRates = new HashMap<>();
    hourlyRates.put(VehicleType.BIKE, 10.0);
    hourlyRates.put(VehicleType.CAR, 20.0);
    hourlyRates.put(VehicleType.TRUCK, 40.0);
  }

  @Override
  public double calculateFee(VehicleType vehicleType, long hoursParked) {
    return hourlyRates.get(vehicleType) * hoursParked;
  }
}
