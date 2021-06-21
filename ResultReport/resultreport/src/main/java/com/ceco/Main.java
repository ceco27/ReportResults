package com.ceco;

import java.io.IOException;
import java.util.List;
import java.util.PriorityQueue;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class Main 
{
    public static void main( String[] args ) throws IOException
    {
        JSONReader Reader = new JSONReader();
        List<Employee> EmployeeData = Reader.ReadData(args[0]);
        Definition ReportDefinition = Reader.ReadDefinition(args[1]);
        PriorityQueue< Pair<Double, String> > Results = new PriorityQueue< Pair<Double, String> >();
        Integer ArraySize = EmployeeData.size();
        for(int i = 0; i < ArraySize; i++) {
            Double CurrScore = Double.valueOf(0);
            Employee CurrEmployee = EmployeeData.get(i);
            if(ReportDefinition.PeriodLimit >= CurrEmployee.SalesPeriod) {
                CurrScore = CurrEmployee.GetScore(CurrEmployee, ReportDefinition.UseExperienceMultiplier);
                Pair<Double, String> CurrResults = new ImmutablePair<Double,String>(-CurrScore, CurrEmployee.Name);
                Results.add(CurrResults);
            }
        }
        Integer NumberOfEmployees;
        NumberOfEmployees = (int) Math.ceil(Double.valueOf(ReportDefinition.TopPerformersThreshold)*Double.valueOf(ArraySize)/100.0);
        WriteToCSV WriteToCSV = new WriteToCSV();
        WriteToCSV.Writer(Results, NumberOfEmployees);
    }
}
