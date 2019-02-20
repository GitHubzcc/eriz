package com.eriz.localTest;

import javax.swing.tree.TreeNode;
import java.io.Serializable;
import java.util.*;

/**
 * 手写hashMap
 */
public class LocalHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {

    private static final long serialVersionUID = 12312312363181265L;

    /**
     * 默认大小 2的4次方
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    /**
     * 最大值 2的30次方
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 加载因子
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 转换红黑树的临界值（当链表长度大于此值时，将链表结构转换为红黑树结构）
     */
    static final int TREEIFY_THRESHOLD = 8;

    /**
     * 恢复成链式结构的桶大小临界值
     * 小于TREEIFY_THRESHOLD，临界值最大为6
     */
    static final int UNTREEIFY_THRESHOLD = 6;


    /**
     * 桶可能被转化为树形结构的最小容量。当哈希表的大小超过这个阈值，才会把链式结构转化成树型结构，
     * 否则仅采取扩容来尝试减少冲突。应该至少4*TREEIFY_THRESHOLD来避免扩容和树形结构化之间的冲突。
     */
    static final int MIN_TREEIFY_CAPACITY = 64;

    /**
     * 通过key 获取hash值(计算相当复杂，降低hash碰撞的几率)
     *
     * @param key key值
     */
    static final int hash(Object key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }


        @Override
        public final K getKey() {
            return key;
        }

