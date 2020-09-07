package com.company;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Main {

    public static void main(String[] args) {

        Multitude m = new Multitude();
        System.out.println(m);
        LinkedHashSet<Object> a1 = new LinkedHashSet<>();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);
        a1.add(5);
        a1.add(6);
        a1.add(7);
        Multitude m1 = new Multitude(a1);
        System.out.println(m1);
        m.addToMultitude(1);
        m.addToMultitude(3);
        m.addToMultitude(5);
        Multitude m2 = m.union(m1);
        System.out.println(m2);
        Multitude m3 = m.difference(m1);
        System.out.println(m3);
        Multitude m4 = m.intersection(m1);
        System.out.println(m4);

        m4.addToMultitude(m1);
        System.out.println(m4);
        Multitude m6 = m1.booleanMultiple();
        System.out.println(m6);

    }
}
