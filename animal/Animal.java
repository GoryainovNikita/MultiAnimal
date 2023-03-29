package animal;

import model.Cell;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class Animal {

    private boolean flagMovement;

    public boolean isFlagMovement() {
        return flagMovement;
    }

    public void setFlagMovement(boolean flagMovement) {
        this.flagMovement = flagMovement;
    }

    private String eatenBy;
    private int hunger;
    private Cell cell;

    private Properties properties = new Properties();

    public String getEatenBy() {
        return eatenBy;
    }
    public Cell getCell() {
        return cell;
    }


    public Animal(String str) throws IOException {
        FileInputStream inputStream = new FileInputStream(str);
        properties.load(inputStream);
        inputStream.close();
        hunger = 60;
        eatenBy = properties.getProperty("eatenBy");
        flagMovement = true;
    }

    public double getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public Properties getProperties() {
        return properties;
    }

    public abstract boolean eat();

    public void movement(Cell cell){
        this.cell = cell;
    }
    public abstract Animal reproduction() throws IOException;

    public void hungerCheck(){
        if(hunger > 100){
            hunger = 100;
        }
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
