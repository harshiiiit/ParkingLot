package parkinglot;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import enums.ParkingSpotType;
import enums.VehicleType;
import models.Floor;
import models.ParkingSpot;
import models.ParkingTicket;
import models.Vehicle;
import strategy.BasicPricingStrategy;
import strategy.PricingStrategy;

public class ParkingLot {

  private List<Floor> floors;
  private PricingStrategy pricingStrategy;
  private List<ParkingTicket> tickets;
  private int ticketCounter;

  public ParkingLot(int numberOfFloors, int smallSpots, int mediumSpots, int largeSpots) {
    this.floors = new ArrayList<>();
    this.pricingStrategy = new BasicPricingStrategy();
    this.tickets = new ArrayList<>();
    this.ticketCounter = 1;
    for (int i = 1; i <= numberOfFloors; i++) {
      floors.add(new Floor(i, smallSpots, mediumSpots, largeSpots));
    }
  }

  public ParkingTicket parkVehicle(Vehicle vehicle) {
    ParkingSpotType requiredType = getSpotType(vehicle.vehicleType());

    for (Floor floor : floors) {
      for (ParkingSpot spot : floor.getSpots()) {
        if (spot.getIsAvailable() && spot.getParkingSpotType() == requiredType) {
          spot.setIsAvailable(false);
          ParkingTicket ticket =
              new ParkingTicket(ticketCounter++, vehicle, spot, LocalDateTime.now());
          tickets.add(ticket);
          System.out.println(
              "Parked"
                  + vehicle.vehicleNumber()
                  + " at Floor "
                  + floor.getFloorNumber()
                  + ", Spot "
                  + spot.getSpotId());
          return ticket;
        }
      }
    }

    System.out.println("No available spot for " + vehicle.getVehicleType());
    return null;
  }

  public double unparkVehicle(int ticketId) {
    ParkingTicket ticket = findTicket(ticketId);

    if (ticket == null) {
      System.out.println("Invalid Ticket: " + ticketId);
      return -1;
    }

    ticket.setExitTime(LocalDateTime.now());
    ticket.getSpot().setIsAvailable(true);

    long hours = Duration.between(ticket.getEntryTime(), ticket.getExitTime()).toHours();

    if (hours == 0) hours = 1;

    double fee = pricingStrategy.calculateFee(ticket.getVehicle().getVehicleType(), hours);

    System.out.println("Unparked" + ticket.getVehicle().vehicleNumber() + ", Fee: " + fee);
    return fee;
  }

  public void display() {
    for (Floor floor : floors) {
      System.out.println("Floor " + floor.getFloorNumber() + ":");
      for (ParkingSpot spot : floor.getSpots()) {
        String status = spot.getIsAvailable() ? "FREE" : "OCCUPIED";
        System.out.println(
            " SPOT " + spot.getSpotId() + " [" + spot.getParkingSpotType() + "] " + status);
      }
    }
  }

  private ParkingSpotType getSpotType(VehicleType vehicleType) {
    switch (vehicleType) {
      case BIKE:
        return ParkingSpotType.SMALL;
      case CAR:
        return ParkingSpotType.MEDIUM;
      case TRUCK:
        return ParkingSpotType.LARGE;
      default:
        return ParkingSpotType.MEDIUM;
    }
  }

  private ParkingTicket findTicket(int ticketId) {
    for (ParkingTicket ticket : tickets) {
      if (ticket.getTicketId() == ticketId) {
        return ticket;
      }
    }
    return null;
  }
}
