package edu.matc.entity;

/**
 * A class to represent a user.
 *
 * @author pwaite
 */
public class User {
    private String firstName;
    private String lastName;
    private String userid;
    private String dateOfBirth;


    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userid    the userid
     * @param dateOfBirth    the date of birth

     */
    public User(String firstName, String lastName, String userid, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userid = userid;
        this.dateOfBirth = dateOfBirth;
    }


    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets userid.
     *
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets userid.
     *
     * @param userid the userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * Gets dateOfBirth.
     *
     * @return the date of birth
     */
    public String getDateOfBirth() { return dateOfBirth; }

    /**
     * Sets dateOfBirth
     * @param dateOfBirth the date of birth (YYYY/MM/DD format)
     */
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", userid='" + getUserid() + '\'' +
                ", dateofbirth='" + getDateOfBirth() + '\'' +
                ", age ='" + getAge() + '\'' +
                '}';
    }

    /**
     * Gets age in years
     *
     * @return number of years since birth
     */
    public int getAge() {
        java.util.Date today = new java.util.Date();
        //noinspection deprecation
        int year = 1900 + today.getYear();
        //noinspection deprecation
        int month = 1 + today.getMonth();
        //noinspection deprecation
        int day = 1 + today.getDate();
        int birthYear = Integer.parseInt(dateOfBirth.substring(0,4));
        int birthMonth = Integer.parseInt(dateOfBirth.substring(5,7));
        int birthDate = Integer.parseInt(dateOfBirth.substring(8,10));
        int age = year - birthYear;

        if (month > birthMonth) { return age; }
        else if (month == birthMonth) {
            if (day < birthDate) { return age - 1; }
            else { return age; }
        }
        else { return age - 1; }
    }

    private int getBirthYear() {return Integer.parseInt(dateOfBirth.substring(0,4)); }
    private int getBirthMonth() {return Integer.parseInt(dateOfBirth.substring(5,7)); }
    private int getBirthDate() {return Integer.parseInt(dateOfBirth.substring(8,10)); }
    private int getYear() {
        java.util.Date today = new java.util.Date();

        return 1900 + today.getYear();
    }
    private int getMonth() {
        java.util.Date today = new java.util.Date();

        return 1 + today.getMonth();
    }
    private int getDate() {
        java.util.Date today = new java.util.Date();

        return 1 + today.getDate();
    }

}