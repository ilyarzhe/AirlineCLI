import java.util.Scanner;

public class Runner {
    private static boolean isRunning = true;
    public static void main(String[] args){
        Airline ba = new Airline("British Airways");
        Scanner scanner = new Scanner(System.in);
        while (isRunning){
            action(ba, displayMenu(ba, scanner), scanner,isRunning);
            }
        /// Running some tests
        for(Passenger passenger:ba.getFlights().get(0).getPassengers()){
            System.out.println(passenger);
        }
    }


    // Display Menu for the user
    // User Inputs the action
    // Based on input initialise the method
    public static int displayMenu(Airline airline, Scanner scanner){
        System.out.println(String.format("Welcome to %s",airline.getName()));
        System.out.println("Type 1 to add a customer");
        System.out.println("Type 2 to add a flight");
        System.out.println("Type 3 to display all flights");
        System.out.println("Type 4 to cancel a flight");
        System.out.println("Type 5 to book a passenger onto a flight");
        System.out.println("Type 6 to exit menu");
        int userInput = scanner.nextInt();
        scanner.nextLine();
        return userInput;
    }


    public static void action(Airline airline, int userInput, Scanner scanner,boolean isRunning){
        if (userInput == 1){
            System.out.println("Type in customer name: ");
            String customerName = scanner.nextLine();
            System.out.println("Type in customer number: ");
            int customerNumber = scanner.nextInt();
            System.out.println("Type in customer id: ");
            int customerId = scanner.nextInt();
            scanner.nextLine();
            airline.addCustomer(new Passenger(customerName, customerNumber, customerId));
        } else if (userInput == 2){
            System.out.println("Type in flight destination: ");
            String flightDestination = scanner.nextLine();
            System.out.println("Type in flight id: ");
            int flightId = scanner.nextInt();
            airline.addFlight(new Flight(flightDestination, flightId));
        } else if (userInput == 3){
            airline.displayFlights();
        } else if (userInput == 4){
            System.out.println("Type in flight destination: ");
            String flightDestination = scanner.nextLine();
            System.out.println("Type in flight id: ");
            int flightId = scanner.nextInt();
            scanner.nextLine();
            // go through the list of flights
            // check if the flight destination and flightId matches input
            // cancelflight
            Flight flightToRemove = null;
            for (Flight flight : airline.getFlights()){
                if (flight.getDestination().equalsIgnoreCase(flightDestination) && flight.getId() == flightId){
                    flightToRemove = flight;
                }
            }
            airline.cancelFlight(flightToRemove);
        } else if (userInput == 5){
            System.out.println("Type in customer name: ");
            String customerName = scanner.nextLine();
            System.out.println("Type in customer number: ");
            int customerNumber = scanner.nextInt();
            System.out.println("Type in customer id");
            int customerId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Type in flight destination: ");
            String flightDestination = scanner.nextLine();
            System.out.println("Type in flight id: ");
            int flightId = scanner.nextInt();
            scanner.nextLine();
            for (Flight flight : airline.getFlights()){
                if (flight.getDestination().equalsIgnoreCase(flightDestination) && flight.getId() == flightId){
                    for (Passenger passenger : airline.getCustomers()){
                        if(passenger.getName().equalsIgnoreCase(customerName) && passenger.getPhoneNumber() == customerNumber && passenger.getId() == customerId){
                            flight.bookPassenger(passenger);
                        }
                    }
                    Passenger passengerToAdd = new Passenger(customerName, customerNumber, customerId);
                    flight.bookPassenger(passengerToAdd);
                    airline.addCustomer(passengerToAdd);
                }
            }
        } else if (userInput == 6){
            System.out.println("Goodbye.");
            Runner.isRunning = false;
        }
    }


}
