package com.github.hcsp.inheritance;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class CountingSet {
    HashSet<Object> set = new HashSet<>();
    /**
     * 统计"有史以来"向该集合中添加过的元素个数
     */
    private int count = 0;

    public boolean add(Object obj) {
        count++;
        return set.add(obj);
    }

    public boolean addAll(Collection c) {
        count += c.size();
        return set.addAll(c);
    }

    public int getCount() {
        return count;
    }

    public boolean remove(Object o) {
        return set.remove(o);
    }

    public int size() {
        return set.size();
    }

    public void removeAll(List<Object> l) {
        for (Object o : l
        ) {
            set.remove(o);
        }
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
