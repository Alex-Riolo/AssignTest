package com.company;

public class TriangleResult {

    private final int[][] data;
    private final int[][] original;

    public TriangleResult(int[][] data, int[][] original) {
        this.data = Triangle.copy2DArray(data);
        this.original = Triangle.copy2DArray(original);
    }
    //this method will return the shortest path
    public int getSmallestSum() {
        return data[0][0];
    }
    //this method will work out the best path and will return a string in the required format
    public String getPath() {
        int[] result = new int[data.length];
        String path = "" + original[0][0]+ " + ";
        int x = 0;
        result[0] = original[0][0];

        for (int rowIndex = 1; rowIndex < result.length; rowIndex++) {
            int[] row = data[rowIndex];
            int[] originalRow = original[rowIndex];

            if (x < row.length - 1) {
                int left = row[x];
                int right = row[x + 1];

                if (right < left) {
                    x++;
                }
            }

            result[rowIndex] = originalRow[x];
            path += originalRow[x] + " + ";
        }
        return path.substring(0, path.length() - 3);
    }

}