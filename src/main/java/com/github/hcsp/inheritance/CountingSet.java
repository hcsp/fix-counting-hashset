package com.github.hcsp.inheritance;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CountingSet {
    /** 统计"有史以来"向该集合中添加过的元素个数 */
    private int count = 0;
    
    private HashSet<Object> hashSet = new HashSet<>();

    public Iterator<Object> iterator() {
        return hashSet.iterator();
    }

    public int size() {
        return hashSet.size();
    }

    public boolean isEmpty() {
        return hashSet.isEmpty();
    }

    public boolean contains(Object o) {
        return hashSet.contains(o);
    }

    public boolean remove(Object o) {
        return hashSet.remove(o);
    }

    public void clear() {
        hashSet.clear();
    }

    public Object clone() {
        return hashSet.clone();
    }

    public Spliterator<Object> spliterator() {
        return hashSet.spliterator();
    }

    public Object[] toArray() {
        return hashSet.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return hashSet.toArray(a);
    }

    public boolean equals(Object o) {
        return hashSet.equals(o);
    }

    public int hashCode() {
        return hashSet.hashCode();
    }

    public boolean removeAll(Collection<?> c) {
        return hashSet.removeAll(c);
    }

    public boolean containsAll(Collection<?> c) {
        return hashSet.containsAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return hashSet.retainAll(c);
    }

    public String toString() {
        return hashSet.toString();
    }

    public <T> T[] toArray(IntFunction<T[]> generator) {
        return null;
    }

    public Stream<Object> stream() {
        return null;
    }

    public Stream<Object> parallelStream() {
        return null;
    }
    
    public boolean add(Object obj) {
        count++;
        return hashSet.add(obj);
    }

    
    public boolean addAll(Collection c) {
        count += c.size();
        return hashSet.addAll(c);
    }

    public int getCount() {
        return count;
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