        @Override
        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) obj;
                if (Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue())) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * transient修饰关键字 为序列化时忽略属性
     * <p>
     * 键值对数组
     */
    transient Node<K, V>[] table;

    /**
     * 键值对缓存，它们的映射关系集合保存在entrySet中。即使Key在外部修改导致hashCode变化，缓存中还可以找到映射关系
     */
    transient Set<Map.Entry<K, V>> entrySet;

    /**
     * hashMap的大小
     */
    transient int size;

    /**
     * 记录HashMap被修改结构的次数。
     * 修改包括改变键值对的个数或者修改内部结构，比如rehash
     * 这个域被用作HashMap的迭代器的fail-fast机制中（参考ConcurrentModificationException）
     */
    transient int modCount;

    /**
     * 扩容的临界值，通过capacity * loadfactor可以计算出来。超过这个值HashMap将进行扩容
     */
    int threshold;

    /**
     * 加载因子
     */
    final float loadFactor;

    /**
     * 初始化hashMap
     *
     * @param initialCapacity 初始大小
     * @param loadFactor      初始加载因子
     */
    public LocalHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            System.out.println("抛出异常");
        }
        if (initialCapacity > MAXIMUM_CAPACITY) {
            initialCapacity = MAXIMUM_CAPACITY;
        }
        if (loadFactor < 0 || Float.isNaN(loadFactor)) {
            System.out.println("加载因子不能小于0");
        }
        //赋值加载因子、赋值扩容临界值
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }

    /**
     * 初始化hashmap
     *
     * @param initialCapacity 初始化大小、使用默认加载因子
     */
    public LocalHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * 使用已有的map 构建hashMap
     *
     * @param map
     */
    public LocalHashMap(Map<? extends K, ? extends V> map) {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        putMapEntries(map, false);
    }

    final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
        int s = m.size();
        if (s > 0) {
            //table 不存在
            if (table == null) {
                //table未初始化，从新初始化，hashMap允许的容器大小为initialCaptacity*loadFactor
                //则此时为s/loadFactor 则为容器大小
                float ft = ((float) s / loadFactor) + 1.0F;
                //判断ft此时的大小是否大于最大容器
                int t = ((ft < (float) MAXIMUM_CAPACITY) ? (int) ft : MAXIMUM_CAPACITY);
                //如果容量大于临界值
                if (t > threshold) {
                    threshold = tableSizeFor(t);
                }
            }
            //存在且大于临界值 则需要扩容
            else if (s > threshold) {
                resize();
            }
            //将map中所有键值对添加到hashMap中
            for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
                K key = e.getKey();
                V value = e.getValue();
                putVal(hash(key), key, value, false, evict);
            }
        }
    }

    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        Node<K, V>[] tab;
        Node<K, V> p;
        int n, i;
        // 如果哈希表为空，调用resize
        if ((tab = table) == null || (n = tab.length) == 0) {
            n = (tab = resize()).length;
        }
        // 如果指定参数hash在表中没有对应的桶，即为没有碰撞
        if ((p = tab[i = (n - 1) & hash]) == null) {
            //直接将键值插入到map中即可
        }
        //发生碰撞了
        else {
            Node<K, V> e;
            K k;
            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))) {
                //记录第一个节点
                e = p;
            }
            //如果桶中的第一个节点没有匹配上，且桶内为红黑树结构，则调用红黑树对应的方法插入键值对
            else if (p instanceof TreeNode) {
                //
                e = null;//((HashMap.TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            }
            //不是红黑树
            else {
                //遍历链式结构
                for (int binCount = 0; ; ++binCount) {
                    //如果到了链表尾部
                    if ((e = p.next) == null) {
                        //在链表尾部插入键值对
                        //p.next = newNode(hash, key, value, null);
                        //如果链的长度大于TREEIFY_THRESHOLD这个临界值，则把链变为红黑树
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            //treeifyBin(tab, hash);
                            //跳出循环
                            break;
                    }
                    //如果找到了重复的key，判断链表中结点的key值与插入的元素的key值是否相等，如果相等，跳出循环
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    //用于遍历桶中的链表，与前面的e = p.next组合，可以遍历链表
                    p = e;
                }
            }
            if (e != null) {
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null) {
                    e.value = value;
                }
                //访问后回调
                afterNodeAccess(e);
                return oldValue;
            }
        }
        //结构型修改次数+1
        ++modCount;
        //判断是否需要扩容
        if (++size > threshold) {
            resize();
        }
        //插入后回调
        afterNodeInsertion(evict);
        return null;
    }

    // Callbacks to allow LinkedHashMap post-actions
    void afterNodeAccess(Node<K, V> p) {
    }

    void afterNodeInsertion(boolean evict) {
    }

    void afterNodeRemoval(Node<K, V> p) {
    }

    /**
     * 扩容
     */
    final Node<K, V>[] resize() {
        //新建oldTable数组保存扩容前的数组table
        Node<K, V>[] oldTable = table;
        //获取数组扩容前的大小
        int oldCap = (oldTable == null) ? 0 : oldTable.length;
        //获取扩容前的临界值
        int oldThr = threshold;
        int newCap, newThr = 0;
        //1、如果数组存在，
        if (oldCap > 0) {
            //2、判断当前容量达到最大，无法扩容
            if (oldCap >= MAXIMUM_CAPACITY) {
                //扩容临界值提高到无穷大
                threshold = Integer.MAX_VALUE;
                return oldTable;
            }
            //3、没有达到最大
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap >= DEFAULT_INITIAL_CAPACITY) {
                // << 逻辑运算，为oldThr * 2的1次方，即变为与拿来的2倍
                newThr = oldThr << 1;
            }
        }
        //旧容量<=0 且旧临界值>0
        else if (oldThr > 0) {
            //数组容量大小设置为数组扩容的临界值
            newCap = oldThr;
        }
        //旧容量 <=0 且临界值 <=0,此时为第一次使用容器，赋值默认值
        else {
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        }
        //在当上面的条件判断中，只有oldThr > 0成立时，newThr == 0
        if (newThr == 0) {
            //ft为临时临界值，下面会确定这个临界值是否合法，如果合法，那就是真正的临界值
            float ft = (float) newCap * loadFactor;
            //当新容量< MAXIMUM_CAPACITY且ft < (float)MAXIMUM_CAPACITY，新的临界值为ft，否则为Integer.MAX_VALUE
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY ? (int) ft : Integer.MAX_VALUE);
        }
        //将新临界值设置
        threshold = newThr;
        @SuppressWarnings({"rawtypes", "unchecked"})
        Node<K, V>[] newTable = (Node<K, V>[]) new Node[newCap];
        table = newTable;
        if (oldTable != null) {
            for (int j = 0; j < oldCap; j++) {
                Node<K, V> e;
                if ((e = oldTable[j]) != null) {
                    oldTable[j] = null;
                    //如果旧桶中只有一个node
                    if (e.next == null) {
                        newTable[e.hash & (newCap - 1)] = e;
                    }
                    //如果旧桶中的结构为红黑树
                    else if (e instanceof TreeNode) {
                        //TODO 将树中的node分离

                    }
                    //如果旧桶中的结构为链表
                    else {
                        //低位节点（旧数组）
                        Node<K, V> loHead = null, loTail = null;
                        //高位节点（新数组）
                        Node<K, V> hiHead = null, hiTail = null;
                        //下一个节点
                        Node<K, V> next;
                        //遍历整个链表中的节点
                        do {
                            next = e.next;
                            //例如hash值为17，旧数组大小16，扩容后为32，如hash值为15，而此时在低位[0-15]运算（[0-15]为低位[16-31]为高位）
                            //节点的hash值和旧数组长度做与运算，=0则元素hash值大于数组长度，此时在数组的低位做计算
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null) {
                                    loHead = e;
                                } else {
                                    loTail.next = e;
                                }
                                loTail = e;
                            }
                            // !=0 则hash值小于数组长度，此时在数组的高位做计算
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        // 低位的元素组成的链表还是放置在原来的位置
                        if (loTail != null) {
                            loTail.next = null;
                            newTable[j] = loHead;
                        }
                        // 高位的元素组成的链表放置的位置只是在原有位置上偏移了老数组的长度个位置。即j+oldCap个位置
                        if (hiTail != null) {
                            hiTail.next = null;
                            // 例：hash为 17 在老数组放置在0下标，在新数组放置在16下标；
                            newTable[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTable;
    }

    /**
     * 通过key获取hashMap中的值
     *
     * @param key hash的key
     * @return 对应的值
     */
    public V get(Object key) {
        Node<K, V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.getValue();
    }

    final Node<K, V> getNode(int hash, Object key) {
        //定义参数
        Node<K, V>[] tab;
        Node<K, V> first, e;
        int n;
        K k;
        //判断数组是否为空，并且判断first = tab[(n - 1) & hash]第一个节点是否为空。(n - 1) & hash快速定位下标
        if ((tab = table) != null && (n = tab.length) > 0 && (first = tab[(n - 1) & hash]) != null) {
            //always check first node，判断第一个节点的hash值与key是否相等
            if (first.hash == hash && (((k = first.key) == key) || (key != null && key.equals(k)))) {
                return first;
            }
            //下一个节点是否为空
            if ((e = first.next) != null) {
                //是否为红黑树
                if (first instanceof TreeNode) {
                    //
                }
                //循环链表
                do {
                    //判断是否相同
                    if (e.hash == hash && ((k = e.key) == key || (key != null) && key.equals(k))) {
                        return e;
                    }
                } while ((e = e.next) != null);
            }

        }
        return null;
    }

    /**
     * 清理数组
     */
    public void clear() {
        Node<K, V>[] tab;
        if ((tab = table) != null) {
            size = 0;
            for (int i = 0; i < tab.length; i++) {
                tab[i] = null;
            }
        }
    }

    /**
     * 返回大于等于cap的最小的二次幂数值。
     *
     * @param cap
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    /**
     * 红黑树
     */
    /*static final class TreeNode<K, V> extends LinkedHashMap.Entry<K, V> {
        TreeNode<K, V> parent;  // red-black tree links
        TreeNode<K, V> left;
        TreeNode<K, V> right;
        TreeNode<K, V> prev;    // needed to unlink next upon deletion
        boolean red;

        TreeNode(int hash, K key, V val, Node<K, V> next) {
            super(hash, key, val, next);
        }

        */

    /**
     * Returns root of tree containing this node.
     *//*
        final TreeNode<K, V> root() {
            for (TreeNode<K, V> r = this, p; ; ) {
                if ((p = r.parent) == null)
                    return r;
                r = p;
            }
        }
    }*/
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(map.put("q", "2"));
        System.out.println(map.put("w", "6"));
        System.out.println(map.put("e", "7"));
        System.out.println(map.get("q").hashCode());
        System.out.println(map.get("w").hashCode());
        System.out.println(map.get("e").hashCode());
        System.out.println(5 & 55);
        /*Map<String, Object> map1 = new LocalHashMap<>(12);
        map1.put("aaa", "123");
        System.out.println(map1.toString());*/


    }
}
