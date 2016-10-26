/*
 * Programmer: Nathan Bougeno
 * Date: 9/8/2016
 * File: c:\\users\ba212\Person.java
 * Desc: Person super class identification
 */
package business;

public abstract class Person {
    //person attributes
    private String firstName, lastName, emailAdd;
    
    //constructor
    public Person()
    {
        firstName = "";
        lastName = "";
        emailAdd = "";
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

    
    public String getEmailAdd() {
        return emailAdd;
    }

    
    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
    }
    
    //abstract method getDisplayText
    public abstract String getDisplayText();
    
    public String getFullName()
    {
        return firstName + " " + lastName;
    }
    @Override
    public String toString()
    {
        return "Name: " + getFullName() + "\n" + "Email: " + emailAdd + "\n";
    }

}
