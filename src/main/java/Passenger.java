import be.vdab.Passengertype;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "passengers")
    @SecondaryTables(value = {
            @SecondaryTable(name = "FFM"),
            @SecondaryTable(name = "picture")
    })

public class Passenger {

    @Id
    @GeneratedValue
    private int id;
    @Column (table = "FFM")
    private  int frequentFlyerMiles;
    @Column (table = "picture")
    private byte[] picture;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Transient
    private int age;
    @Enumerated(EnumType.STRING)
    private Passengertype passengertype;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(int frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Passengertype getPassengertype() {
        return passengertype;
    }

    public void setPassengertype(Passengertype passengertype) {
        this.passengertype = passengertype;
    }

    public Passenger() {
    }
}
