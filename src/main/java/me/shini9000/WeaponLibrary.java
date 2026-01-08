package me.shini9000;

import java.util.Map;
import java.util.HashMap;

public final class WeaponLibrary {
    private WeaponLibrary() {}

    public static final Map<String, Weapon> weapons = new HashMap<>();

    static {
    	weapons.put("Fists", new Weapon("Fists", 1, null));
        weapons.put("Rusty Iron Sword", new Weapon("Rusty Iron Sword", 3, null));
        weapons.put("Iron Sword", new Weapon("Iron Sword", 5, null));
        weapons.put("Flimsy Bow", new Weapon("Flimsy Bow", 8, null));
        weapons.put("Fire Scroll", new Weapon("Fire Scroll", 20, "Burn"));
        weapons.put("Frost Scroll", new Weapon("Frost Scroll", 20, "Freeze"));
        weapons.put("Shock Scroll", new Weapon("Shock Scroll", 20, "Shock"));
        weapons.put("Poison Scroll", new Weapon("Poison Scroll", 20, "Poison"));
        weapons.put("Plague Scroll", new Weapon("Plague Scroll", 20, "Necrosis"));
        
    }
}