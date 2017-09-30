package com.company;

public class Main {
    public static void main(String[] args) {
        String inFile = "C:\\Users\\user\\IdeaProjects\\FourthLab\\src\\com\\company\\input.txt";
        String outFile="C:\\Users\\user\\IdeaProjects\\FourthLab\\src\\com\\company\\output.txt";
        String str="";
        FileJob call = new FileJob();
        System.out.println("Исходный текст имеет вид:");
        call.Write(outFile,call.getFromFile(inFile,str));
    }
}
