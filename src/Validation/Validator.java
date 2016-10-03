/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Validator {
    
  
      public  static boolean isTextFieldDoubleInRange(JTextField txtField, double dMin, double dMax, String strPrompt)
    {
        boolean bResult = false;
        
        try
        {
            double dValue = Double.parseDouble(txtField.getText());
             if ( dValue >=dMin && dValue <=dMax)
             {
                bResult = true;
             }
             else
            {
                JOptionPane.showMessageDialog(null, strPrompt + " should be a double value between  " + String.valueOf(dMin) + " and " +  String.valueOf(dMax)  + "\n" , "Enter Error", JOptionPane.ERROR_MESSAGE);
            }
        }
          catch (NumberFormatException e) 
          {
            //System.err.println("Caught IOException: " + e.getMessage());
             JOptionPane.showMessageDialog(null, strPrompt + " should be a double value. \n" , "Enter Error", JOptionPane.ERROR_MESSAGE);
          }
                
           txtField.requestFocusInWindow();
           txtField.selectAll();
        return bResult;
    }
      

      public  static boolean isCostGreaterThanSalvage(JTextField costtxtField,JTextField salvagetxtField, String strPrompt)
    {
        boolean bResult = false;
        
            double cost = Double.parseDouble(costtxtField.getText());
            double salvage = Double.parseDouble(salvagetxtField.getText());
            if (cost >= salvage  )
             {
                bResult = true;
             }
             else
            {
                JOptionPane.showMessageDialog(null, strPrompt, "Enter Error", JOptionPane.ERROR_MESSAGE);
            }
       
           
           costtxtField.requestFocusInWindow();
           costtxtField.selectAll();
           salvagetxtField.requestFocusInWindow();
           salvagetxtField.selectAll();
           
           
       return bResult;
    }
      
      
      public  static boolean isTextFieldIntInRange(JTextField txtField, int dMin, int dMax, String strPrompt)
    {
        boolean bResult = false;
        
        try
        {
            int dValue = Integer.parseInt(txtField.getText());;
             if ( dValue >=dMin && dValue <=dMax)
             {
                bResult = true;
             }
             else
            {
                JOptionPane.showMessageDialog(null, strPrompt + " should be a integer value between  " + String.valueOf(dMin) + " and " +  String.valueOf(dMax)  + "\n" , "Enter Error", JOptionPane.ERROR_MESSAGE);
            }
        }
          catch (NumberFormatException e) 
          {
            //System.err.println("Caught IOException: " + e.getMessage());
             JOptionPane.showMessageDialog(null, strPrompt + " should be a integer. \n" , "Enter Error", JOptionPane.ERROR_MESSAGE);
          }
                
           txtField.requestFocusInWindow();
           txtField.selectAll();
        return bResult;
    }
}
