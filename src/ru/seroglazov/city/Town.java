package ru.seroglazov.city;

import java.util.ArrayList;

import ru.seroglazov.validation.Validate;

public class Town {
    private static ArrayList<Town> openLeft = new ArrayList<>();
    private static ArrayList<Town> openRight = new ArrayList<>();

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Town other)) return false;
        for (int i = 0; i < openLeft.size(); i++) {
            if (openLeft.get(i) == this && openRight.get(i) == other) return true;
        }
        openLeft.add(this);
        openRight.add(other);
        boolean same = sameWays(other);
        openLeft.remove(openLeft.size() - 1);
        openRight.remove(openRight.size() - 1);
        return same;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    private boolean sameWays(Town other) {
        for (Way way : ways) {
            if (!hasEqualWay(other.ways, way)) return false;
        }
        for (Way way : other.ways) {
            if (!hasEqualWay(ways, way)) return false;
        }
        return true;
    }

    private static boolean hasEqualWay(ArrayList<Way> ways, Way way) {
        for (Way candidate : ways) {
            if (candidate.equals(way)) return true;
        }
        return false;
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