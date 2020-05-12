package com.state;

import java.util.ArrayList;
import java.util.List;

public abstract class State {

    private List<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
    }

    public List<String> getItems() {
        return items;
    }

    public String info() {
        String string = this.toString();
        for (String item : items) {
            string += "\n " + item;
        }
        return string;
    }

    public String objectId() {
        return this.toString();
    }
}
