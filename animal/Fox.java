package animal;

import java.io.IOException;

public class Fox extends Predators{
    public Fox(String str) throws IOException {
        super(str);
    }

    @Override
    public Animal reproduction() throws IOException {
        if((int)(Math.random()*100) > 80 && this.getHunger()>60) {
            String name = this.getProperties().getProperty("name");
            for (var elem : this.getCell().getHashMap().keySet()) {
                if (name.equals(elem)) {
                    if (this.getCell().getHashMap().get(elem).size() >= 2) {
                        return new Fox("animal\\config\\fox.properties");
                    }
                }
            }
        }
        return null;
    }
}
