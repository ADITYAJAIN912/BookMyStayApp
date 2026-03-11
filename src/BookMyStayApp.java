import java.util.Scanner;

public class BookMyStayApp{

    // Centralized room inventory
    static String[] roomTypes = {"Single Room", "Double Room", "Deluxe Room", "Suite"};
    static int[] availableRooms = {10, 5, 3, 2}; // static initial availability

    // Display current availability
    public static void showAvailability() {
        System.out.println("\nCurrent Room Availability:");
        for (int i = 0; i < roomTypes.length; i++) {
            System.out.println((i + 1) + ". " + roomTypes[i] + " - " + availableRooms[i] + " rooms available");
        }
    }

    // Book a room
    public static boolean bookRoom(int roomIndex, int quantity) {
        if (roomIndex < 0 || roomIndex >= availableRooms.length) {
            System.out.println("Invalid room selection.");
            return false;
        }
        if (quantity <= 0) {
            System.out.println("Invalid quantity.");
            return false;
        }
        if (availableRooms[roomIndex] >= quantity) {
            availableRooms[roomIndex] -= quantity;
            System.out.println(quantity + " " + roomTypes[roomIndex] + "(s) booked successfully!");
            return true;
        } else {
            System.out.println("Booking failed! Only " + availableRooms[roomIndex] + " rooms available.");
            return false;
        }
    }

    // Search for a room type
    public static void searchRoom(String searchQuery) {
        boolean found = false;
        System.out.println("\nSearch Results:");
        for (int i = 0; i < roomTypes.length; i++) {
            if (roomTypes[i].toLowerCase().contains(searchQuery.toLowerCase())) {
                System.out.println(roomTypes[i] + " - " + availableRooms[i] + " rooms available");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No room types match your search query: \"" + searchQuery + "\"");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Book My Stay - Room Search & Availability Check");

        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Show Room Availability");
            System.out.println("2. Book a Room");
            System.out.println("3. Search for a Room Type");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    showAvailability();
                    break;
                case 2:
                    showAvailability();
                    System.out.print("Select room number to book: ");
                    int roomNum = sc.nextInt() - 1;
                    System.out.print("Enter quantity to book: ");
                    int qty = sc.nextInt();
                    bookRoom(roomNum, qty);
                    break;
                case 3:
                    System.out.print("Enter room type to search: ");
                    String query = sc.nextLine();
                    searchRoom(query);
                    break;
                case 4:
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