import enums.VehicleType;
import models.ParkingTicket;
import models.Vehicle;
import parkinglot.ParkingLot;

import enums.VehicleType;
import models.ParkingTicket;
import models.Vehicle;
import parkinglot.ParkingLot;

public class Main {
  public static void main(String[] args) {
    // Create parking lot: 2 floors, 2 small, 2 medium, 2 large spots each
    ParkingLot lot = new ParkingLot(2, 2, 2, 2);
    // Display empty lot
    System.out.println("=== Initial State ===");
    lot.display();
    // Create vehicles
    Vehicle bike1 = new Vehicle("KA-01-BIKE-1111", VehicleType.BIKE);
    Vehicle bike2 = new Vehicle("KA-01-BIKE-2222", VehicleType.BIKE);
    Vehicle car1 = new Vehicle("KA-01-CAR-3333", VehicleType.CAR);
    Vehicle truck1 = new Vehicle("KA-01-TRUCK-4444", VehicleType.TRUCK);
    // Park vehicles
    System.out.println("\n=== Parking Vehicles ===");
    ParkingTicket ticket1 = lot.parkVehicle(bike1);
    ParkingTicket ticket2 = lot.parkVehicle(bike2);
    ParkingTicket ticket3 = lot.parkVehicle(car1);
    ParkingTicket ticket4 = lot.parkVehicle(truck1);
    // Display after parking
    System.out.println("\n=== After Parking ===");
    lot.display();
    // Unpark bike1
    System.out.println("\n=== Unparking Bike 1 ===");
    double fee = lot.unparkVehicle(ticket1.getTicketId());
    // Display after unparking
    System.out.println("\n=== After Unparking ===");
    lot.display();
    // Park another vehicle in freed spot
    System.out.println("\n=== Parking New Bike ===");
    Vehicle bike3 = new Vehicle("KA-01-BIKE-5555", VehicleType.BIKE);
    lot.parkVehicle(bike3);
    // Final display
    System.out.println("\n=== Final State ===");
    lot.display();
  }
}
