/**
 * Programmer: Nathan Bougeno
 * Date: 9/22/2016
 * File: C:\\users\ba212\FinanceCalc
 * Desc: Present Value sub class of Financial
 */
package Financial;
/**
 *
 * @author BA212
 */
public class PresentValue extends Financial{
    
    //declare class variables
    public static final String ResultDesc = "Result";
    public static final String AmountDesc = "Amount";
    public static final String RateDesc = "Annual Rate(6%=0.06)";
    public static final String Title = "PV Schedule";
    public static final String FirstBalDesc = "Amount receiving";
    public static final String PrinFactordesc = "Discount";
    public static final String IntFactorDesc = "Discount";
    public static final String LastBalDesc = "Present Value";
    public static final String TermDesc = "Term(months)";
    public double[] discount, pv, denom;
    
    //constructor #1
    public PresentValue()
    {
        super();
    }
    
    //constructor #2
    public PresentValue(double amount, double rate, int term)
    {
        super(amount, rate, term);
        calcPv();
    }
    
    @Override
    public double getResult()
    {
        if(!super.isBuilt())
        {
            calcPv();
        }
        return this.pv[super.getTerm()-1];//pv array starts with 0
    }
    
    
    @Override
    public double getFirstBalance(int month)
    {
        return super.getAmount();
    }
    
    @Override
    public double getLastBalance(int month)
    {
        if(!super.isBuilt())
        {
            calcPv();
        }
        
        if(month < 1 || month > super.getTerm())
        {
           return 0; 
        }
        return this.pv[month - 1];
    }
    
    @Override
    public double getIntFactor(int month)
    {
        if(!super.isBuilt())
        {
            calcPv();
        }
        
        if(month < 1 || month > super.getTerm())
        {
           return 0; 
        }
        return this.discount[month];
    }
    
    @Override
    public double getPrinFactor(int month)
    {
        if(!super.isBuilt())
        {
            calcPv();
        }
        
        if(month < 1 || month > super.getTerm())
        {
           return 0; 
        }
        return this.denom[month];
    }
    
    @Override
    public String getAmountDesc()
    {
        return PresentValue.AmountDesc;
    }
    
    @Override
    public String getResultDesc()
    {
        return PresentValue.ResultDesc;
    }
    
    @Override
    public String getRateDesc()
    {
        return PresentValue.RateDesc;
    }
    
    @Override
    public String getFirstBalDesc()
    {
        return PresentValue.FirstBalDesc;
    }
    
    @Override
    public String getLastBalDesc()
    {
        return PresentValue.LastBalDesc;
    }
    
    @Override
    public String getInterestDesc()
    {
        return PresentValue.IntFactorDesc;
    }
    
    @Override
    public String getPrinDesc()
    {
        return PresentValue.PrinFactordesc;
    }
    
    @Override
    public String getTitle()
    {
        return PresentValue.Title;
    }
    
    public void calcPv(){
        double monthlyrate = super.getRate();
        this.denom = new double[super.getTerm()];
        this.discount = new double[super.getTerm()];
        this.pv = new double[super.getTerm()];
        for (int i=0; i<super.getTerm(); i++)
        {
            this.denom[i] = Math.pow(monthlyrate+1, i+1);
            this.pv[i] = super.getAmount()/this.denom[i];
            this.discount[i] = super.getAmount() - this.pv[i];
        }
        super.setBuilt(true);
            
    }
}
