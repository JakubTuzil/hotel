import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Booking {

    private List<Guest> guests;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private TypeOfTrip typeOfTrip;

    public enum TypeOfTrip {HOLIDAY, BUSINESS}


    // region Constructors

    public Booking(Room room, LocalDate checkInDate, LocalDate checkOutDate, TypeOfTrip typeOfTrip, Guest... guests) {
        validateGuests(guests);
        this.guests = new ArrayList<>();
        this.guests.addAll(Arrays.asList(guests));
        this.room = room;
        validateDates(checkInDate, checkOutDate);
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.typeOfTrip = typeOfTrip;
    }

    public Booking(Room room, Guest... guests) {
        this(
                room,
                LocalDate.now(),
                LocalDate.now().plusDays(6),
                TypeOfTrip.HOLIDAY,
                guests
        );

    }

    // endregion Constructors


    // region validators

    private void validateGuest(Guest guest) {
        if (guest == null) {
            throw new IllegalArgumentException("Host musí být vyplněn.");
        }
        if (guest.getName() == null || guest.getName().isBlank()) {
            throw new IllegalArgumentException("Host musí mít vyplněné jméno.");
        }
    }

    private void validateGuests(List<Guest> guests) {
        if (guests == null || guests.isEmpty()) {
            throw new IllegalArgumentException("Rezervace musí mít minimálně jednoho hosta.");
        }
        for (Guest guest : guests) {
            validateGuest(guest);
        }
    }

    private void validateGuests(Guest... guests) {
        validateGuests(Arrays.asList(guests));
    }

    private void validateDates(LocalDate checkInDate, LocalDate checkOutDate) {
        if(checkInDate == null || checkOutDate == null) {
            throw new IllegalArgumentException("Check-in a check-out musí být zadány.");
        }

        if (!checkOutDate.isAfter(checkInDate)) {
            throw new IllegalArgumentException("Check-out date musí následovat po check-in date.");
        }
    }

    // endregion validators


    // region Getters and Setters

    public List<Guest> getGuests() {
        return new ArrayList<>(guests);
    }

    public void setGuests(List<Guest> guests) {
        validateGuests(guests);
        this.guests = new ArrayList<>(guests);
    }

    public void addGuests(Guest... guests) {
        validateGuests(guests);
        this.guests.addAll(Arrays.asList(guests));
    }

    public Room getRoom() {

        return room;
    }

    public void setRoom(Room room) {

        this.room = room;
    }

    public LocalDate getCheckInDate() {

        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        validateDates(checkInDate, this.checkOutDate);
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {

        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        validateDates(this.checkInDate, checkOutDate);
        this.checkOutDate = checkOutDate;
    }

    public TypeOfTrip getTypeOfTrip() {
        return typeOfTrip;
    }

    public void setTypeOfTrip(TypeOfTrip typeOfTrip) {
        this.typeOfTrip = typeOfTrip;
    }

    // endregion Getters and Setters

}
