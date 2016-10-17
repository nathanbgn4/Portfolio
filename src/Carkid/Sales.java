/*
 * Programmer: Nathan Bougeno
 * Date: September 1, 2016
 * 
 */
package Carkid;

/**
 *
 * @author BA212
 */
public class Sales {
   //declare variables.
    //private static double cdChanger, noRust,gps,customWheels;
    private double carPrice, tradeIn, featureTotal, salesTax, subTotal, total_due;
    private boolean blnCD, blnGPS, blnWheels, blnRustFree;
    
    //declare constants
    private final double CD_price = 325.00;
    private final double GPS_price = 1200;
    private final double Wheel_price= 625.99;
    private final double Rust_price = 650;
    private final double Tax_rate = 0.08;
   
    //declare static variables(global)
    private static int intSalesCount;
    private static double grandTotal;
    private static double tradeInTotal;
    
    //constructor #1
    public Sales()
    {
        carPrice = 0.0;
        tradeIn = 0.0;
        featureTotal = 0.0;
        salesTax = 0.0;
        subTotal = 0.0;
        total_due = 0.0;
      
        blnCD = false;
       blnGPS = false;
       blnWheels = false;
       blnRustFree = false;
    }
    
    //constructor #2
    public Sales(double carPrice, double tradeIn, boolean blnCD, 
                boolean blnWheels, boolean blnGPS, boolean blnRustFree)
    {
        this.carPrice = carPrice;
        this.tradeIn = tradeIn;
        this.blnCD = blnCD;
        this.blnWheels = blnWheels;
        this.blnGPS = blnGPS;
        this.blnRustFree = blnRustFree;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public double getTradeIn() {
        return tradeIn;
    }

    public void setTradeIn(double tradeIn) {
        this.tradeIn = tradeIn;
    }
    
    public double getFeaturesTotal()
    {
        if(blnCD)
            featureTotal+=CD_price;
        if(blnWheels)
            featureTotal+=Wheel_price;
        if(blnRustFree)
            featureTotal+=Rust_price;
        if(blnGPS)
            featureTotal+=GPS_price;
        return featureTotal;
    }
    
    public double getSubtotal()
    {
        return subTotal = carPrice+featureTotal-tradeIn;
    }
    
    public double getSalesTax()
    {
        return salesTax = subTotal*Tax_rate;
    }
    
    public double getTotalDue()
    {
        total_due = subTotal + salesTax;
        grandTotal+=total_due;
        intSalesCount++;
        tradeInTotal+=tradeIn;
        return total_due;
    }
    public static double getGrandTotal()
    {
        return grandTotal;
    }
    
    public static double getTradeInTotal()
    {
        return tradeInTotal;
    }
    
    public static double getSalesCount()
    {
        return intSalesCount;
    }
    
    
}
