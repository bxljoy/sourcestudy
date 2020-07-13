package com.data.structure;

public class SeqList<T> {

    protected Object[] element;       //顺序表的存储数组
    protected int n;                  //顺序表元素个数

    public SeqList(int length) {      //构造容量为length的空表
        this.element = new Object[length];
        this.n = 0;
    }

    public SeqList() {                //构造默认容量的空表
        this(64);
    }

    public SeqList(T[] values) {      //构造顺序表，有values数组提供元素，忽略其中空对象
        for (int i=0; i<values.length; i++)
            this.element[i] = values[i];
        this.n = element.length;
    }


    boolean isEmpty() {               //判断线性表是否为空，若空返回true
        return this.n == 0;
    }

    int size() {                      //返回线性表元素个数（长度）
        return this.n;
    }

    T get(int i){                     //返回第i个元素
        if (i>=0 && i<this.n)
            return (T)this.element[i];
        return null;
    }

    void set(int i, T x) {            //设置第i个元素为x
        if (i>=0 && i<this.n) {
            this.element[i] = x;
        }
    }

    public String toString() {               //返回线性表所有元素的描述字符串
        StringBuilder sb = new StringBuilder();
        if (this.n > 0) {
            for (int i=0; i<this.n; i++) {
                if (i == 0) {
                    sb.append(this.element[i]);
                } else {
                    sb.append(",").append(this.element[i]);
                }
            }
            return sb.toString();
        }
        return null;
    }

    int insert(int i, T x) {                 //插入x作为第i个元素，x!=null
        if (i>=0 && i<this.n) {
            for (int j=i+1; j<this.n;j++) {
                element[j] = element[j-1];
            }
            element[i] = x;
            this.n++;
            return 1;
        }
        return 0;
    }

    int insert(T x) {                       //在线性表最后插入x元素，返回x序号
        this.element[this.n] = x;
        this.n++;
        return this.n;
    }

    T remove(int i) {                       //删除第i个元素，返回被删除元素
        T res = null;
        if (i>=0 && i<this.n) {
            res = (T)element[i];
            for (int j=i;j<n-1;j++) {
                element[j] = element[j+1];
            }
            n--;
        }
        return res;
    }

    void clear() {                           //删除线性表所有元素
        this.n = 0;
        this.element = null;
    }

    int search(T key) {                      //查找首次出现的与key相等元素，返回元素序号i
        int res = -1;
        for (int i=0; i<n; i++) {
            if (this.element[i] == key) {
                res = i;
                break;
            }
        }
        return res;
    }

    boolean contains(T key) {                //判断是否包含关键字为key元素
        boolean res = false;
        for (int i=0; i<n; i++) {
            if (this.element[i] == key) {
                res = true;
                break;
            }
        }
        return res;
    }

    T remove(T key) {                        //删除首次出现的与key相等元素，返回被删除元素
        int i = this.search(key);
        if (i >= 0) {
            T res = this.remove(i);
            return res;
        }
        return null;
    }

//    boolean equals(Object obj);                  //比较两个线性表所有元素是否对应相等
}
