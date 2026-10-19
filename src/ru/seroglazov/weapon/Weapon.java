package ru.seroglazov.weapon;

import ru.seroglazov.validation.Validate;

public abstract class Weapon {
    private int ammo;

    public Weapon(int ammo) {
        Validate.isNegativeException("Количество патронов не может быть отрицательным", ammo);
        this.ammo = ammo;
    }

    public Weapon(Weapon other) {
        Validate.isNullException("Передайте существующее оружие", other);
        this.ammo = other.ammo;
    }

    public abstract void shoot();

    public abstract Weapon copy();

    public int getAmmo() {
        return ammo;
    }

    public boolean takeAmmo() {
        if (ammo == 0) return false;
        ammo--;
        return true;
    }

    public void setAmmo(int ammo) {
        Validate.isNegativeException("Количество патронов не может быть отрицательным", ammo);
        this.ammo = ammo;
    }
}
