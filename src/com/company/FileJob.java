package com.company;
import java.io.*;

public class FileJob {

public String getFromFile(String name,String name1){
    File in=new File(name);
    String probel=" ";
    String twoProbel="  ";
    int b=0;
    FileReader is=null;
    try{
         is=new FileReader(in);
        while((b=is.read())!= -1){
            name1+=(char)b;
        }
        System.out.println(name1);
        while(name1.contains(twoProbel)){
            String str= name1.replace(twoProbel,probel);
            name1=str;
        }
        System.out.println("Текст после удаления (лишних) пробелов и табуляции:");
        System.out.println(name1);
    }
    catch(IOException e){
        System.err.println("Ошибка файла "+ e);
    } finally {
        try{
            if(is != null){
                is.close();
            }
        }
        catch(IOException e){
            System.err.println("Ошибка закрытия файла"+ e);
        }
    }
    return name1;
}

    public void Write(String name,String name1){
        File in=new File(name);
        FileWriter out=null;
    try {
        out=new FileWriter(in);
        for (int i = 0; i < name1.length(); i++) {
            out.write(name1.charAt(i));
        }
    }
        catch(IOException e){
            System.err.println("Ошибка записи"+ e);
        } finally {
        try{
            if(out != null){
                out.close();
            }
        }
        catch(IOException e){
            System.err.println("Ошибка закрытия потока"+ e);
        }
    }
    }

}
