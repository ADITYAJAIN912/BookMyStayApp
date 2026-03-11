public class BookMyStayApp {

    public static void main(String[] args) {

        // Define room types and availability
        String[] roomTypes = {"Single Room", "Double Room", "Deluxe Room", "Suite"};
        int[] availableRooms = {10, 5, 3, 2}; // static availability

        // Print welcome message
        System.out.println("Welcome to Book My Stay - Room Availability");
        System.out.println("------------------------------------------------");

        // Display room types and availability
        System.out.println("Available Room Types:");
        for (int i = 0; i < roomTypes.length; i++) {
            System.out.println((i + 1) + ". " + roomTypes[i] + " - " + availableRooms[i] + " rooms available");
        }

        System.out.println("------------------------------------------------");
        System.out.println("Note: Room availability is currently static and for demonstration purposes only.");
    }
}