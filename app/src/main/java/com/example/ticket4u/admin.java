package com.example.ticket4u;

import java.util.Date;

public class admin extends customer{

    public admin(String email, String password, Number telephone, String firstName, String lastName, Date birthDate, String address, Date registrationDate) {
        super(email, password, telephone, firstName, lastName, birthDate, address, registrationDate);
    }

    void viewReportedItem(){

    }

    void deleteItem(){

    }

    void categoryManagment(){
         //update to couple of function: remove, edit, create...
    }
}
