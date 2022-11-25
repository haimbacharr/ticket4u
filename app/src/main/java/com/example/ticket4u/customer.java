package com.example.ticket4u;

import android.provider.ContactsContract;

import java.util.Date;

public class customer extends guest{
    String email;
//    ContactsContract.CommonDataKinds.Email email;
    String password;
    Number telephone;
    String firstName;
    String lastName;
    Date birthDate;
    String address;
    Date registrationDate;

    public customer(String email, String password, Number telephone, String firstName, String lastName, Date birthDate, String address, Date registrationDate) {
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.registrationDate = registrationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Number getTelephone() {
        return telephone;
    }

    public void setTelephone(Number telephone) {
        this.telephone = telephone;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "customer{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", telephone=" + telephone +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }

    void createNewItem(){

    }

    void reportAnItem(){

    }

    void viewHighlightedItem(){

    }

    void editItem(){

    }

    void viewMyItems(){

    }

    void editProfile(){

    }

    void changePassword(){

    }
}
