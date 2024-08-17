import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {

    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem(){
        cars = new ArrayList<Car>();
        customers = new ArrayList<Customer>();
        rentals = new ArrayList<Rental>();
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days){
        if (car.isAvailable()){
            car.rent();
            rentals.add(new Rental(car,customer,days));
        }
        else {
            System.out.println("Car is not available to rent");
        }
    }

    public void returnCar(Car car){
        car.returnCar();
        Rental rentalToRemove = null;
        for (Rental rental : rentals){
            if (rental.getCar() == car){
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null){
            rentals.remove(rentalToRemove);
        }
        else {
            System.out.println("Car was not rented");
        }
    }


    public void menu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("======= Car rental System ========");
        System.out.println("1. Rent a car ");
        System.out.println("2. Return a Car");
        System.out.println("3. Exit ");
        System.out.print("Enter your Choice");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1){
            System.out.println("=== Rent a car ===");
            System.out.println("Enter your name");
            String customerName = sc.nextLine();

            System.out.println("--- Available Cars ---");
            for (Car car : cars){
                if (car.isAvailable()){
                    System.out.println(car.getCarId()+" - "+ car.getBrand()+ " "+ car.getModel());
                }
            }


            System.out.println("Enter the car Id you want to rent");
            String carId = sc.nextLine();

            System.out.println("Enter no.of days you want to rent the car");
            int rentalDays = sc.nextInt();
            sc.nextLine();

            Customer newCustomer = new Customer("CUS" + (customers.size() + 1) , customerName);
            addCustomer(newCustomer);


        }
    }


}
