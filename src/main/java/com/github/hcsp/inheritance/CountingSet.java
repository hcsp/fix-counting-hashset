package com.github.hcsp.inheritance;

import java.util.*;

public class CountingSet {
    /**
     * 统计"有史以来"向该集合中添加过的元素个数
     */
    private int count = 0;
    HashSet<Object> countingSet = new HashSet<>();

    public boolean add(Object obj) {
        count++;
        return countingSet.add(obj);
    }

    public boolean addAll(Collection<Object> c) {
        count += c.size();
        return countingSet.addAll(c);
    }

    public boolean remove(Object value) {
        return countingSet.remove(value);
    }

    public int getCount() {
        return count;
    }

    public int size() {
        return countingSet.size();
    }

    public boolean removeAll(Collection<Object> values) {
        return countingSet.removeAll(values);
    }

    // 我们希望创建一个Set，能够统计"有史以来"添加到其中去的元素个数
    // 但是，现在结果明显不对
    // 请尝试修复此问题
    public static void main(String[] args) {
        CountingSet countingSet = new CountingSet();
        countingSet.add(new Object());
        countingSet.addAll(Arrays.asList(1, 2, 3));

        System.out.println(countingSet.getCount());
    }
}
