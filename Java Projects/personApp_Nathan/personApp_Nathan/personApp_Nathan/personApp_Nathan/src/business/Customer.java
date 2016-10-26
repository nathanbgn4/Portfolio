/*
 * Programmer: Nathan Bougeno
 * Date: 9/8/2016
 * File: c:\\users\ba212\Customer.java
 * Desc: Customer is a subclass of Person
 */
package business;
import java.util.Random;
public class Customer extends Person{
    //Customer Attributes
    public int custID;
    Random r = new Random();
    //constructor
    public Customer()
    {
        super();
        custID =100000+r.nextInt(899999);
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }
    
    //implement abstract method
    
    public String getDisplayText()
    {
        return super.toString()+"Customer #: "+custID+"\n";
    }
}
