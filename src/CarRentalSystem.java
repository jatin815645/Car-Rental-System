import java.util.ArrayList;
import java.util.List;

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
            }
        }
    }
}
