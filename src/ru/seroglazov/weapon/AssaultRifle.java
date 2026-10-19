package ru.seroglazov.weapon;

import ru.seroglazov.validation.Validate;

public class AssaultRifle extends Pistol {
    private static final int DEFAULT_AMMO = 30;
    private static final int DEFAULT_FIRE_RATE = 30;
    private final int fireRate;

    public AssaultRifle() {
        this(DEFAULT_AMMO, DEFAULT_FIRE_RATE);
    }

    public AssaultRifle(int maxAmmo) {
        this(maxAmmo, Math.max(1, maxAmmo / 2));
    }

    public AssaultRifle(int maxAmmo, int fireRate) {
        super(maxAmmo, maxAmmo);
        Validate.isZeroNegativeException("Скорострельность должна быть положительной", fireRate);
        this.fireRate = fireRate;
    }

    public AssaultRifle(AssaultRifle other) {
        super(other);
        this.fireRate = other.fireRate;
    }

    public int getFireRate() {
        return fireRate;
    }

    @Override
    public void shoot() {
        for (int i = 0; i < fireRate; i++) {
            super.shoot();
        }
    }

    public void shoot(int seconds) {
        Validate.isNegativeException("Невозможно стрелять отрицательное кол-во секунд", seconds);
        for (int i = 0; i < seconds; i++) {
            shoot();
        }
    }

    @Override
    public Weapon copy() {
        return new AssaultRifle(this);
    }

    @Override
    public String toString() {
        return "Автомат (со скорострельностью" + fireRate + " выс/сек): " + getAmmo() + "/" + getMaxAmmo();
    }
}

