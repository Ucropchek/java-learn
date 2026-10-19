package ru.seroglazov.city;

import java.util.ArrayList;

import ru.seroglazov.validation.Validate;

public class Town {
    private String title;
    private ArrayList<Way> ways;

    public Town(String title, Way... ways) {
        if (Validate.isNull(title) || title.isBlank()) title = "unknown";
        this.title = title;
        this.ways = buildWays(ways);
    }

    //region getters

    public String getTitle() {
        return title;
    }

    public ArrayList<Way> getWays() {
        return copyWays(ways);
    }

    //endregion

    //region setters

    public void setTitle(String title) {
        if (Validate.isNull(title) || title.isBlank()) title = "unknown";
        this.title = title;
    }

    public void setWays(ArrayList<Way> ways) {
        this.ways = buildWays(ways);
    }

    public void setWays(Way... ways) {
        this.ways = buildWays(ways);
    }

    //endregion

    public void addWay(Way way) {
        putWay(ways, way);
    }

    public void addWay(Town townTo, int cost) {
        addWay(new Way(townTo, cost));
    }

    public boolean removeWay(Town townTo) {
        Validate.isNullException("Передайте город, дорогу в который нужно удалить.", townTo);
        boolean removed = false;
        for (int i = ways.size() - 1; i >= 0; i--) {
            if (ways.get(i).getTownTo() == townTo) {
                ways.remove(i);
                removed = true;
            }
        }
        return removed;
    }

    private static void putWay(ArrayList<Way> target, Way way) {
        Validate.isNullException("Нельзя добавить пустую дорогу", way);
        for (Way w : target) {
            if (w.getTownTo() == way.getTownTo()) {
                w.setCost(way.getCost());
                return;
            }
        }
        target.add(new Way(way));
    }

    private static ArrayList<Way> buildWays(ArrayList<Way> ways) {
        ArrayList<Way> result = new ArrayList<>();
        if (Validate.isNull(ways)) return result;
        for (Way w : ways) {
            putWay(result, w);
        }
        return result;
    }

    private static ArrayList<Way> buildWays(Way[] ways) {
        ArrayList<Way> result = new ArrayList<>();
        if (ways == null) return result;
        for (Way w : ways) {
            putWay(result, w);
        }
        return result;
    }

    private static ArrayList<Way> copyWays(ArrayList<Way> ways) {
        ArrayList<Way> result = new ArrayList<>(ways.size());
        for (Way w : ways) {
            result.add(new Way(w));
        }
        return result;
    }

    @Override
    public String toString() {
        String returnString = "Город " + title;
        for (Way w : ways) {
            returnString += "\n" + w.getTownTo().getTitle() + ": " + w.getCost();
        }
        return returnString;
    }
}