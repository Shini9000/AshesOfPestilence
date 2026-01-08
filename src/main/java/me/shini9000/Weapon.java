
package me.shini9000;

public class Weapon {
    public final String name;
    public final int baseDamage;
    public final String effect;

    public Weapon(String name, int baseDamage, String effect) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.effect = effect;
    }

    public void use(PlayerProfile player) {
        int finalDamage = baseDamage + player.strength;
        System.out.println("You deal " + finalDamage + " damage with " + name + "!");
    }
    

}
