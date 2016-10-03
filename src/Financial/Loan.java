/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Financial;

/**
 *
 * @author Nathan
 */
public class Loan extends Financial{
    public static final String RESULTDESC = "Monthly Payment";
    public static final String AMOUNTDESC = "Loan Amount";
    public static final String RATEDESC = "Annual Rate(6%=0.06)";
    public static final String TITLE = "Loan Schedule";
    public static final String BEGBALDESC = "Initial Balance";
    public static final String PRINFACTORDESC = "Payment";
    public static final String INTFACTORDESC = "Int.Charged";
    public static final String ENDBALDESC = "Final Balance";  
    public static final String TermDesc = "Term(months)";

    private double monthlypayment;
    private double[] firstbalance, endbalance, interestchg;
    
    public Loan()
    {
        super();
        
        this.monthlypayment = 0;
    }
    
    public Loan(double amount, double rate, int term)
    {
        super(amount, rate, term);
        
        this.monthlypayment = 0;
        
        buildLoan();
    }
    
    @Override
    public double getResult()
    {
        if(!super.isBuilt())
        {
            buildLoan();
        }
        return this.monthlypayment;
    }
    
    @Override
    public double getFirstBalance(int month)
    {
        if(!super.isBuilt()) 
        {
            buildLoan();
        }
        
        if(month < 1 || month > super.getTerm())
        {
            return 0;
        }
        
        return this.firstbalance[month - 1];
    }
    
    @Override
    public double getIntFactor(int month)
    {
        if(!super.isBuilt())
        {
            buildLoan();
        }
        
        if(month < 1 || month > super.getTerm())
        {
            return 0;
        }
        
        return this.endbalance[month - 1];
    }
    
    @Override
    public double getLastBalance(int month)
    {
        if(!super.isBuilt())
        {
            buildLoan();
        }
        if(month < 1 || month > super.getTerm())
        {
            return 0;
        }
        
        return this.endbalance[month-1];
    }
    
    
    private void buildLoan()
    {
        //calculate monthly payments
        double monthlyrate = super.getRate();
        double denom = Math.pow((1+monthlyrate),super.getTerm())-1;
        this.monthlypayment = (monthlyrate + monthlyrate/denom) * super.getAmount();
    
        this.firstbalance = new double[super.getTerm()];
        this.interestchg = new double[super.getTerm()];
        this.endbalance = new double[super.getTerm()];
        
        //sets initial balance to zero
        this.firstbalance[0] = super.getAmount();
        for(int i=0; i<super.getTerm();i++)
        {
            if(i>0)
            {
                this.firstbalance[i] = this.endbalance[i-1];
            }
            
            this.interestchg[i] = this.firstbalance[i] * monthlyrate;
            this.endbalance[i] = this.firstbalance[i] + this.interestchg[i] - this.monthlypayment;
        }
    
    }
    
    
    @Override
    public String getRateDesc()
    {
        return Loan.RATEDESC;
    }
        
    @Override
    public String getAmountDesc() 
    {
     return Loan.AMOUNTDESC;    
    }

    @Override
    public String getResultDesc() 
    {
        return Loan.RESULTDESC;
    }


    @Override
    public double getPrinFactor(int mo) 
    {
       if (!super.isBuilt()) 
       { 
           buildLoan(); 
       }
             return this.monthlypayment;
    }
   

    @Override
    public String getFirstBalDesc() 
    {
        return Loan.BEGBALDESC;
    }

    @Override
    public String getPrinDesc() 
    {
        return Loan.PRINFACTORDESC;
    }

    @Override
    public String getInterestDesc() 
    {
        return Loan.INTFACTORDESC;
    }

    @Override
    public String getLastBalDesc() 
    {
       return Loan.ENDBALDESC;
    }

    @Override
    public String getTitle() 
    {
        return Loan.TITLE;
    }
}

