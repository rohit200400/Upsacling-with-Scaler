public class CorporateFlightBookings {
    public static void main(String[] args) {
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;

        CorporateFlightBookings system = new CorporateFlightBookings();
        int[] result = system.corpFlightBookings(bookings, n);

        // Print the result
        System.out.print("Total bookings: ");
        for (int bookingsCount : result) {
            System.out.print(bookingsCount + " ");
        }
    }
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] totalBookings = new int[n];
        for(int[] booking: bookings){
            for(int i = booking[0]-1; i < booking[1]; i++){
                totalBookings[i] = totalBookings[i] + booking[2];
            }
        }
        return totalBookings;
    }
}
