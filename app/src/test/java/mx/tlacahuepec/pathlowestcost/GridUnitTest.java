package mx.tlacahuepec.pathlowestcost;

import org.junit.Test;

import java.util.Arrays;

import mx.tlacahuepec.pathlowestcost.implementation.CostCell;
import mx.tlacahuepec.pathlowestcost.implementation.NavigableGrid;
import mx.tlacahuepec.pathlowestcost.interfaces.Grid;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;


/**
 * Test Class to validate all the Grid Interface Functionality and its different
 * implementations
 */
public class GridUnitTest {

    private final int[][] exampleOne =
            {{3, 4, 1, 2, 8, 6},
                    {6, 1, 8, 2, 7, 4},
                    {5, 9, 3, 9, 9, 5},
                    {8, 4, 1, 3, 2, 6},
                    {3, 7, 2, 8, 6, 4}};

    private final int[][] exampleTwo =
            {{3, 4, 1, 2, 8, 6},
                    {6, 1, 8, 2, 7, 4},
                    {5, 9, 3, 9, 9, 5},
                    {8, 4, 1, 3, 2, 6},
                    {3, 7, 2, 1, 2, 3}};

    private final int[][] exampleThree =
            {{19, 10, 19, 10, 19},
                    {21, 23, 20, 19, 12},
                    {20, 12, 20, 11, 10}};

    private final int[] cell_1_2 = {1, 2};
    private final int[] cell_2_1 = {2, 1};
    private final int[] cell_1_3 = {1, 3};
    private final int[] cell_2_4 = {2, 4};
    private final int[] cell_0_0 = {0, 0};
    private final int[] cell_4_1 = {4, 1};
    private final int[] cell_3_2 = {3, 2};
    private final int[] cell_4_0 = {4, 0};
    private final int[] cell_0_1 = {0, 1};

    private final String cellCostErrorMessage = "The cost of the actual cell" +
            " is not the same as the expected one";

    private final String cellPositionErrormessage = "The Cells are in a different position";

    @Test
    public void testGridObjectCreation() {

        Grid grid = new NavigableGrid(exampleOne);
        Grid grid2 = new NavigableGrid(exampleTwo);
        Grid grid3 = new NavigableGrid(exampleThree);

        assertNotNull(grid);
        assertNotNull(grid2);
        assertNotNull(grid3);

    }

    // TODO: test when not finding the value (out of Bounds)
    // TODO: use mockito
    @Test
    public void testRetrievingTheGridCellCost() {

        Grid gridThree = new NavigableGrid(exampleThree);

        int actual = gridThree.getCellCost(cell_1_2);

        int expected = 20;

        assertEquals(cellCostErrorMessage, expected, actual);

    }

    @Test
    public void testRetrievingCellCost() {
        Grid gridTwo = new NavigableGrid(exampleTwo);

        int actualCellCost = gridTwo.getCellCost(cell_1_2);

        int expectedCellCost = 8;

        assertEquals(cellCostErrorMessage, expectedCellCost, actualCellCost);
    }

    @Test
    public void testNextColumnInTheGridDoesExists() {

        NavigableGrid gridThree = new NavigableGrid(exampleThree);

        assertTrue(gridThree.hasNextColumn(cell_1_3));

    }

    @Test
    public void testNextColumnInTheGridDoesNotExists() {

        NavigableGrid gridThree = new NavigableGrid(exampleThree);

        assertFalse(gridThree.hasNextColumn(cell_2_4));
    }

    @Test
    public void testRetrievingNextTopCell() {

        NavigableGrid gridTwo = new NavigableGrid(exampleTwo);

        int[] actualCell = gridTwo.getNextTopLevelCell(cell_2_1);

        int[] expectedCell = cell_1_2;

        assertNotNull(actualCell);
        assertTrue(cellPositionErrormessage, Arrays.equals(expectedCell, actualCell));

    }

    @Test
    public void testRetrievingNextTopCellRowZero() {

        NavigableGrid gridTwo = new NavigableGrid(exampleTwo);

        int[] actualCell = gridTwo.getNextTopLevelCell(cell_0_0);

        int[] expectedCell = cell_4_1;

        assertNotNull(actualCell);
        assertTrue(cellPositionErrormessage, Arrays.equals(expectedCell, actualCell));

    }

    @Test
    public void testRetrievingNextBottomCell() {
        NavigableGrid gridTwo = new NavigableGrid(exampleTwo);

        int[] actualCell = gridTwo.getNextBottomLevelCell(cell_2_1);

        int[] expectedCell = cell_3_2;

        assertNotNull(actualCell);
        assertTrue(cellPositionErrormessage, Arrays.equals(expectedCell, actualCell));
    }

    @Test
    public void testRetrievingNextBottomCellLastRow() {
        NavigableGrid gridTwo = new NavigableGrid(exampleTwo);

        int[] actualCell = gridTwo.getNextBottomLevelCell(cell_4_0);

        int[] expectedCell = cell_0_1;

        assertNotNull(actualCell);
        assertTrue(cellPositionErrormessage, Arrays.equals(expectedCell, actualCell));
    }

    @Test
    public void testRetrievingNextSameLevelCell() {
        NavigableGrid gridTwo = new NavigableGrid(exampleTwo);
    }

    @Test
    public void testGettingNextAvailableCell() {

        NavigableGrid gridOne = new NavigableGrid(exampleOne);

        int[] actualCell = gridOne.getNextAvailableCell(cell_1_2);
        int actualCost = gridOne.getCellCost(actualCell);

        int[] expectedCell = {1, 2};
        int expectedCost = 1;

        assertEquals(cellPositionErrormessage, Arrays.equals(expectedCell, actualCell));
        assertEquals(cellCostErrorMessage, expectedCost, actualCost);

    }

//    @Test
//    public void testGettingTheMinimumCellCost() {
//
//        Grid gridTwo = new NavigableGrid(exampleTwo);
//
//        int actualCost = gridTwo.get
//
//    }

}