package com.company;
import java.io.*;
import java.util.*;

public class Text {
    private List<String> list;

    Text() {
        list = new ArrayList<>();
    }

    Text(Text temp) {
        list = new ArrayList<>();
        list.addAll(temp.list);
    }

    public void copy(Text temp) {
        list.clear();
        list.addAll(temp.list);
    }

    public void input(String nameOfFile) throws IOException {
        Scanner in = new Scanner(new File(nameOfFile));
        while (in.hasNextLine()) {
            String str = in.nextLine();
            if (!str.equals("")) {
                list.add(str);
            }
        }
    }

    public void printText(String message) {
        System.out.println(message);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public void deleteTabs() {
        Text temp = new Text();

        for (String item : list) {
            StringBuffer sb = new StringBuffer(item);
            int index = 0;
            while (sb.charAt(index) == ' ') {
                index++;
            }
            sb.delete(0, index);
            temp.list.add(sb.toString());
        }
        copy(temp);
    }

    public void deleteDoubleSpaces() {
        Text temp = new Text();

        for (String item : list) {
            StringBuffer sb = new StringBuffer(item);
            int index = sb.length() - 1;
            while (index > 0) {
                if (sb.charAt(index) == ' ' && sb.charAt(index - 1) == ' ') {
                    sb.replace(index - 1,index + 1," ");
                }
                index--;
            }
            temp.list.add(sb.toString());
        }
        copy(temp);
    }

    public void placeSpaces() {
        Text temp = new Text();
        char[] operators = { '+', '-', '*', '/', '%', '<', '>', '=', ':', '?' };
        char[] otherOperators = {'.',',',';'};

        for (String item : list) {
            StringBuffer str = new StringBuffer(item);
            int end = str.length() - 1;
            for (int i = end; i > 0; --i) {
                for(char j: operators) {
                    if (str.charAt(i) == j && str.charAt(i + 1) != ' ') {
                        str.insert(i + 1,' ');
                    }
                    if (str.charAt(i) == j && str.charAt(i - 1) != ' ') {
                        str.insert(i,' ');
                    }
                }
            }

            for (int i = end; i > 0; --i) {
                for (char j : operators) {
                    if (str.charAt(i) == j && str.charAt(i + 2) == '=') {
                        str.deleteCharAt(i + 1);
                    }
                    else{
                        if (str.charAt(i) == j && str.charAt(i + 2) == j) {
                            str.deleteCharAt(i + 1);
                            str.deleteCharAt(i  - 1);
                        }
                    }
                }
            }

            temp.list.add(str.toString());
        }
        copy(temp);
    }
    public void output(String nameOfFile)throws IOException{
        FileWriter out=new FileWriter(nameOfFile);
        for(String item : list){
            out.write(item + "\n");
        }
        out.close();
    }

    public void placeTabs() {
        Text temp = new Text();
        int count = 0;
        String[] key_words = { "public", "for", "if", "else", "switch", "private", "default" };
        for (String item : list) {
            StringBuffer str = new StringBuffer(item);
            int length=item.length();
            for (int i = 0; i < count; i++) {
                str.insert(0, "....");
            }
            for(int i=0;i<length;i++){
                if(item.charAt(i)=='{'){
                    count++;
                }
                if(item.charAt(i)=='}'){
                    count--;
                }
            }
            if (item.endsWith("}")) {
                str.delete(0, 4);
            }
            temp.list.add(str.toString());
        }
        copy(temp);
    }
}