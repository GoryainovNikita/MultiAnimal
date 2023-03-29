package animal;

import java.io.IOException;
import java.util.List;

public abstract class Predators extends Animal {
    public Predators(String str) throws IOException {
        super(str);
    }

    public boolean eat() {
        String eatenBy = this.getEatenBy();
        List<String> canBeEaten= this.getCell().getCanBeEaten();
        var hashmap = this.getCell().getHashMap();
        if(this.getHunger() > 30) {
            for (int i = 0; i < hashmap.keySet().size(); i++) {
                int rndm = (int) (Math.random() * canBeEaten.size());
                String herb = canBeEaten.get(rndm);
                for (var elem : hashmap.keySet()) {
                    if (elem.equals(herb)) {
                        Animal animal = hashmap.get(elem).get((int) (Math.random() * hashmap.get(elem).size()));
                        int tmp = Integer.parseInt(animal.getProperties().getProperty(eatenBy, "-1"));
                        if (tmp < 0) {
                            continue;
                        }
                        int random = (int) (Math.random() * 100);
                        if (random > tmp) {
                            double kgForSatiation = Double.parseDouble(this.getProperties().getProperty("kilogramsOfFoodForSatiation"));
                            double kgOfFood = Double.parseDouble(animal.getProperties().getProperty("weight"));
                            int saturationPercentage = (int) (kgOfFood * 100 / kgForSatiation);
                            this.setHunger((int) (this.getHunger() + saturationPercentage));
                            this.hungerCheck();
                            this.getCell().deleteAnimal(animal);
                            return true;
                        }
                    }
                }
            }
        }
        else {
            for(var elem : hashmap.keySet()){
                for(var elem1 : this.getCell().getCanBeEaten()){
                    if(elem.equals(elem1)){
                        Animal animal = hashmap.get(elem).get((int) (Math.random() * hashmap.get(elem).size()));
                        int tmp = Integer.parseInt(animal.getProperties().getProperty(eatenBy, "-1"));
                        if (tmp < 0) {
                            continue;
                        }
                        int random = (int) (Math.random() * 100);
                        if (random > tmp) {
                            double kgForSatiation = Double.parseDouble(this.getProperties().getProperty("kilogramsOfFoodForSatiation"));
                            double kgOfFood = Double.parseDouble(animal.getProperties().getProperty("weight"));
                            int saturationPercentage = (int) (kgOfFood * 100 / kgForSatiation);
                            this.setHunger((int) (this.getHunger() + saturationPercentage));
                            this.hungerCheck();
                            this.getCell().deleteAnimal(animal);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}

