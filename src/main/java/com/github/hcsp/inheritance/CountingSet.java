package com.github.hcsp.inheritance;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class CountingSet{
    HashSet<Object> hashSet = new HashSet<>();
    /** 统计"有史以来"向该集合中添加过的元素个数 */
    private int count = 0;

    public void add(Object obj) {
        this.hashSet.add(obj);
        this.setCount(1);
    }

    public void addAll(Collection c) {
        this.hashSet.addAll(c);
        this.setCount(c.size());
    }

    public void remove(Object obj) {
        this.hashSet.remove(obj);
    }

    public void removeAll(Collection c) {
        this.hashSet.removeAll(c);
    }

    public int getCount() {
        return this.count;
    }

    public int size() {
        return this.hashSet.size();
    }

    public void setCount(int count) {
        this.count += count;
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
