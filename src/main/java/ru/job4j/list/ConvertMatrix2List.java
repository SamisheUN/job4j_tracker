package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        int listCell = array.length * array[0].length;
        int rowPos = 0, cellPos = 0;
        for (int[] row : array) {
            for (int cell : row) {
                list.add(listCell - 1, array[rowPos][cellPos]);
                cellPos++;
            }
            rowPos++;
        }
        return list;
    }
}