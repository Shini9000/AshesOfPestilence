package me.shini9000;

import java.util.ArrayList;
import java.util.List;

class Inventory {
    private List<Weapon> items = new ArrayList<>();

    public void addItem(Weapon weapon) {
        items.add(weapon);
        System.out.println(weapon.name + " added to inventory!");
    }

    public void showInventory() {
        System.out.println("Inventory:");
        for (Weapon w : items) {
            System.out.println("- " + w.name + " (Damage: " + w.baseDamage + ")");
        }
    }
    
    public Weapon getItem(int index) {
        return items.get(index);
    }
}