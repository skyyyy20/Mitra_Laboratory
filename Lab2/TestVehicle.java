import java.util.Scanner; 

class Vehicle {
    private String VehicleBrand;
    private int VehicleSpeed;
    private String VehiclefuelTtype;
 
    public Vehicle(String VehicleBrand, int VehicleSpeed, String VehiclefuelTtype) {
        this.VehicleBrand = VehicleBrand;
        this.VehicleSpeed = VehicleSpeed;
        this.VehiclefuelTtype = VehiclefuelTtype;
    }
 
    public String getVehicleBrand() {
        return VehicleBrand;
    }
 
    public void setVehicleBrand(String VehicleBrand) {
        this.VehicleBrand = VehicleBrand;
    }
 
    public int getVehicleSpeed() {
        return VehicleSpeed;
    }
 
    public String getVehiclefuelType() {
        return VehiclefuelTtype;
    }
 
    public void displayVehicleDetails() {
        System.out.println("Vehicle details: Brand - " + VehicleBrand + ", Speed - " + VehicleSpeed + " km/h, Fuel Type - " + VehiclefuelTtype);
    }
}
 
class Car extends Vehicle {
    private int numDoors;
 
    public Car(String carBrand, int carSpeed, String carfuelType, int numDoors) {
        super(carBrand, carSpeed, carfuelType);
        this.numDoors = numDoors;
    }
 
    @Override
    public void displayVehicleDetails() {
        super.displayVehicleDetails(); 
        System.out.println("Number of Doors: " + numDoors);
    }
}
 
class Motorcycle extends Vehicle {
    private boolean hasSidecar;
 
    public Motorcycle(String motorcycleBrand, int motorcycleSpeed, String motorcyclefuelType, boolean hasSidecar) {
        super(motorcycleBrand, motorcycleSpeed, motorcyclefuelType);
        this.hasSidecar = hasSidecar;
    }
 
    @Override
    public void displayVehicleDetails() {
        super.displayVehicleDetails(); 
        System.out.println("Has Sidecar: " + hasSidecar);
    }
}
 
class TestVehicle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Car details:");
        System.out.print("Brand: ");
        String carBrand = scanner.nextLine();
        System.out.print("Speed: ");
        int carSpeed = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Fuel Type: ");
        String carFuelType = scanner.nextLine();
        System.out.print("Number of Doors: ");
        int carNumDoors = scanner.nextInt();
        scanner.nextLine(); 
 

        Car car = new Car(carBrand, carSpeed, carFuelType, carNumDoors);
        car.displayVehicleDetails();
 

        System.out.println("Enter Motorcycle details:");
        System.out.print("Brand: ");
        String motorcycleBrand = scanner.nextLine();
        System.out.print("Speed: ");
        int motorcycleSpeed = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Fuel Type: ");
        String motorcycleFuelType = scanner.nextLine();
        System.out.print("Has Sidecar (true/false): ");
        boolean hasSidecar = scanner.nextBoolean();
 
        Motorcycle motorcycle = new Motorcycle(motorcycleBrand, motorcycleSpeed, motorcycleFuelType, hasSidecar);
        motorcycle.displayVehicleDetails();
 
        scanner.close();
    }
}