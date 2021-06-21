package com.ceco;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

import com.opencsv.CSVWriter;

import org.apache.commons.lang3.tuple.Pair;

public class WriteToCSV {
    public void Writer(PriorityQueue< Pair<Double, String> > Data, Integer NumberOfEmployees) throws IOException {
        File file = new File("F:/Result.csv");
        FileWriter outputfile = new FileWriter(file);
        CSVWriter writer = new CSVWriter(outputfile, ',',CSVWriter.NO_QUOTE_CHARACTER,CSVWriter.DEFAULT_ESCAPE_CHARACTER,CSVWriter.DEFAULT_LINE_END);

        String[] Header = {"Name", "Score"};
        writer.writeNext(Header);

        for(int i = 0; i<NumberOfEmployees; i++) {
            Pair<Double, String> CurrScore = Data.peek();
            Data.remove(CurrScore);
            Double RealScore = -CurrScore.getKey();
            String Name = CurrScore.getValue();
            String[] DataRow = {Name, RealScore.toString()};
            writer.writeNext(DataRow);
        }
        writer.close();
    }
}
