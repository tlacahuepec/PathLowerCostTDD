package mx.tlacahuepec.pathlowestcost.implementation;

import java.util.List;

import mx.tlacahuepec.pathlowestcost.interfaces.Path;

/**
 * Created by santi on 12/26/2017.
 */

public class PathCost implements Path {

    private final List<int[]> path;
    private int cost;

    public PathCost(List<int[]> path, int cost) {
        this.path = path;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public List<int[]> getPath() {
        return null;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
