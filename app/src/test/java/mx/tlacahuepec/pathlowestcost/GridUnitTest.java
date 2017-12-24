package mx.tlacahuepec.pathlowestcost;

import org.junit.Test;

import mx.tlacahuepec.pathlowestcost.implementation.NavigableGrid;
import mx.tlacahuepec.pathlowestcost.interfaces.Grid;

import static junit.framework.Assert.assertNotNull;


/**
 * Test Class to validate all the Grid Interface Functionality and its different
 * implementations
 */
public class GridUnitTest {

    @Test
    public void testObjectCreationToStoreGrid() {
        int[][] twoDimensionArray = {{0, 1, 2, 3}, {3, 2, 1, 0}, {3, 5, 6, 1}, {3, 8, 3, 4}};

        Grid grid = new NavigableGrid(twoDimensionArray);

        assertNotNull(grid);
    }

}