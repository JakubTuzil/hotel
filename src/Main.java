import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Booking> allBookings = new ArrayList<>();
    private static Room room1;
    private static Room room2;

    public static void main(String[] args) {

        Guest guest1 = new Guest("Adéla", "Malíková", LocalDate.of(1993, 3, 13));
        Guest guest2 = new Guest("Jan", "Dvořáček", LocalDate.of(1995, 5, 5));
        guest2.setBirthDate(LocalDate.of(1995, 4, 5));

        System.out.println(guest2.getName() + " " + guest2.getSurname() + " (" + guest2.getBirthDate() + ")");
        System.out.println(guest2.getDescription());

        room1 = new Room(1, 1, true, true, new BigDecimal("1000"));
        room2 = new Room(2, 1, true, true, new BigDecimal("1000"));

        Booking booking1 = new Booking(room1, LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 26), Booking.TypeOfTrip.HOLIDAY, guest1);
        allBookings.add(booking1);
        Booking booking2 = new Booking(room2, LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14), Booking.TypeOfTrip.BUSINESS, guest2, guest1);
        allBookings.add(booking2);

        System.out.println("==========================");

        for (Booking booking : allBookings) {
            System.out.println(
                    "Pokoj č. " + booking.getRoom().getRoomNumber()
                            + ", počet hostů: " + booking.getGuests().size()
                            + ", rezervace od: " + booking.getCheckInDate().format(DateTimeFormatter.ofPattern("d.M.yyyy"))
                            + ", rezervace do: " + booking.getCheckOutDate().format(DateTimeFormatter.ofPattern("d.M.yyyy"))
                            + ", typ: " + booking.getTypeOfTrip()
                            + ".");
        }
        System.out.println("==========================");
        getFormattedSummary(allBookings);
        System.out.println("==========================");

        allBookings.clear(); // DÚ 2
        fillBookings();

        BookingManager manager = new BookingManager();
        for (Booking b : allBookings) {
            manager.addBooking(b);
        }

        System.out.println("");
        System.out.println("==========================");
        System.out.println("STATISTIKA");
        System.out.println("==========================");
        System.out.println("");
        System.out.println("Počet pracovních pobytů: "+manager.getNumberOfWorkingBookings());
        System.out.println("Průměrný počet hostů na rezervaci: "+manager.getAverageGuests());
        System.out.println("");
        System.out.println("Prvních osm rekreačních rezervací: ");
        getFormattedSummary(manager.getTopNHolidayBookings());
        System.out.println("");
        System.out.println("Statistika hostů:");
        manager.printGuestStatistics();
        System.out.println("");
        getFormattedSummary(allBookings);
    }

    public static void getFormattedSummary(List<Booking> bookings) {
        for (Booking booking : bookings) {

            String seeView = booking.getRoom().hasSeeView()?"ano":"ne";

            System.out.println(
                    booking.getCheckInDate().format(DateTimeFormatter.ofPattern("d.M.yyyy"))
                            + " až " + booking.getCheckOutDate().format(DateTimeFormatter.ofPattern("d.M.yyyy"))
                            + ": " + booking.getGuests().getFirst().getName()
                            + " " + booking.getGuests().getFirst().getBirthDate().format(DateTimeFormatter.ofPattern("d.M.yyyy"))
                            + " [" + booking.getGuestsCount()
                            + ", " + seeView
                            + "] za " + booking.getTotalPrice()
                            + " Kč.");
        }
    }

    public static void fillBookings() {

        Guest guest3 = new Guest("Karel", "Dvořák", LocalDate.of(1990,5,15));
        Room room3 = new Room(3, 1, true, false, new BigDecimal("1000"));
        Booking booking3 = new Booking(room3, LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 7), Booking.TypeOfTrip.BUSINESS, guest3);
        allBookings.add(booking3);

        Guest guest4 = new Guest("Karel", "Dvořák", LocalDate.of(1979,1,3));
        Booking booking4 = new Booking(room2, LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 21), Booking.TypeOfTrip.HOLIDAY, guest4);
        allBookings.add(booking4);

        Guest guest5 = new Guest("Karolína", "Tmavá", LocalDate.of(1981,6,28));
        Booking booking5 = new Booking(room3, LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), Booking.TypeOfTrip.BUSINESS, guest5, guest3);
        allBookings.add(booking5);

        List<Booking> bookingClients = new ArrayList<>(); // možnost pro referenci klientů? všichni mají variable name = guest

        for(int i = 1; i <= 10; i++)
        {

            LocalDate start = LocalDate.of(2023, 8, 1).plusDays(2L * i);
            LocalDate end   = LocalDate.of(2023, 8, 2).plusDays(2L * i);
            LocalDate birthDate = LocalDate.of(1975, 1, 1).plusYears(2L * i).plusMonths(3L*i).plusDays(7L*i);

          Guest guest = new Guest("Klient" + i,"",birthDate);
          Booking booking = new Booking(room2, start,end, Booking.TypeOfTrip.HOLIDAY, guest);
          allBookings.add(booking);
          bookingClients.add(booking);

        }
    }
}