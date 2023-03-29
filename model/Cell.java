package model;

import animal.*;

import java.io.IOException;
import java.util.*;

public class Cell {

    private final int x;
    private final int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int grass;
    private String image = "\uD83C\uDF3F";

    private HashMap<String, List<Animal>> hashMap = new HashMap<>();

    private ArrayList<String> canBeEaten = new ArrayList<>(Arrays.asList("deer", "dug", "goat", "hog", "horse", "mouse", "rabbit", "sheep","boa","fox","buffalo","worm"));

    public ArrayList<String> getCanBeEaten() {
        return canBeEaten;
    }

    public int getGrass() {
        return grass;
    }

    public boolean addAnimal(Animal animal) {
        String name = animal.getProperties().getProperty("name");
        for (var elem : hashMap.keySet()) {
            if (elem.equals(name)) {
                int count = Integer.parseInt(animal.getProperties().getProperty("max_number_per_cell"));
                int size = hashMap.get(elem).size();
                if (size < count) {
                    hashMap.get(elem).add(animal);
                    animal.setCell(this);
                    return true;
                } else {
                    return false;
                }
            }
        }
        ArrayList<Animal> arrayList = new ArrayList<>();
        arrayList.add(animal);
        hashMap.put(name, arrayList);
        animal.setCell(this);
        return true;
    }


    public boolean deleteAnimal(Animal animal) {
        String name = animal.getProperties().getProperty("name");
        for (var elem : hashMap.keySet()) {
            if (elem.equals(name)) {
                Iterator<Animal> iterator = hashMap.get(elem).iterator();
                while (iterator.hasNext()) {
                    Animal nextAnimal = iterator.next();
                    if (nextAnimal == animal) {
                        iterator.remove();
                        return true;
                    }
                }

            }
        }
        return false;

    }

    public void growGrass() {
        if (grass < 200) {
            int random = (int)(Math.random()*200);
            if ((grass + random) > 200) {
                grass = 200;
            } else {
                grass = grass + random;
            }
        } else {
            grass = 200;
        }
    }

    public void setGrass(int grass) {

        this.grass = grass;
    }

    public void print() {
        for (var elem : hashMap.keySet()) {
            int count = hashMap.get(elem).size();
            if (count == 0) {
                continue;
            }
            String image = hashMap.get(elem).get(0).getProperties().getProperty("image");
            System.out.print(image + "X" + count);
        }
        System.out.print(this.image + "X" + grass);
    }

    public HashMap<String, List<Animal>> getHashMap() {
        return hashMap;
    }

    public void birthOfNature() throws IOException {
        grass = (int) (Math.random() * 200);
        int tmp = 0;
        while (tmp < 2) {
            int random = (int) (Math.random() * 15) + 1;
            switch (random) {
                case 1: {
                    int random2 = (int) (Math.random() * 30);
                    for (int i = 0; i < random2; i++) {
                        this.addAnimal(new Wolf("animal\\config\\wolf.properties"));
                    }
                    break;
                }
                case 2: {
                    int random2 = (int) (Math.random() * 150);
                    for (int i = 0; i < random2; i++) {
                        this.addAnimal(new Rabbit("animal\\config\\rabbit.properties"));
                    }
                    break;
                }
                case 3: {
                    int random2 = (int) (Math.random() * 20);
                    for (int i = 0; i < random2; i++) {
                        this.addAnimal(new Horse("animal\\config\\horse.properties"));
                    }
                    break;
                }
                case 4: {
                    int random2 = (int) (Math.random() * 5);
                    for (int i = 0; i < random2; i++) {
                        this.addAnimal(new Bear("animal\\config\\bear.properties"));
                    }
                    break;
                }
                case 5: {
                    int random2 = (int) (Math.random() * 30);
                    for (int i = 0; i < random2; i++) {
                        this.addAnimal(new Boa("animal\\config\\boa.properties"));
                    }
                    break;
                }
                case 6: {
                    int random2 = (int) (Math.random() * 30);
                    for (int i = 0; i < random2; i++) {
                        this.addAnimal(new Fox("animal\\config\\fox.properties"));
                    }
                    break;
                }
                case 7: {
                    int random2 = (int) (Math.random() * 20);
                    for (int i = 0; i < random2; i++) {
                        this.addAnimal(new Eagle("animal\\config\\eagle.properties"));
                    }
                    break;
                }
                case 8: {
                    int random2 = (int) (Math.random() * 20);
                    for (int i = 0; i < random2; i++) {
                        this.addAnimal(new Deer("animal\\config\\deer.properties"));
                    }
                    break;
                }
                case 9: {
                    int random2 = (int) (Math.random() * 500);
                    for (int i = 0; i < random2; i++) {
                        this.addAnimal(new Mouse("animal\\config\\mouse.properties"));
                    }
                    break;
                }
                case 10: {
                    int random2 = (int) (Math.random() * 140);
                    for (int i = 0; i < random2; i++) {
                        this.addAnimal(new Goat("animal\\config\\goat.properties"));
                    }
                    break;
                }
                case 11: {
                    int random2 = (int) (Math.random() * 140);
                    for (int i = 0; i < random2; i++) {
                        this.addAnimal(new Sheep("animal\\config\\sheep.properties"));
                    }
                    break;
                }
                case 12: {
                    int random2 = (int) (Math.random() * 50);
                    for (int i = 0; i < random2; i++) {
                        this.addAnimal(new Hog("animal\\config\\hog.properties"));
                    }
                    break;
                }
                case 13: {
                    int random2 = (int) (Math.random() * 10);
                    for (int i = 0; i < random2; i++) {
                        this.addAnimal(new Buffalo("animal\\config\\buffalo.properties"));
                    }
                    break;
                }
                case 14: {
                    int random2 = (int) (Math.random() * 200);
                    for (int i = 0; i < random2; i++) {
                        this.addAnimal(new Dug("animal\\config\\dug.properties"));
                    }
                    break;
                }
                case 15: {
                    int random2 = (int) (Math.random() * 1000);
                    for (int i = 0; i < random2; i++) {
                        this.addAnimal(new Worm("animal\\config\\worm.properties"));
                    }
                    break;
                }
            }
            tmp++;
        }
    }
}
