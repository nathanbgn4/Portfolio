/**
 * Programmer: Nathan Bougeno
 * Date: 9/22/2016
 * File: C:\\users\ba212\FinanceCalc
 * Desc: abstract super class for Annuity, Loan, and PV
 */
package Financial;

/**
 *
 * @author BA212
 */
public abstract class Financial {
    
    public static String RATEDESC = "Rate";
    
    //declare member variables
    private double amount;
    private double rate;
    private int term;
    private boolean built;
    
    //constructor #1: initialize member variables
    public Financial()
    {
        this.amount = 0.0;
        this.rate = 0.0;
        this.term = 0;
        this.built = false;
    }
    
    //constructor #2 pass parameters
    public Financial(double amount, double rate, int term)
    {
        this.amount = amount;
        this.rate = rate;
        this.term = term;
        this.built = false;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public boolean isBuilt() {
        return built;
    }

    public void setBuilt(boolean built) {
        this.built = built;
    }
    
    //abstract methods
    public abstract double getResult();
    public abstract double getFirstBalance(int month);
    public abstract double getPrinFactor(int month);
    public abstract double getIntFactor(int month);
    public abstract double getLastBalance(int month);
    public abstract String getAmountDesc();
    public abstract String getRateDesc();
    public abstract String getResultDesc();
    public abstract String getFirstBalDesc();
    public abstract String getPrinDesc();
    public abstract String getInterestDesc();
    public abstract String getTitle();
    public abstract String getLastBalDesc();
}
