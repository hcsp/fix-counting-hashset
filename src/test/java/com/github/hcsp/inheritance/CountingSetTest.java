package com.github.hcsp.inheritance;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountingSetTest {
    CountingSet set = new CountingSet();

    @Test
    public void testAdd() {
        set.add(1);
        set.remove(1);
        set.add(2);
        set.remove(2);
        set.add(3);
        set.remove(3);
        Assertions.assertEquals(0, set.size());
        Assertions.assertEquals(3, set.getCount());
    }

    @Test
    public void testAddAll() {
        set.addAll(Arrays.asList(1, 1, 2, 2, 3, 3));
        set.removeAll(Arrays.asList(1, 2, 3));
        set.addAll(Arrays.asList(1, 2));
        Assertions.assertEquals(2, set.size());
        Assertions.assertEquals(8, set.getCount());
    }
}
