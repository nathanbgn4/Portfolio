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
public class Annuity extends Financial{
    public static final String ResultDesc = "Final Value of Annuity";
    public static final String AmountDesc = "Amount";
    public static final String TermDesc = "Term(months)";
    public static final String RateDesc = "Annual Rate(6%=0.06)";
    public static final String Title = "Annuity Schedule";
    public static final String InitialBal = "Initial Balance";
    public static final String FinalBal = "Final Balance";
    public static final String PrinFactDesc = "Deposit";
    public static final String IntFactDesc = "Interest Earned";
    
    private double annualpayment;
    private double[] initialbal, finalbal, interest;

    public Annuity()
    {
        super();
    }
    
    public Annuity(double amount, double rate, int term)
    {
        super(amount, rate, term);
        
        //this.annualpayment = 0;
        
        calcAnnuity();
    }

    private void calcAnnuity()
    {
        //internal logic for building annuity
        this.initialbal = new double[super.getTerm()];
        this.interest = new double[super.getTerm()];
        this.finalbal = new double[super.getTerm()];
        
        initialbal[0] = 0.0;
        
        for(int i=0;i<super.getTerm();i++)
        {
            if(i>0)
            {
                this.initialbal[i] = this.finalbal[i-1];
            }
            this.interest[i] = (this.initialbal[i]+super.getAmount())*(super.getRate()/12);
            this.finalbal[i] = this.initialbal[i]+this.interest[i]+super.getAmount();
        }
        super.setBuilt(true);
    }

    @Override
    public double getResult() {
        if(!super.isBuilt())
        {
            calcAnnuity();
        }
        return this.finalbal[super.getTerm()-1];
    }

    @Override
    public double getFirstBalance(int month) {
        if(!super.isBuilt())
        {
            calcAnnuity();
        }
        if(month < 1 || month > super.getTerm())
        {
            return 0;
        }
        return this.initialbal[month - 1];
    }

    @Override
    public double getPrinFactor(int month) {
        if(!super.isBuilt())
        {
            calcAnnuity();
        }
        return super.getAmount();
    }

    @Override
    public double getIntFactor(int month) {
        if(!super.isBuilt())
        {
            calcAnnuity();
        }
        if(month < 1 || month > super.getTerm())
        {
            return 0;
        }
        return this.interest[month-1];
    }

    @Override
    public double getLastBalance(int month) {
        if(!super.isBuilt())
        {
            calcAnnuity();
        }
        if(month < 1 || month > super.getTerm())
        {
            return 0;
        }
        return this.finalbal[month - 1];
    }

    @Override
    public String getAmountDesc() {
        if(!super.isBuilt())
        {
            calcAnnuity();
        }
        return Annuity.AmountDesc;
    }

    @Override
    public String getRateDesc() {
        if(!super.isBuilt())
        {
            calcAnnuity();
        }
        return Annuity.RateDesc;
    }

    @Override
    public String getResultDesc() {
        if(!super.isBuilt())
        {
            calcAnnuity();
        }
        return Annuity.ResultDesc;
    }

    @Override
    public String getFirstBalDesc() {
        if(!super.isBuilt())
        {
            calcAnnuity();
        }
        return Annuity.InitialBal;
    }

    @Override
    public String getPrinDesc() {
        if(!super.isBuilt())
        {
            calcAnnuity();
        }
        return Annuity.PrinFactDesc;
    }

    @Override
    public String getInterestDesc() {
        if(!super.isBuilt())
        {
            calcAnnuity();
        }
        return Annuity.IntFactDesc;
    }

    @Override
    public String getTitle() {
        if(!super.isBuilt())
        {
            calcAnnuity();
        }
        return Annuity.Title;
    }

    @Override
    public String getLastBalDesc() {
        if(!super.isBuilt())
        {
            calcAnnuity();
        }
        return Annuity.FinalBal;
    }
  


}
