package models;

import java.util.ArrayList;
import java.util.List;

import enums.ParkingSpotType;

public class Floor {
  private int floorNumber;
  private List<ParkingSpot> spots;

  public Floor(int floorNumber, int smallSpots, int mediumSpots, int largeSpots) {
    this.floorNumber = floorNumber;
    this.spots = new ArrayList<>();

    int id = 1;
    for (int i = 0; i < smallSpots; i++) {
      spots.add(new ParkingSpot(id++, ParkingSpotType.SMALL, true));
    }
    for (int i = 0; i < mediumSpots; i++) {
      spots.add(new ParkingSpot(id++, ParkingSpotType.MEDIUM, true));
    }
    for (int i = 0; i < largeSpots; i++) {
      spots.add(new ParkingSpot(id++, ParkingSpotType.LARGE, true));
    }
  }

  public int getFloorNumber() {
    return this.floorNumber;
  }

  public List<ParkingSpot> getSpots() {
    return this.spots;
  }
}
