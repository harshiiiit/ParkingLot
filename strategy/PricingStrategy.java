package strategy;

import enums.VehicleType;

public interface PricingStrategy {

  double calculateFee(VehicleType vehicleType, long duration);
}
