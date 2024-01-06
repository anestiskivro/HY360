/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainClasses;

/**
 *
 * @author tzeor
 */
public class Client {

    private String name;
    private String last_name;
    private String address;
    private String date_of_birth;
    private String driving_license_number; // Can be null if not required
    private String credit_card_number;
    private String expiration_date;
    private String cvv;
    private String has_driving_license; // Indicates if the client has a driving license


    /**
     * Gets the name of the client.
     *
     * @return the full name of the client
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the client.
     *
     * @param name the name of the client
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the client.
     *
     * @return the last name of the client
     */
    public String getLastName() {
        return last_name;
    }

    /**
     * Sets the last name of the client.
     *
     * @param last_name the last name of the client
     */
    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    /**
     * Gets the address of the client.
     *
     * @return the address of the client
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the client.
     *
     * @param address the address of the client
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the date of birth of the client.
     *
     * @return the date of birth of the client
     */
    public String getDateOfBirth() {
        return date_of_birth;
    }

    /**
     * Sets the date of birth of the client.
     *
     * @param dateOfBirth the date of birth of the client
     */
    public void setDateOfBirth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    /**
     * Gets the driving license number of the client.
     *
     * @return the driving license number of the client (can be null)
     */
    public String getDrivingLicenseNumber() {
        return driving_license_number;
    }

    /**
     * Sets the driving license number of the client.
     *
     * @param drivingLicenseNumber the driving license number of the client (can
     * be null)
     */
    public void setDrivingLicenseNumber(String driving_license_number) {
        this.driving_license_number = driving_license_number;
    }


    /**
     * Checks if the client has a driving license.
     *
     * @return true if the client has a driving license, false otherwise
     */
    public String getDrivingLicense() {
        return has_driving_license;
    }

    /**
     * Sets whether the client has a driving license.
     *
     * @param has_driving_license
     */
    public void setHasDrivingLicense(String has_driving_license) {
        this.has_driving_license = has_driving_license;
    }

    /**
     * Sets the credit card number.
     *
     * @param creditCardNumber The credit card number to set.
     */
    public void setCreditCardNumber(String creditCardNumber) {
        this.credit_card_number = creditCardNumber;
    }

    /**
     * Gets the credit card number.
     *
     * @return The credit card number.
     */
    public String getCreditCardNumber() {
        return credit_card_number;
    }

    /**
     * Sets the expiration date of the credit card.
     *
     * @param expirationDate The expiration date to set.
     */
    public void setExpirationDate(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    /**
     * Gets the expiration date of the credit card.
     *
     * @return The expiration date.
     */
    public String getExpirationDate() {
        return expiration_date;
    }

    /**
     * Sets the CVV (Card Verification Value) of the credit card.
     *
     * @param cvv The CVV to set.
     */
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    /**
     * Gets the CVV (Card Verification Value) of the credit card.
     *
     * @return The CVV.
     */
    public String getCvv() {
        return cvv;
    }

}
