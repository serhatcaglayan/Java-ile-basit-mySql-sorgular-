/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBaseOperation;

import java.util.ArrayList;


public class Person {
    
    private String  idPerson,namePerson,numberPerson,agePerson;

   

    public Person(String idPerson, String namePerson, String numberPerson, String agePerson) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
        this.numberPerson = numberPerson;
        this.agePerson = agePerson;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public String getNumberPerson() {
        return numberPerson;
    }

    public String getAgePerson() {
        return agePerson;
    }
    
    
    

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public void setNumberPerson(String numberPerson) {
        this.numberPerson = numberPerson;
    }

    public void setAgePerson(String agePerson) {
        this.agePerson = agePerson;
    }
    
}
