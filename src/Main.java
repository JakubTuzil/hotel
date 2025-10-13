import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Guest guest1 = new Guest("Adéla", "Malíková", LocalDate.of(1993, 3, 13));
        Guest guest2 = new Guest("Jan", "Dvořáček", LocalDate.of(1995, 5, 5));
        guest2.setBirthDate(LocalDate.of(1995, 4, 5));

        System.out.println(guest2.getName() + " " + guest2.getSurname() + " (" + guest2.getBirthDate() + ")");
        System.out.println(guest2.getDescription());

        Room room1 = new Room(1, 1, true, true, new BigDecimal("1000"));
        Room room2 = new Room(2, 1, true, true, new BigDecimal("1000"));
        Room room3 = new Room(3, 3, false, true, new BigDecimal("2400"));

        List<Booking> allBookings = new ArrayList<>();

        Booking booking1 = new Booking(room1, LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 26), Booking.TypeOfTrip.HOLIDAY, guest1);
        allBookings.add(booking1);
        Booking booking2 = new Booking(room3, LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14), Booking.TypeOfTrip.BUSINESS, guest1, guest2);
        allBookings.add(booking2);

        Booking booking3 = new Booking(room2,guest1,guest2);
        allBookings.add(booking3);

        for (Booking booking : allBookings) {
            System.out.println(
                    "Pokoj č. " + booking.getRoom().getRoomNumber()
                            + ", počet hostů: " + booking.getGuests().size()
                            + ", rezervace od: " + booking.getCheckInDate().format(DateTimeFormatter.ofPattern("d.M.yyyy"))
                            + ", rezervace do: " + booking.getCheckOutDate().format(DateTimeFormatter.ofPattern("d.M.yyyy"))
                            + ", typ: " + booking.getTypeOfTrip()
                            + ".");
        }
    }
}