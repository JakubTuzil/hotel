
import java.util.ArrayList;
import java.util.List;

public class BookingManager {

    private List<Booking> bookings;

    public BookingManager() {
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) {

        bookings.add(booking);

    }

    public Booking getBooking(int index) {

        if (index < 0 || index >= bookings.size()) {
            throw new IndexOutOfBoundsException("Index musí být mezi 0 a " + (bookings.size() - 1));
        }
        return bookings.get(index);
    }

    public List<Booking> getBookings() {

        return new ArrayList<>(bookings);

    }

    public void clearBookings() {

        bookings.clear();

    }

    public int getNumberOfWorkingBookings() {

        int total = 0;

        for (Booking booking : bookings) {

            if (booking.getTypeOfTrip() == Booking.TypeOfTrip.BUSINESS) {
                total++;
            }
        }
        return total;
    }

    public double getAverageGuests() {
        double total = 0.0;

        if (bookings.isEmpty()) return 0.0;
        for (Booking booking : bookings) {

            total += booking.getGuestsCount();

        }
        return total / bookings.size();
    }

    public List<Booking> getTopNHolidayBookings() {
        List<Booking> topHoliday = new ArrayList<>();
        int count = 0;

        for (Booking booking : bookings) {
            if (booking.getTypeOfTrip() == Booking.TypeOfTrip.HOLIDAY && count < 8) {
                topHoliday.add(booking);
                count++;
            }
        }

        return topHoliday;
    }

    public void printGuestStatistics() {

        int count1 = 0;
        int count2 = 0;
        int countn = 0;

        for (Booking booking : bookings) {

            if(booking.getGuestsCount() == 1 ) {
                count1++;
            } else if (booking.getGuestsCount() == 2) {
                count2++;
            } else if (booking.getGuestsCount() > 2) {
                countn++;
            }
        }

        System.out.println("Počet rezervací s jedním hostem: " + count1);
        System.out.println("Počet rezervací s dvěma hosty: " + count2);
        System.out.println("Počet rezervací s více než dvěma hosty: " + countn);

    }

}
