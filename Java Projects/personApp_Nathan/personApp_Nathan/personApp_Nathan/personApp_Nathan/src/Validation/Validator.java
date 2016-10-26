package validation;

import java.awt.*;
import java.util.Scanner;
import java.util.regex.*;
import javax.swing.*;


public class Validator {
    public static String getWord(String message, Scanner sc)
    {
        String word = "";
        while (word.equals(""))
        {
            System.out.print(message);
            if (sc.hasNext("\\w+"))
            {
                word = sc.next();
            }
            else
            {
                System.out.println("The entered data includes illegal characters! Try again.\n");
                sc.next();
            }
            sc.nextLine();
        }
        return word;
    }
    
    public static String getEMail(String message, Scanner sc)
    {
        String eMail = "";
        while (eMail.equals(""))
        {
            System.out.print(message);
            if (sc.hasNextLine())
            {
                eMail = sc.nextLine();
                if (!Pattern.matches("^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$", eMail))
                {
                    System.out.println("This is not a valid email address! Try again.\n");
                    eMail = "";
                }
                //sc.nextLine();
            }
        }
        return eMail;
    }
    
    // Validate email address for Forms
    public static boolean isValidEmail(JTextField txtField)
    {
        boolean validEmail = false;
        if (Pattern.matches("^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$", 
                txtField.getText())) 
        {
            validEmail = true;
        }
        else  
        {
            //JOptionPane.showMessageDialog(getParentFrame(txtField),);
            JOptionPane.showMessageDialog(getParentFrame(txtField), "Please enter a valid email address.");
            txtField.setText("");
            txtField.requestFocusInWindow();
        }
        return validEmail;
    }
    
    // Validate names for forms
    public static boolean isValidName(JTextField txtField)
    {
        // Validate for entries that contain spaces, dots, and special characters
        boolean validName = false;
        if (Pattern.matches("^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}", 
                txtField.getText())) 
        {
            validName = true;
        }
        else  
        {
            //JOptionPane.showMessageDialog(getParentFrame(txtField),);
            JOptionPane.showMessageDialog(getParentFrame(txtField), "Please enter a valid " 
                    + txtField.getName() 
                    + ". It must not contain spaces, dots and numbers.");
            txtField.setText("");
            txtField.requestFocusInWindow();
        }
        return validName;
    }
    public static String getName(String message, Scanner sc)
    {
        String name = "";
        while (name.equals(""))
        {
            System.out.print(message);
            if (sc.hasNext("[a-zA-Z]+"))
            {
                name = sc.next();
            }
            else
            {
                System.out.println("The name entered includes non letter characters! Try again.\n");
                sc.next();
            }
            sc.nextLine();
        }
        return name;
    }
    
    public static String getChoice(String message, String pattern, Scanner sc)
    {
        String choice = "";
        while (choice.equals(""))
        {
            System.out.print(message);
            if (sc.hasNext(pattern))
                choice = sc.next();
            else {
                System.out.println("This is not a correct choice!\n");
                sc.next();
            }
            sc.nextLine();
        }
        return choice;
    }
    
    
    public static double getDouble(String message, Scanner sc)
        {
            double number = 0;
            boolean valid = false;
            while (!valid)
            {
                System.out.print(message);
                if (sc.hasNextDouble())
                {
                    number = sc.nextDouble();
                    valid = true;
                }
                else
                {
                    System.out.println("Invalid input! Please try again.");
                    sc.next();
                }
                sc.nextLine();
            }   
            return number;
        }
        
        public static double getDoubleInRange(String message, Scanner sc, double lowerLimit, double upperLimit)
        {
            double number = 0;
            boolean inRange = false;
            while (!inRange)
            {
                number = getDouble(message, sc);
                if (number>=lowerLimit&&number<=upperLimit)
                    inRange = true;
                else
                {
                    System.out.println("The value submitted is not in the range "+lowerLimit+" to "+upperLimit+"! Please try again.");
                    System.out.println();
                }
            }
            return number;
        }
        public static int getInt(String message, Scanner sc)
        {
            int number = 0;
            boolean valid = false;
            while (!valid)
            {
                System.out.print(message);
                if (sc.hasNextInt())
                {
                    number = sc.nextInt();
                    valid = true;
                }
                else
                {
                    System.out.println("Invalid input! Please try again.");
                    sc.next();
                }
                sc.nextLine();
            }   
            return number;
        }
        
