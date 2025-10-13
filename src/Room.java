import java.math.BigDecimal;

public class Room {

    private int roomNumber;
    private int numberOfBeds;
    private boolean hasBalcony;
    private boolean hasSeeView;
    private BigDecimal pricePerNight;

    // region Constructors

    public Room(int roomNumber, int numberOfBeds, boolean hasBalcony, boolean hasSeeView, BigDecimal pricePerNight) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.hasBalcony = hasBalcony;
        this.hasSeeView = hasSeeView;
        this.pricePerNight = pricePerNight;
    }


    // endregion Constructors

    // region Getters and Setters

    public int getRoomNumber() {

        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {

        this.roomNumber = roomNumber;
    }

    public int getNumberOfBeds() {

        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {

        this.numberOfBeds = numberOfBeds;
    }

    public boolean hasBalcony() {

        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {

        this.hasBalcony = hasBalcony;
    }

    public boolean hasSeeView() {

        return hasSeeView;
    }

    public void setHasSeeView(boolean hasSeeView) {

        this.hasSeeView = hasSeeView;
    }

    public BigDecimal getPricePerNight() {

        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {

        this.pricePerNight = pricePerNight;
    }

    // endregion Getters and Setters

}
