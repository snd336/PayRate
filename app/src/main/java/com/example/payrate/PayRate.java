package com.example.payrate;

public class PayRate {

    private double hoursPerWeek;
    private double overTime; //add option to seperatley add OT, why?

    private double hourlyRate;
    private double annualRate;

    private boolean hourlyToSalary;

    //Constructor
    public PayRate(double hoursPerWeek, double rate, boolean hourlyToSalary)
    {
        setHoursPerWeek(hoursPerWeek);
        this.hourlyToSalary = hourlyToSalary;
        if (this.hourlyToSalary == true)
        {
            this.hourlyRate = rate;

            hourlyToSalary();
        }
        else
        {
            this.annualRate = rate;

            salaryToHourly();
        }

    }


    //Get & Set
    public void setHoursPerWeek(double hoursPerWeek)
    {
        if (hoursPerWeek > 40.0)
        {
            this.hoursPerWeek = 40.0;
            overTime = hoursPerWeek - 40.0;
        }
        else this.hoursPerWeek = hoursPerWeek;
    }

    public void setHourlyRate(double hourlyRate)
    {
        this.hourlyRate = hourlyRate;
    }

    public double getRate()
    {
        if (hourlyToSalary == true) return getAnnualRate();
        else return getHourlyRate();

    }

    public double getHourlyRate()
    {
        return hourlyRate;

    }
    public double getAnnualRate()
    {
        return annualRate;
    }




    //Class Methods
    public void hourlyToSalary()
    {
        annualRate = (hourlyRate*52) * (hoursPerWeek + overTime*1.5);
    }

    public void salaryToHourly()
    {
        hourlyRate = annualRate / (52 * (hoursPerWeek + overTime*1.5) );
    }


}
