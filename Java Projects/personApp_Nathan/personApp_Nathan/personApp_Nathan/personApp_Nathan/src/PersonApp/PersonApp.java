/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersonApp;

//needed imports
import java.util.*;
import business.*;
import validation.Validator;
//import Validation.*;

public class PersonApp {
    public static void main(String[] a)
    {
    //print welcome message
    System.out.println("Welcome to Customer/Employee Database!");    
    
    //Create scanner for input 
    Scanner sc = new Scanner(System.in);
    String choiceYN = "y", choiceCE = "c";
    Person p = null;
    while(choiceYN.equalsIgnoreCase("y"))
    {
        System.out.println();
       choiceCE = Validator.getChoice("Create customer or employee?(c/e): ","[ceCE]", sc);
       //choiceCE = Validator.getChoice("Create customer or employee?(c/e): ");
       if(choiceCE.equalsIgnoreCase("c"))
        {
            System.out.println();
            //instantiate customer object
            Customer c = new Customer();
            c.setFirstName(Validator.getName("Enter first name: ",sc));
            c.setLastName(Validator.getName("Enter last name: ", sc));
            c.setEmailAdd(Validator.getEMail("Enter email address: ", sc));
            c.setCustID(c.getCustID());
            p=c;
        }
        else if(choiceCE.equalsIgnoreCase("e"))
        {
            //instantiate employee
             Employee e = new Employee();
             e.setFirstName(Validator.getName("Enter first name: ", sc));
             e.setLastName(Validator.getName("Enter last name: ", sc));
             e.setEmailAdd(Validator.getEMail("Enter email address: ", sc));
             e.setSsn(Validator.getIntInRange("Enter SSN: ", sc, 100000000, 999999999));
             p=e;
        }
        
        //print output
        printPerson(p);
        choiceYN = Validator.getChoice("Coontinue?(y/n): ", "[ynYN]", sc);
    }
   }
    public static void printPerson(Person p)
    {
        System.out.println("\n"+"You entered: ");
        System.out.println(p.getDisplayText());
    }
}
