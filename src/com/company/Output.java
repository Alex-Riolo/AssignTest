package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Output {

    public void createOutputFile(TriangleResult traingle, ArrayList<String> properties){
        try {
            PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
            out.println("$ cat << EOF | java MinTrianglePath");
            System.out.println("$ cat << EOF | java MinTrianglePath");
            for (int i=0;i < properties.size() ; i++) {
                out.println("> " + properties.get(i));
                System.out.println("> " + properties.get(i));
            }
            out.println("> EOF");
            System.out.println("> EOF");
            out.println("Minimal path is: " + traingle.getPath() + " = " + traingle.getSmallestSum());
            System.out.println("Minimal path is: " + traingle.getPath() + " = " + traingle.getSmallestSum());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
