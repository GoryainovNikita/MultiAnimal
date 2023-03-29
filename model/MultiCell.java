package model;

import animal.Animal;

import java.io.IOException;
import java.util.concurrent.Callable;

public class MultiCell implements Callable<Boolean> {

    private Cell cell;

    public MultiCell(Cell cell) {
        this.cell = cell;
    }

    @Override
    public Boolean call() {

        for (var elem : cell.getHashMap().keySet()) {                  //В начале дня все голодают на 10%
            for (var elem1 : cell.getHashMap().get(elem)) {
                elem1.setHunger((int) (elem1.getHunger() - 10));
                if (elem1.getHunger() < 80) {
                    elem1.eat();                                        //Все животные кушают
                }
            }
        }
        cell.growGrass();
        for (var elem : cell.getHashMap().keySet()) {
            for (var elem1 : cell.getHashMap().get(elem)) {
                if (elem1.getHunger() <= 0) {
                    cell.deleteAnimal(elem1);                           //У кого голод = 0 - умирает
                }
                try {
                        Animal animal = elem1.reproduction();
                        if (animal != null) {
                            cell.addAnimal(animal);
                        }
                } catch (IOException e) {
                    System.out.println("Возникла ошибка с расположением .properties, проверьте правильность расположения.");
                }
            }
        }
        return true;
    }
}
