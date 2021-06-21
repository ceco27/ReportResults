package com.ceco;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONReader {
    public Object ReadJSON (String path) {
        
        JSONParser Parser = new JSONParser();
        
        try(FileReader Reader = new FileReader(path)) {
            
            Object ParsedData = Parser.parse(Reader);
            return ParsedData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

    public List<Employee> ReadData (String path) {
        JSONArray Data = (JSONArray) ReadJSON(path);
        List<Employee> EmployeeData = new ArrayList<Employee>();
        Integer ArrayLength = Data.size();
        for( Integer i=0; i < ArrayLength; i++) {
            JSONObject CurrData = (JSONObject) Data.get(i);
            Employee CurrEmployee = new Employee("", 0, 0, 0.0);
            CurrEmployee.Name = (String) CurrData.get("name");
            CurrEmployee.TotalSales = (long) CurrData.get("totalSales");
            CurrEmployee.SalesPeriod = (long) CurrData.get("salesPeriod");
            CurrEmployee.ExperienceMultiplier = (Double) CurrData.get("experienceMultiplier");
            EmployeeData.add(CurrEmployee);
        }
        return EmployeeData;
    }

    public Definition ReadDefinition (String path) {
        JSONObject Data = (JSONObject) ReadJSON(path);
        Definition ReportDefinition = new Definition(0,false,0);
        ReportDefinition.TopPerformersThreshold = (long) Data.get("topPerformersThreshold");
        ReportDefinition.UseExperienceMultiplier = (Boolean) Data.get("useExperienceMultiplier");
        ReportDefinition.PeriodLimit = (long) Data.get("periodLimit");
        return ReportDefinition;
    }
}
