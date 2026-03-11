import java.util.Scanner;

public class BookMyStayApp {

    // Room inventory
    static String[] roomTypes = {"Single Room", "Double Room", "Deluxe Room", "Suite"};
    static int[] availableRooms = {10, 5, 3, 2};
    static int[] nextRoomNumber = {101, 201, 301, 401};

    // Available add-on services
    static String[] services = {"Breakfast", "Airport Pickup", "Spa Access", "Extra Bed"};

    // Display room availability
    public static void showAvailability() {
        System.out.println("\nCurrent Room Availability:");
        for (int i = 0; i < roomTypes.length; i++) {
            System.out.println((i + 1) + ". " + roomTypes[i] + " - " + availableRooms[i] + " rooms available");
        }
    }

    // Search room
    public static int searchRoom(String query) {
        for (int i = 0; i < roomTypes.length; i++) {
            if (roomTypes[i].toLowerCase().contains(query.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    // Handle booking with add-on services
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
            // Allocate rooms
            System.out.println("Booking Confirmed! Your allocated room numbers:");
            for (int i = 0; i < qty; i++) {
                System.out.print(nextRoomNumber[roomIndex] + " ");
                nextRoomNumber[roomIndex]++;
            }
            System.out.println();

            // Update inventory
            availableRooms[roomIndex] -= qty;

            // Add-on services selection
            System.out.println("\nAvailable Add-On Services:");
            for (int i = 0; i < services.length; i++) {
                System.out.println((i + 1) + ". " + services[i]);
            }
            System.out.print("Enter the numbers of the services you want (comma-separated, e.g., 1,3) or 0 for none: ");
            String input = sc.nextLine();
            if (!input.equals("0")) {
                String[] selected = input.split(",");
                System.out.println("You selected the following add-on services:");
                for (String s : selected) {
                    int index = Integer.parseInt(s.trim()) - 1;
                    if (index >= 0 && index < services.length) {
                        System.out.println("- " + services[index]);
                    }
                }
            } else {
                System.out.println("No add-on services selected.");
            }

        } else {
            System.out.println("Booking failed! Only " + availableRooms[roomIndex] + " rooms available.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Book My Stay - Booking with Add-On Services");

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Show Room Availability");
            System.out.println("2. Book & Select Add-On Services");
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