package mx.tlacahuepec.pathlowestcost.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mx.tlacahuepec.pathlowestcost.interfaces.Grid;
import mx.tlacahuepec.pathlowestcost.interfaces.Path;

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
        // TODO: try catch
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

    public int[] getNextSameLevelCell(int[] currentCell) {
        int[] nextCell = null;
        int nextColumn = currentCell[1] + 1;
        //TODO: call hasNextColumn just once
        if (hasNextColumn(currentCell)) {
            nextCell = new int[]{currentCell[0], nextColumn};
        }
        return nextCell;
    }

    // TODO: store recursive path
    public int[] getMinimumNextAdjacentCell(int[] currentCell) {

        int[] topLevelCell = getNextTopLevelCell(currentCell);
        int topLevelCellCost = getCellCost(topLevelCell);

        int[] bottomLevelCell = getNextBottomLevelCell(currentCell);
        int bottomLevelCellCost = getCellCost(bottomLevelCell);

        int[] sameLevelCell = getNextSameLevelCell(currentCell);
        int sameLevelCellCost = getCellCost(sameLevelCell);

        //TODO: first check 3 equals
        if (topLevelCellCost == bottomLevelCellCost && bottomLevelCellCost == sameLevelCellCost) {
            // T=B=S
            return null;
        }

        // SameLevel comparison
        if (topLevelCellCost == bottomLevelCellCost) {
            if (sameLevelCellCost < topLevelCellCost) {
                return sameLevelCell;
            } else {
                // (T=B) < S
                return null;
            }
        }
        // BottomLevel comparison
        if (sameLevelCellCost == topLevelCellCost) {
            if (bottomLevelCellCost < sameLevelCellCost) {
                return bottomLevelCell;
            } else {
                // T=S < B
                return null;
            }
        }
        // TopLevel comparison
        if (sameLevelCellCost == bottomLevelCellCost) {
            if (topLevelCellCost < sameLevelCellCost) {
                return topLevelCell;
            } else {
                // S=B < T
                return null;
            }
        }
        if (topLevelCellCost < bottomLevelCellCost) {
            if (sameLevelCellCost < topLevelCellCost) {
                return sameLevelCell;
            } else {
                return topLevelCell;
            }
        }
        if (bottomLevelCellCost < topLevelCellCost) {
            if (sameLevelCellCost < bottomLevelCellCost) {
                return sameLevelCell;
            } else {
                return bottomLevelCell;
            }
        }
        if (sameLevelCellCost < topLevelCellCost) {
            if (bottomLevelCellCost < sameLevelCellCost) {
                return bottomLevelCell;
            } else {
                return sameLevelCell;
            }
        }
        if (topLevelCellCost < sameLevelCellCost) {
            if (bottomLevelCellCost < topLevelCellCost) {
                return bottomLevelCell;
            } else {
                return topLevelCell;
            }
        }
        if (sameLevelCellCost < bottomLevelCellCost) {
            if (topLevelCellCost < sameLevelCellCost) {
                return topLevelCell;
            } else {
                return sameLevelCell;
            }
        }
        if (bottomLevelCellCost < sameLevelCellCost) {
            if (topLevelCellCost < bottomLevelCellCost) {
                return topLevelCell;
            } else {
                return bottomLevelCell;
            }
        }
        return null;
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
