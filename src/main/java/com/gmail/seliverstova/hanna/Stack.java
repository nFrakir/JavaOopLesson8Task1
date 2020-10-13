package com.gmail.seliverstova.hanna;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private List<Object> stack = new ArrayList<>();
    private BlackList blackList;

    public Stack(BlackList blackList) {
        super();
        this.blackList = blackList;
    }

    public Stack() {
        super();
    }

    public Object removeObject() {
        if (stack.isEmpty()) {
            return null;
        }
        Object obj = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return obj;
    }

    public Object getObject() {
        if (stack.isEmpty()) {
            return null;
        }
        Object obj = stack.get(stack.size() - 1);
        return obj;
    }

    public void addObject(Object obj) throws IllegalArgumentException {
        if (blackList.isOpjectClassPresent(obj)) {
            throw new IllegalArgumentException("Class of this object is in black list");
        }
        stack.add(obj);
    }
}
