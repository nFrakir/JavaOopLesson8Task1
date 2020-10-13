package com.gmail.seliverstova.hanna;

import java.util.ArrayList;
import java.util.List;

public class BlackList {
    private List<Class<?>> blackList = new ArrayList<>();

    public BlackList() {
        super();
    }

    public void addToBlackList(Object obj) {
        if (!blackList.contains((Object) obj.getClass())) {
            blackList.add(obj.getClass());
        }
    }

    public boolean isOpjectClassPresent(Object obj) {
        return blackList.contains((Object) obj.getClass());
    }
}
