import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Airline {

    private String name;
    private ArrayList<Flight> flights;
    private ArrayList<Passenger> customers;

    public Airline(String name){
        this.name = name;
        flights = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public ArrayList<Passenger> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Passenger> customers) {
        this.customers = customers;
    }

    public void addFlight(Flight flight){
        flights.add(flight);
    }

    public void cancelFlight(Flight flight){
        flights.remove(flight);
    }

    public void addCustomer(Passenger customer){
        customers.add(customer);
    }

    public void displayFlights(){

        for (Flight flight : flights){
            System.out.println(flight);
        }
    }

    public void searchFlights(String destinationName){
        for (Flight flight : flights){
            if (flight.getDestination().equalsIgnoreCase(destinationName)){
                System.out.println(flight);
            }
        }
    }

    public void exportFlights(){
        try{
            File flightsFile = new File("flights.txt");
            FileWriter flightFile1 = new FileWriter(flightsFile);
            for (Flight flight : flights){
                flightFile1.write(String.format("Flight number: %s, destination: %s\n",flight.getId(),flight.getDestination()));
            } flightFile1.close();

        } catch (IOException e){
            System.out.println("An error occurred.");
        }
    }


}
