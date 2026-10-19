package ru.seroglazov.weapon;

import ru.seroglazov.validation.Validate;

public class Shooter {
    private final String name;
    private Weapon weapon;

    public Shooter(String name) {
        this(name, null);
    }

    public Shooter(String name, Weapon weapon) {
        Validate.isNullException("Передано имя null", name);
        this.name = name;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public Weapon getWeapon() {
        if (weapon == null) {
            return new NoWeapon();
        }
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void shoot() {
        weapon.shoot();
    }

    @Override
    public String toString() {
        return "Стрелок, у которого " + weapon;
    }
}
