package animal;

import java.io.IOException;

public class Boa extends Predators{
    public Boa(String str) throws IOException {
        super(str);
    }

    @Override
    public Animal reproduction() throws IOException {
        if((int)(Math.random()*100) > 80 && this.getHunger()>60) {
            String name = this.getProperties().getProperty("name");
            for (var elem : this.getCell().getHashMap().keySet()) {
                if (name.equals(elem)) {
                    if (this.getCell().getHashMap().get(elem).size() >= 2) {
                        return new Boa("animal\\config\\boa.properties");
                    }
                }
            }
        }
        return null;
    }
}
