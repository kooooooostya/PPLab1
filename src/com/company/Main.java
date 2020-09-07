package com.company;
import java.util.LinkedHashSet;

public class Main {

    public static void main(String[] args) {

        Multitude m = new Multitude();
        System.out.println(m + " пустое множество m");
        LinkedHashSet<Object> a1 = new LinkedHashSet<>();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);
        a1.add(5);

        Multitude m1 = new Multitude(a1);
        System.out.println(m1 + " множество m1");
        m1.deleteItem(1);
        System.out.println(m1 + " множество m1 после удаления еденицы");
        m.addToMultitude(1);
        m.addToMultitude(3);
        m.addToMultitude(5);
        System.out.println(m + " множество m после добавления 1, 3, 5");
        Multitude m2 = m.union(m1);
        System.out.println(m2 + " объеденение множеств m и m1");
        Multitude m3 = m.difference(m1);
        System.out.println(m3 + " разность множеств m и m1");
        Multitude m4 = m.intersection(m1);
        System.out.println(m4 + " пересечение множеств m и m1");


        Multitude m6 = m1.booleanMultiple();
        System.out.println(m6 + " булеан множества m1");



    }
}
