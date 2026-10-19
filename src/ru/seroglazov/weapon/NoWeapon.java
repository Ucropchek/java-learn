package ru.seroglazov.weapon;

final public class NoWeapon extends Weapon{
    public NoWeapon() {
        super(0);
    }

    public NoWeapon(NoWeapon other) {
        super(other);
    }

    @Override
    public void shoot() {
        System.out.println("Не могу учавствовать в перестрелке");
    }

    @Override
    public Weapon copy() {
        return new NoWeapon(this);
    }

    @Override
    public String toString() {
        return "нет оружия";
    }
}
