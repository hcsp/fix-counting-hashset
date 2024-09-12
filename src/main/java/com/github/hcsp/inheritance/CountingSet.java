package com.github.hcsp.inheritance;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class CountingSet extends HashSet<Object> {
    /** 统计"有史以来"向该集合中添加过的元素个数 */
    private int count = 0;
    private final HashSet<Object> seen = new HashSet<>();

    @Override
    public boolean add(Object obj) {
        // 如果对象之前没有被添加过
        if (seen.add(obj)) {
            count++;
        }
        return super.add(obj);
    }

    @Override
    public boolean addAll(Collection c) {
        boolean changed = false;
        for (Object obj : c) {
            if (seen.add(obj)) {
                count++;
                changed = true;
            }
        }
        return changed || super.addAll(c);
    }

    public int getCount() {
        return count;
    }

    // 测试代码
    public static void main(String[] args) {
        CountingSet countingSet = new CountingSet();
        countingSet.add(new Object());
        countingSet.addAll(Arrays.asList(1, 2, 3));

        System.out.println(countingSet.getCount()); // 应该输出4
    }
}
