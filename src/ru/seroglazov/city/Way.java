package ru.seroglazov.city;

import ru.seroglazov.validation.Validate;

public class Way {
    private Town townTo;
    private int cost;

    public Way(Town townTo, int cost) {
        Validate.isNullException("Невозможно расчитать сумму пути без пункта назначения", townTo);
        this.townTo = townTo;
        this.cost = cost;
    }

    public Way(Way other) {
        Validate.isNullException("Вы пытаетесь скопировать пустой объект", other);
        this.cost = other.cost;
        this.townTo = other.townTo;
    }


    //region getters

    public Town getTownTo() {
        return townTo;
    }

    public int getCost() {
        return cost;
    }

    //endregion

    //region setters

    public void setTownTo(Town townTo) {
        Validate.isNullException("Невозможно построить путь в пустоту", townTo);
        this.townTo = townTo;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    //endregion
}
