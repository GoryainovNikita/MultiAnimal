package model;

import java.util.concurrent.Callable;

public class MultiMov implements Callable<Boolean> {


    private Cell cell;

    private Cell[][] cells;

    public MultiMov(Cell cell, Cell[][] cells) {
        this.cell = cell;
        this.cells = cells;
    }

    @Override
    public Boolean call() {
        var hashmap = cell.getHashMap();
        for (var elem : hashmap.keySet()) {
            for (var elem1 : hashmap.get(elem)) {
                if(!elem1.isFlagMovement()){
                    elem1.setFlagMovement(true);
                    continue;
                }
                int movSpeed = Integer.parseInt(elem1.getProperties().getProperty("movement_speed"));
                int x = 0;
                int y = 0;
                while (movSpeed > 0) {
                    int random = (int) (Math.random() * 4);
                    if (random == 0) {
                        movSpeed --;
                        continue;
                    } else if (random == 1) {
                        x = x - 1;
                    } else if (random == 2) {
                        y = y + 1;
                    } else if (random == 3) {
                        x = x + 1;
                    } else if (random == 4) {
                        y = y - 1;
                    }
                    movSpeed--;
                }
                int horiz = cell.getX() + x;
                int vert = cell.getY() + y;
                if (vert < 0) {
                    vert = 0;
                }
                if (vert > cells.length) {
                    vert = cells.length;
                }
                if (horiz < 0) {
                    horiz = 0;
                }
                if (horiz > cells[vert].length) {
                    horiz = cells[vert].length;
                }
                elem1.movement(cells[vert][horiz]);
                cells[vert][horiz].addAnimal(elem1);
                cell.deleteAnimal(elem1);
                elem1.setFlagMovement(false);
            }

        }
        return true;
    }
}







