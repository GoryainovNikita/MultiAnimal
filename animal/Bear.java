package animal;

import java.io.IOException;

public class Bear extends Predators{
    public Bear(String str) throws IOException {
        super(str);
    }


    @Override
    public Animal reproduction() throws IOException {
        if((int)(Math.random()*100) > 80 && this.getHunger()>60) {
            String name = this.getProperties().getProperty("name");
            for (var elem : this.getCell().getHashMap().keySet()) {
                if (name.equals(elem)) {
                    if (this.getCell().getHashMap().get(elem).size() >= 2) {
                        return new Bear("animal\\config\\bear.properties");
                    }
                }
            }
        }
        return null;
    }
}
