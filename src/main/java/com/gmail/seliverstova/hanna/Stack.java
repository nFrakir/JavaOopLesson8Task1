package com.gmail.seliverstova.hanna;

import java.util.Arrays;

public class Stack {
    private BlackList blackList;
    private Object[] stack = new Object[10];

    public Stack(BlackList blackList) {
        super();
        this.blackList = blackList;
    }

    public Stack() {
        super();
    }

    public Object[] getStack() {
        return stack;
    }

    public void setStack(Object[] stack) {
        this.stack = stack;
    }

    public Object removeObject() {
        int index = getLastIndex();
        if (index == -1) {
            return null;
        }
        index = (index == 0) ? 0 : (index - 1);
        Object obj = stack[index];
        stack[index] = null;
        return obj;
    }

    public Object getObject() {
        int index = getLastIndex();
        if (index == -1) {
            return null;
        }
        index = (index == 0) ? 0 : (index - 1);
        Object obj = stack[index];
        return obj;
    }

    public void addObject(Object obj) throws IllegalArgumentException {
        if (blackList.isOpjectClassPresent(obj)) {
            throw new IllegalArgumentException("Class of this object is in black list");
        }
        add(obj);
    }

    private void add(Object obj) {
        int index = getLastIndex();
        if (index == -1) {
            index = stack.length;
            resize();
        }
        stack[index] = obj;
    }

    private void resize() {
        Object[] tmp = Arrays.copyOf(stack, (stack.length + 10));
        stack = tmp;
    }

    private int getLastIndex() {
        int index = -1;
        for (int i = 0; i < stack.length; i++) {
            if (stack[i] == null) {
                index = i;
                break;
            }
        }
        return index;
    }
}
