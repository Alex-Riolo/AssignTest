package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImportData {

    ArrayList<String> traingleProperties = new ArrayList<>();

    public ArrayList<String> getTraingleProperties() {
        return traingleProperties;
    }

    public void setTraingleProperties(ArrayList<String> traingleProperties) {
        this.traingleProperties = traingleProperties;
    }

    public List<int[]> loadFile() {

        List<int[]> rowList = new ArrayList<int[]>();
        try {
            //ask user for file and then import it
            FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
            dialog.setDirectory("C:");
            dialog.setMode(FileDialog.LOAD);
            dialog.setVisible(true);
            String file = dialog.getFile();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            //loop all the file and populate list of values line by line
            while ((st = br.readLine()) != null) {
                String[] intList = st.replace(' ', ',').split(",");
                int[] linearray = new int[intList.length];
                //populating the array with values
                for (int i = 0; i < intList.length; i++) {
                    linearray[i] = Integer.parseInt(intList[i]);
                }
                rowList.add(linearray);
                traingleProperties.add(st);
               // System.out.println(st);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rowList;
    }
}
