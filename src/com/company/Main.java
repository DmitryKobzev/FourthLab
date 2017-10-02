package com.company;

import java.io.*;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Text data = new Text();
        String fileNameOutput="src\\com\\company\\output.txt";
        String fileNameInput = "src\\com\\company\\input.txt";
        data.input(fileNameInput);
        data.printText("Our text list: ");

        Text mainData = new Text(data);

        mainData.deleteTabs();
        mainData.deleteDoubleSpaces();
        mainData.placeSpaces();
        mainData.placeTabs();
        System.out.println();
        mainData.printText("Our text after program execution:");
        mainData.output(fileNameOutput);
    }
}
