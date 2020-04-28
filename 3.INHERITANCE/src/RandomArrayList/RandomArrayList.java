package RandomArrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {
    private Random random;

    public RandomArrayList() {
        super();
        this.random = new Random();
    }

    public T getRandomElement(){
        if (super.isEmpty()){
            throw new IllegalArgumentException("Get on an empty list");
        }
        int index = this.random.nextInt(super.size());
        T element = super.get(index);
        super.remove(element);
        return element;
    }
}
