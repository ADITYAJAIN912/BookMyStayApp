import java.util.Scanner;

public class BookMyStayApp {

    // Centralized room inventory
    static String[] roomTypes = {"Single Room", "Double Room", "Deluxe Room", "Suite"};
    static int[] availableRooms = {10, 5, 3, 2}; // initial availability

    // Display current availability
    public static void showAvailability() {
        System.out.println("\nCurrent Room Availability:");
        for (int i = 0; i < roomTypes.length; i++) {
            System.out.println((i + 1) + ". " + roomTypes[i] + " - " + availableRooms[i] + " rooms available");
        }
    }

    // Search for a room type
    public static int searchRoom(String query) {
        for (int i = 0; i < roomTypes.length; i++) {
            if (roomTypes[i].toLowerCase().contains(query.toLowerCase())) {
                return i; // return index of first match
            }
        }
        return -1; // not found
    }

    // Handle booking request
    public static void handleBookingRequest(Scanner sc) {
        System.out.print("Enter room type you want to book: ");
        String roomQuery = sc.nextLine();

        int roomIndex = searchRoom(roomQuery);
        if (roomIndex == -1) {
            System.out.println("Room type not found. Please try again.");
            return;
        }

        System.out.println(roomTypes[roomIndex] + " - " + availableRooms[roomIndex] + " rooms available.");
        System.out.print("Enter number of rooms to book: ");
        int qty = sc.nextInt();
        sc.nextLine(); // consume newline

        if (qty <= 0) {
            System.out.println("Invalid quantity.");
            return;
        }

        if (availableRooms[roomIndex] >= qty) {
            availableRooms[roomIndex] -= qty;
            System.out.println("Booking confirmed! " + qty + " " + roomTypes[roomIndex] + "(s) booked successfully.");
        } else {
            System.out.println("Booking failed! Only " + availableRooms[roomIndex] + " rooms available.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Book My Stay - Booking Request");

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Show Room Availability");
            System.out.println("2. Make a Booking Request");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    showAvailability();
                    break;
                case 2:
                    handleBookingRequest(sc);
                    break;
                case 3:
                    running = false;
                    System.out.println("Thank you for using Book My Stay!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}