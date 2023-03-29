package model;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model {

    private List<MultiCell> multiEatList = new ArrayList<>();
    private List<MultiMov> multiMovs = new ArrayList<>();

    private Cell[][] cells;

    public void createWorld(int x, int y) throws IOException {
        cells = new Cell[x][y];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(i,j);
                MultiCell multiCell = new MultiCell(cells[i][j]);
                MultiMov multiMov = new MultiMov(cells[i][j], cells);
                multiMovs.add(multiMov);
                multiEatList.add(multiCell);
                cells[i][j].birthOfNature();
            }
        }
    }

    public List<MultiCell> getMultiEatList() {
        return multiEatList;
    }

    public List<MultiMov> getMultiMovs() {
        return multiMovs;
    }

    public Cell[][] getCells() {
        return cells;
    }
}
