package com.gmail.seliverstova.hanna;

public class App {
    public static void main( String[] args ) {
        BlackList bl = new BlackList();
        Stack stack = new Stack(bl);

        stack.addObject(15);
        bl.addToBlackList(true);

        try {
            stack.addObject(15);
            stack.addObject("test");
            stack.addObject(false);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        System.out.println(stack.getObject());
        System.out.println();

        Object obj = (Object) "";
        for (; (obj = stack.removeObject()) != null;) {
            System.out.println(obj);
        }
        System.out.println("stack is empty");
    }
}
