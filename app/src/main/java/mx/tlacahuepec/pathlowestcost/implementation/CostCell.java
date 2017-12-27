package mx.tlacahuepec.pathlowestcost.implementation;

import android.support.annotation.NonNull;

import java.util.Arrays;

import mx.tlacahuepec.pathlowestcost.interfaces.Cell;

/**
 * Created by santi on 12/26/2017.
 */

public class CostCell implements Cell {

    private final int[] position;
    private final int cost;

    public CostCell(int[] position, int cost) {
        this.position = position;
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public int[] getPosition() {
        return position;
    }
}
