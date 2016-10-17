/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.text.NumberFormat;
import javax.swing.*;
public class Validator {
     public static boolean isTextFieldNonNegative(JTextField t)
    {
        boolean bResult = false;
        try
        {
            double d = Double.parseDouble(t.getText());
            if (d >= 0)
                bResult = true;
            else
            {
                JOptionPane.showMessageDialog(t, t.getName() + " Cannot Be Less Than Zero. Try again...", 
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
                           
            }                    
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(t, t.getName() + " Must Be a Number. Try again...", 
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
                     
        }
        t.requestFocusInWindow();
        t.selectAll(); 
        return bResult;
    }
    
    public static String formatNumber(double d)
    {
        NumberFormat number = NumberFormat.getNumberInstance();
        number.setMaximumFractionDigits(2);
        return number.format(d);
    }

    public static String formatCurrency(double d)
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();        
        return currency.format(d);
    }
    
    

}
