/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;


public class Employee extends Person{
    //employee attributes
    private int ssn;
    
    //constructor
    public Employee()
    {
        super();
        ssn = 0;
    }

    public int getSsn() {
        return ssn;
    }
 
    public void setSsn(int ssn) {
        this.ssn = ssn;
    }
    
    //implement abstract method
    public String getDisplayText()
    {
        return super.toString()+"SSN#: "+ssn+"\n";
    }
    
}
