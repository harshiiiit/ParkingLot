package models;

import java.time.LocalDateTime;

public class ParkingTicket {

  private int ticketId;
  private Vehicle vehicle;
  private ParkingSpot spot;
  private LocalDateTime entryTime;
  private LocalDateTime exitTime;

  public ParkingTicket(int ticketId, Vehicle vehicle, ParkingSpot spot, LocalDateTime entryTime) {
    this.ticketId = ticketId;
    this.vehicle = vehicle;
    this.spot = spot;
    this.entryTime = entryTime;
    this.exitTime = null;
  }

  public int getTicketId() {
    return this.ticketId;
  }

  public Vehicle getVehicle() {
    return this.vehicle;
  }

  public ParkingSpot getSpot() {
    return this.spot;
  }

  public LocalDateTime getEntryTime() {
    return this.entryTime;
  }

  public LocalDateTime getExitTime() {
    return this.exitTime;
  }

  public void setExitTime(LocalDateTime exitTime) {
    this.exitTime = exitTime;
  }
}
