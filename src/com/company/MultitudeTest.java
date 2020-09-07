package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MultitudeTest {
    Multitude multitude ;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        multitude = new Multitude();
        multitude.addToMultitude(1);
        multitude.addToMultitude(2);
        multitude.addToMultitude(3);
        multitude.addToMultitude(4);
    }

    @org.junit.jupiter.api.Test
    void addToMultitude() {
        int lastSize = multitude.getSize();
        multitude.addToMultitude(228);
        Assert.assertEquals(lastSize + 1, multitude.getSize());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        boolean empty = multitude.getSize() == 0;
        Assert.assertEquals(empty, multitude.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void deleteItem() {
        Object o = multitude.getMultitudeSet().toArray()[0];
        multitude.deleteItem(o);
        Assert.assertFalse(multitude.isConsistObject(o));
    }

    @org.junit.jupiter.api.Test
    void isConsistObject() {
        Object o = 5;
        multitude.addToMultitude(o);
        Assert.assertTrue(multitude.isConsistObject(o));
    }

    @org.junit.jupiter.api.Test
    void union() {
        Multitude m1 = new Multitude();
        m1.addToMultitude(1);
        m1.addToMultitude(2);
        m1.addToMultitude(3);
        Multitude m2 = new Multitude();
        m2.addToMultitude(2);
        m2.addToMultitude(3);
        m2.addToMultitude(4);

        Assert.assertEquals(4, m1.union(m2).getSize());
    }

    @org.junit.jupiter.api.Test
    void intersection() {
        Multitude m1 = new Multitude();
        m1.addToMultitude(1);
        m1.addToMultitude(2);
        m1.addToMultitude(3);
        Multitude m2 = new Multitude();
        m2.addToMultitude(2);
        m2.addToMultitude(3);
        m2.addToMultitude(4);

        Assert.assertEquals(2, m1.intersection(m2).getSize());
    }

    @org.junit.jupiter.api.Test
    void difference() {
        Multitude m1 = new Multitude();
        m1.addToMultitude(1);
        m1.addToMultitude(2);
        m1.addToMultitude(3);
        Multitude m2 = new Multitude();
        m2.addToMultitude(2);
        m2.addToMultitude(3);
        m2.addToMultitude(4);
        Multitude m3 =  m1.difference(m2);
        Assert.assertEquals(1, m3.getSize());
    }


    @Test
    void booleanMultiple() {
        int sizeNewMultitude = (int) Math.pow(2, multitude.getSize());
        Assert.assertEquals(sizeNewMultitude, multitude.booleanMultiple().getSize());
    }
}