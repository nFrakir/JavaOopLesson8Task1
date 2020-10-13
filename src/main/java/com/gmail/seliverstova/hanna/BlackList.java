package com.gmail.seliverstova.hanna;

import java.util.Arrays;

public class BlackList {
    private Class<?>[] blackList = new Class<?>[10];

    public BlackList() {
        super();
    }

    public void addToBlackList(Object obj) {
        if (!findElement(obj.getClass())) {
            add(obj.getClass());
        }
    }

    public boolean isOpjectClassPresent(Object obj) {
        return findElement(obj.getClass());
    }

    private void resize() {
        Class<?>[] tmp = Arrays.copyOf(blackList, (blackList.length + 10));
        blackList = tmp;
    }

    private int getLastIndex() {
        int index = -1;
        for (int i = 0; i < blackList.length; i++) {
            if (blackList[i] == null) {
                index = i;
                break;
            }
        }
        return index;
    }

    private void add(Class<?> obj) {
        int index = getLastIndex();
        if (index == -1) {
            index = blackList.length;
            resize();
        }
        blackList[index] = obj;
    }

    private boolean findElement(Class<?> neddle) {
        for (Class<?> element : blackList) {
            if (neddle == element) {
                return true;
            }
        }
        return false;
    }
}
