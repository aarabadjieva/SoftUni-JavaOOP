package StackOfStrings;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    StackOfStrings(){
        this.data = new ArrayList<>();
    }
    public void push(String item){
        this.data.add(0, item);
    }

    public String pop(){
        String item = this.data.get(0);
        this.data.remove(0);
        return item;
    }

    public String peek(){
       return this.data.get(0);
    }

    public boolean isEmpty(){
        return this.data.isEmpty();
    }
}
