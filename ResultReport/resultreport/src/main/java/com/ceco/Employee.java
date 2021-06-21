package com.ceco;

class Employee {
    
    public String Name;
    public long TotalSales;
    public long SalesPeriod;
    public Double ExperienceMultiplier;

    public Employee (String Name, long TotalSales, long SalesPeriod, Double ExperienceMultiplier) {
        this.Name = Name;
        this.TotalSales = TotalSales;
        this.SalesPeriod = SalesPeriod;
        this.ExperienceMultiplier = ExperienceMultiplier;
    }
    public Double GetScore(Employee Results, Boolean UseExperienceMultiplier)
    {
        if(UseExperienceMultiplier.equals(true)) {
            return Double.valueOf(Results.TotalSales)/Double.valueOf(Results.SalesPeriod)*Results.ExperienceMultiplier;
        } else {
            return Double.valueOf(Results.TotalSales)/Double.valueOf(Results.SalesPeriod);
        }
    }
}