        public static int getIntInRange(String message, Scanner sc, int lowerLimit, int upperLimit)
        {
            int number = 0;
            boolean inRange = false;
            while (!inRange)
            {
                number = getInt(message, sc);
                if (number>=lowerLimit&&number<=upperLimit)
                    inRange = true;
                else
                {
                    System.out.println("The value submitted is not in the range "+lowerLimit+" to "+upperLimit+"! Please try again.");
                    System.out.println();
                }
            }
            return number;
        }//end GetIntInRange
        
        public static int isValidSSN(JTextField textfield)
        {
            int number = 0;
            boolean inRange = false;
            while(!inRange)
            {
                number = Integer.parseInt(textfield.getText());
                if (number >= 100000000 && number <= 999999999) 
                {
                    inRange = true;
                }
            }
            return number;
        }
        
        public static Component getParentFrame(Component c)
        {
            while (!(c instanceof Frame))
            {
                c = c.getParent();
                if (c==null)
                    break;
            }
            return c;
        }
        
        public static void errorMessage(String message, JTextField txtField)
        {
            JOptionPane.showMessageDialog(getParentFrame(txtField), message, "Invalid input",JOptionPane.ERROR_MESSAGE);
            txtField.setText("");
            txtField.requestFocusInWindow();
        }
        
        public static boolean isTextFieldNotEmpty(JTextField txtField)
        {
            if (txtField.getText().isEmpty())
            {
                errorMessage("Please enter value for "+ txtField.getName() +"!", txtField);
                txtField.requestFocusInWindow();
                return false;
            }
            return true;
        }
        
        public static  boolean isTextFieldInt(JTextField txtField)
        {
            if (isTextFieldNotEmpty(txtField))
                if (!TryParseInt(txtField.getText()))
                {
                   errorMessage("Data entered for "+txtField.getName()+" is not a valid integer!\nPlease try again!", txtField);
                   txtField.setText("");
                   txtField.requestFocusInWindow();
                   return false;
                }
            return true;
        }
        
        public static boolean isTextFieldIntInRange(JTextField txtField, int min, int max)
        {
            if (isTextFieldInt(txtField))
            {
                int number = Integer.parseInt(txtField.getText());
                if (number<min||number>max)
                {
                    errorMessage("The entered "+txtField.getName()+" value is not in the range of "+min+" to "+max+"!\nPlease try again.", txtField);
                    txtField.setText("");
                    txtField.requestFocusInWindow();
                }
            }
            return true;
        }
        
        public static boolean isTextFieldDouble(JTextField txtField)
        {
            if (isTextFieldNotEmpty(txtField))
                if(!TryParseDouble(txtField.getText()))
                {
                   errorMessage("Data entered for "+txtField.getName()+" is not a valid number!\nPlease try again!", txtField);
                   txtField.setText("");
                   txtField.requestFocusInWindow();
                   return false;
                }
            return true;
        }
        
        public static boolean isTextFieldDoubleInRange(JTextField txtField, double min, double max)
        {
            if (isTextFieldDouble(txtField))
            {
                double number = Double.parseDouble(txtField.getText());
                if (number<min||number>max)
                {
                    errorMessage("The entered "+txtField.getName()+" value is not in the range of "+min+" to "+max+"!\nPlease try again.", txtField);
                    txtField.setText("");
                    txtField.requestFocusInWindow();
                }
            }
            return true;
        }
        
        public static boolean TryParseInt(String number)
        {
            try {
                Integer.parseInt(number);
                return true;
            } catch (NumberFormatException nfe) {
                return false;
            }
            
        }
        
        public static boolean TryParseDouble(String number)
        {
            try {
                Double.parseDouble(number);
                return true;
            } catch (NumberFormatException nfe) {
                return false;
            }
            
        }
    
} 
