package animal;

import java.io.IOException;

public class Dug extends Herbivores{
    public Dug(String str) throws IOException {
        super(str);
    }

    @Override
    public Animal reproduction() throws IOException {
        if((int)(Math.random()*100) > 80 && this.getHunger()>60) {
            String name = this.getProperties().getProperty("name");
            for (var elem : this.getCell().getHashMap().keySet()) {
                if (name.equals(elem)) {
                    if (this.getCell().getHashMap().get(elem).size() >= 2) {
                        return new Dug("animal\\config\\dug.properties");
                    }
                }
            }
        }
        return null;
    }

    @Override
    public boolean eat() {
        String eatenBy = this.getEatenBy();
        var hashmap = this.getCell().getHashMap();
        if(this.getHunger() > 30){
            for(var elem : hashmap.keySet()){
                if(elem.equals("worm")){
                    Animal animal = hashmap.get(elem).get((int) (Math.random() * hashmap.get(elem).size()));
                    int tmp = Integer.parseInt(animal.getProperties().getProperty(eatenBy));
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
            if(this.getCell().getGrass() == 0){
                return false;
            }
            else {
                if(this.getCell().getGrass() == 0){
                    return false;
                }
                else {
                    while (this.getHunger() < 100){
                        double kgForSatiation = Double.parseDouble(this.getProperties().getProperty("kilogramsOfFoodForSatiation"));
                        int saturationPercentage = (int) (100 / kgForSatiation);
                        this.setHunger((int) (this.getHunger() + saturationPercentage));
                        this.getCell().setGrass(this.getCell().getGrass() - 1);
                        if(this.getCell().getGrass() == 0){
                            break;
                        }
                    }
                    this.hungerCheck();
                    return true;
                }
            }
        }
        else {
            if(this.getCell().getGrass() == 0){
                return false;
            }
            else {
                while (this.getHunger() < 100){
                    double kgForSatiation = Double.parseDouble(this.getProperties().getProperty("kilogramsOfFoodForSatiation"));
                    int saturationPercentage = (int) (100 / kgForSatiation);
                    this.setHunger((int) (this.getHunger() + saturationPercentage));
                    this.getCell().setGrass(this.getCell().getGrass() - 1);
                    if(this.getCell().getGrass() == 0){
                        break;
                    }
                }
                this.hungerCheck();
                return true;
            }
        }
    }
}
