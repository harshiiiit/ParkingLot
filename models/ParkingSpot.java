package models;

import enums.ParkingSpotType;

public class ParkingSpot {

  private int spotId;
  private ParkingSpotType parkingSpotType;
  private boolean isAvailable; // false: By default (Not null)

  public ParkingSpot(int spotId, ParkingSpotType parkingSpotType, boolean isAvailable) {
    this.spotId = spotId;
    this.parkingSpotType = parkingSpotType;
    this.isAvailable = isAvailable;
  }

  public int getSpotId() {
    return this.spotId;
  }

  public ParkingSpotType getParkingSpotType() {
    return this.parkingSpotType;
  }

  public boolean getIsAvailable() {
    return this.isAvailable;
  }

  public void setIsAvailable(boolean available) {
    this.isAvailable = available;
  }
}
