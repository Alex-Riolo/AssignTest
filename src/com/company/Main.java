package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //read the data from the file
        File file = new File("C:\\AssignTest\\treeInput.txt");
        ImportData id = new ImportData();
        //compute the shortest path
        Triangle triangle = new Triangle(id.loadFile());
        TriangleResult solution = triangle.findShortestPath();
        //output the date to file
        Output printFile = new Output();
        printFile.createOutputFile(solution, id.getTraingleProperties());

    }

}
