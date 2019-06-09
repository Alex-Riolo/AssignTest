package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //read the data from the file
        File file = new File("C:\\AssignTest\\treeInput.txt");
        ImportData id = new ImportData();
        //compute the shortest path
        try {
            List<int[]> loadedData = id.loadFile();

            Triangle triangle = new Triangle(loadedData);
            TriangleResult solution = triangle.findShortestPath();
            //output the date to file
            Output printFile = new Output();
            printFile.createOutputFile(solution, id.getTraingleProperties());
        } catch (FileNotFoundException e) {
            System.out.println("Please select a valid file");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
