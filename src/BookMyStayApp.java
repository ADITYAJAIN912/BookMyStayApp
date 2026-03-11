import java.util.Scanner;

public class BookMyStayApp {

    // Centralized inventory with total rooms
    static String[] roomTypes = {"Single Room", "Double Room", "Deluxe Room", "Suite"};
    static int[] totalRooms = {10, 5, 3, 2};
    static int[] availableRooms = {10, 5, 3, 2};

    // Starting room numbers for each type
    static int[] nextRoomNumber = {101, 201, 301, 401};

    // Display availability
    public static void showAvailability() {
        System.out.println("\nCurrent Room Availability:");
        for (int i = 0; i < roomTypes.length; i++) {
            System.out.println((i + 1) + ". " + roomTypes[i] + " - " + availableRooms[i] + " rooms available");
        }
    }

    // Search room index
    public static int searchRoom(String query) {
        for (int i = 0; i < roomTypes.length; i++) {
            if (roomTypes[i].toLowerCase().contains(query.toLowerCase())) {
                return i;
            }
        }
        return -1; // Not found
    }

    // Handle booking and allocate room numbers
    public static void handleBooking(Scanner sc) {
        System.out.print("Enter room type to book: ");
        String roomQuery = sc.nextLine();

        int roomIndex = searchRoom(roomQuery);
        if (roomIndex == -1) {
            System.out.println("Room type not found.");
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
            // Allocate room numbers
            System.out.println("Booking Confirmed! Your allocated room numbers:");
            for (int i = 0; i < qty; i++) {
                System.out.print(nextRoomNumber[roomIndex] + " ");
                nextRoomNumber[roomIndex]++;
            }
            System.out.println();

            // Update availability
            availableRooms[roomIndex] -= qty;
        } else {
            System.out.println("Booking failed! Only " + availableRooms[roomIndex] + " rooms available.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Book My Stay - Reservation Confirmation & Room Allocation");

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Show Room Availability");
            System.out.println("2. Book & Allocate Rooms");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    showAvailability();
                    break;
                case 2:
                    handleBooking(sc);
                    break;
                case 3:
                    running = false;
                    System.out.println("Thank you for using Book My Stay!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}