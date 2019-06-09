package com.company;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    public List<int[]> loadFile() throws FileNotFoundException {

        List<int[]> rowList = new ArrayList<int[]>();
        try {
            //ask user for file and then import it

            JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(null);
            if (returnVal != JFileChooser.APPROVE_OPTION) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(fc.getSelectedFile()));
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
            throw new FileNotFoundException();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rowList;
    }
}
