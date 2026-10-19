package ru.seroglazov.city;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoLinkedTown extends Town {
    public TwoLinkedTown(String title, Way... ways) {
        super(title);
        if (ways != null) {
            for (Way w : ways) {
                addWay(w);
            }
        }
    }

    @Override
    public void addWay(Way way) {
        super.addWay(way);
        Town townTo = way.getTownTo();
        if (!hasWay(townTo, this, way.getCost())) {
            townTo.addWay(this, way.getCost());
        }
    }

    @Override
    public void setWays(ArrayList<Way> ways) {
        for (Way w : getWays()) {
            removeWay(w.getTownTo());
        }
        if (ways == null) return;
        for (Way w : ways) {
            addWay(w);
        }
    }

    @Override
    public void setWays(Way... ways) {
        ArrayList<Way> list = new ArrayList<>();
        if (ways != null) {
            list.addAll(Arrays.asList(ways));
        }
        setWays(list);
    }

    @Override
    public boolean removeWay(Town townTo) {
        boolean isRemovedTownTo = super.removeWay(townTo);
        if (isRemovedTownTo) townTo.removeWay(this);
        return isRemovedTownTo;
    }

    private static boolean hasWay(Town townFrom, Town townTo, int cost) {
        for (Way wFrom : townFrom.getWays()) {
            if (wFrom.getTownTo() == townTo && wFrom.getCost() == cost) return true;
        }
        return false;
    }
}
