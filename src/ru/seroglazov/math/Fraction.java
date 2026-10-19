package ru.seroglazov.math;

import ru.seroglazov.validation.Validate;

public final class Fraction extends Number {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Знаменатель дроби не может быть равен нулю");
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    //region getters

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    //endregion

    public Fraction sum(Fraction other) {
        Validate.isNullException("Передайте существующую дробь", other);
        return new Fraction(numerator * other.denominator + other.numerator * denominator, denominator * other.denominator);
    }

    public Fraction sum(int number) {
        return sum(new Fraction(number, 1));
    }

    public Fraction minus(Fraction other) {
        Validate.isNullException("Передайте существующую дробь", other);
        return new Fraction(numerator * other.denominator - other.numerator * denominator, denominator * other.denominator);
    }

    public Fraction minus(int number) {
        return minus(new Fraction(number, 1));
    }

    public Fraction mult(Fraction other) {
        Validate.isNullException("Передайте существующую дробь", other);
        return new Fraction(numerator * other.numerator, denominator * other.denominator);
    }

    public Fraction mult(int number) {
        return mult(new Fraction(number, 1));
    }

    public Fraction div(Fraction other) {
        Validate.isNullException("Передайте существующую дробь", other);
        if (other.numerator == 0) throw new IllegalArgumentException("Делить на ноль нельзя");
        return new Fraction(numerator * other.denominator, denominator * other.numerator);
    }

    public Fraction div(int number) {
        return div(new Fraction(number, 1));
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return (long) numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}