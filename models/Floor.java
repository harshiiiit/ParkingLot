package models;

import java.util.ArrayList;
import java.util.List;

import enums.ParkingSpotType;

public class Floor {
  private int floorNumber;
  private List<ParkingSpot> spots;

  public Floor(int numberOfSpots, int floorNumber) {
    this.floorNumber = floorNumber;
    this.spots = new ArrayList<>();

    for (int i = 1; i <= numberOfSpots; i++) {
      spots.add(new ParkingSpot(i, ParkingSpotType.SMALL, true));
    }
  }

  public int getFloorNumber() {
    return this.floorNumber;
  }

  public List<ParkingSpot> getSpots() {
    return this.spots;
  }
}
