package animal;

import java.io.IOException;

public abstract class Herbivores extends Animal{
    public Herbivores(String str) throws IOException {
        super(str);
    }

    @Override
    public boolean eat() {
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
