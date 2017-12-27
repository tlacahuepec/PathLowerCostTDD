package mx.tlacahuepec.pathlowestcost.implementation;

import mx.tlacahuepec.pathlowestcost.interfaces.Grid;

/**
 * Grid implementation to store 2D Navigable Arrays
 */

public class NavigableGrid implements Grid {

    private final int[][] matrix;

    public NavigableGrid(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public int getCellCost(int[] currentCell) {
        int x = currentCell[0];
        int y = currentCell[1];
        return matrix[x][y];
    }

    public boolean hasNextColumn(int[] currentCell) {
        int columnsNumber = matrix[1].length - 1;
        return (currentCell[1] < columnsNumber);
    }

    public int[] getNextTopLevelCell(int[] currentCell) {
        int[] nextCell = null;

        int nextTopRow = currentCell[0] - 1;
        int nextColumn = currentCell[1] + 1;
        int rowsNumber = matrix.length - 1;
        //TODO: call hasNextColumn just once
        if (hasNextColumn(currentCell)) {
            if (nextTopRow < 0) {
                nextCell = new int[]{rowsNumber, nextColumn};
            } else {
                nextCell = new int[]{nextTopRow, nextColumn};
            }
        }
        return nextCell;
    }

    public int[] getNextBottomLevelCell(int[] currentCell) {
        int[] nextCell = null;

        int nextBottomRow = currentCell[0] + 1;
        int nextColumn = currentCell[1] + 1;
        int rowsNumber = matrix.length - 1;
        //TODO: call hasNextColumn just once
        if (hasNextColumn(currentCell)) {
            if (nextBottomRow > rowsNumber) {
                nextCell = new int[]{0, nextColumn};
            } else {
                nextCell = new int[]{nextBottomRow, nextColumn};
            }
        }
        return nextCell;
    }

    

    public int[] getNextAvailableCell(int[] currentCell) {
        int[] nextCell = null;
        if (hasNextColumn(currentCell)) {
            int[] topLevelCell;
            int[] sameLevelCell;
            int[] bottomLevelCell;
        } else {
            return nextCell;
        }
        return null;
    }


}
