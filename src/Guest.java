import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Guest {

    private String name;
    private String surname;
    private LocalDate birthDate;


    // region Constructors

    public Guest(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    // endregion Constructors


    public String getDescription() {

        DateTimeFormatter formated = DateTimeFormatter.ofPattern("d.M.yyyy");
        return name + " " + surname + " (" + birthDate.format(formated) + ")";

    }


    // region Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    // endregion Getters and Setters


}
