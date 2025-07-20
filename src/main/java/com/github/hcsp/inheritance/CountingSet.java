package com.github.hcsp.inheritance;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class CountingSet extends HashSet<Object> {
    /** 统计"有史以来"向该集合中添加过的元素个数 */
    private int count = 0;

    @Override
    public boolean add(Object obj) {
        count++;
        return super.add(obj);
    }

    @Override
    public boolean addAll(Collection<?> c) {
        boolean changed = false;
        for (Object obj : c) {
            if (add(obj)) {
                changed = true;
            }
        }
        return changed;
    }
    /*
    题目说的是：统计“有史以来”添加到其中去的元素个数
    但 Java 中的 Set 有一个特点：不能存重复元素
    所以如果：
    set.add(1);
    set.add(1);  // 不会被真正添加进去
    第二次 add(1) 虽然不会真的加进去，但它是一次明确的“尝试添加”
    所以说调用 add 方法一次，就是一次“添加操作”
    不管这个元素是否真的进入  Set, 都应该 count++

    ✅ 所以要改为：
    @Override
    public boolean add(Object obj) {
    count++;  // 每次 add 都要 count++
    return super.add(obj);  // Set 自己会决定是否真正添加

    其次, 明确：addAll(Collection<?> c) 本质上就是 对集合中每个元素都调用一次 add()
    所以：set.addAll(Arrays.asList(1, 1, 2, 2, 3, 3));
    等价于：
    set.add(1);
    set.add(1);
    set.add(2);
    set.add(2);
    set.add(3);
    set.add(3);
    ➡️ 总共 6 次 add() 尝试

    set.addAll(Arrays.asList(1, 2));
    等价于：
    set.add(1);
    set.add(2);
    ➡️ 又是 2 次 add() 尝试

    所以 addAll 总共执行了 6 + 2 = 8 次 add()
    在 add() 方法里写的 count++，就会累计 8 次

    public boolean addAll(Collection<?> c) {
        boolean changed = false;
        for (Object obj : c) {
            if (add(obj)) {
                changed = true;
         }
      }
        return changed;
    }
    ✔️ 每个 obj 都调用 add(obj)
    ✔️ 而 add(obj) 会 count++
    ✔️ 所以每次调用 addAll()，它会把集合里所有元素都算进 count

    所以说, addAll() 只是 Java 批量执行了多次 add()

    Set 不允许重复没关系，我们只关心：试了几次往里面加元素

    所以 count++ 要写在 add() 方法里，不在 addAll() 里写 count += c.size()
     */

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        CountingSet countingSet = new CountingSet();
        countingSet.add(new Object());
        countingSet.addAll(Arrays.asList(1, 2, 3));

        System.out.println(countingSet.getCount());
    }
}
