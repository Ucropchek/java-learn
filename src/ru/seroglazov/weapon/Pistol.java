package ru.seroglazov.weapon;

import ru.seroglazov.validation.Validate;

public class Pistol extends Weapon{
    private static final int DEFAULT_AMMO = 5;
    private final int maxAmmo;

    public Pistol() {
        this(DEFAULT_AMMO);
    }

    public Pistol(int ammo) {
        this(ammo, Math.max(ammo, DEFAULT_AMMO));
    }

    public Pistol(int ammo, int maxAmmo) {
        super(ammo);
        Validate.isZeroNegativeException("Вместимость пистолета должна быть положительной", maxAmmo);
        if (ammo > maxAmmo) throw new IllegalArgumentException("Патронов не может быть больше, чем вмещает пистолет: " + maxAmmo);
        this.maxAmmo = maxAmmo;
    }

    public Pistol(Pistol other) {
        super(other);
        this.maxAmmo = other.maxAmmo;
    }

    //region getters

    public int getMaxAmmo() {
        return maxAmmo;
    }

    //endregion

    //region setters

    @Override
    public void setAmmo(int ammo) {
        if (ammo > maxAmmo) throw new IllegalArgumentException("Патронов не может быть больше, чем вмещает пистолет");
        super.setAmmo(ammo);
    }

    //endregion

    public boolean isLoaded() {
        return getAmmo() > 0;
    }

    @Override
    public void shoot() {
        if (takeAmmo()) {
            System.out.println("Бах!");
        } else {
            System.out.println("Клац!");
        }
    }

    public int reload(int count) {
        Validate.isNegativeException("Отрицательного числа патронов быть не может.", count);
        int taken = Math.min(count, maxAmmo - getAmmo());
        setAmmo(getAmmo() + taken);
        return count - taken;
    }

    public int unload() {
        int returned = getAmmo();
        setAmmo(0);
        return returned;
    }

    @Override
    public Weapon copy() {
        return new Pistol(this);
    }

    @Override
    public String toString() {
        return "Пистолет: " + getAmmo() + "/" + maxAmmo;
    }
}
