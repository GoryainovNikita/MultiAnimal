package animal;

import java.io.IOException;

public class Sheep extends Herbivores{
    public Sheep(String str) throws IOException {
        super(str);
    }

    @Override
    public Animal reproduction() throws IOException {
        if((int)(Math.random()*100) > 80 && this.getHunger()>60) {
            String name = this.getProperties().getProperty("name");
            for (var elem : this.getCell().getHashMap().keySet()) {
                if (name.equals(elem)) {
                    if (this.getCell().getHashMap().get(elem).size() >= 2) {
                        return new Sheep("animal\\config\\sheep.properties");
                    }
                }
            }
        }
        return null;
    }
}
