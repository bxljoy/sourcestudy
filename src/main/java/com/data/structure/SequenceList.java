package com.data.structure;

/**
 * 顺序存储线性表（简单实现）
 *
 */
public class SequenceList {
    private final int DEFAULT_SIZE = 10;
    private String [] data = new String[DEFAULT_SIZE];
    private int listLength = 0;
    private int arrayLengh = 0;

    /**
     * 在顺序表末尾添加新元素
     *
     * @param element
     */
    public void appendElement(String element) {
        if (listLength >= data.length) {
            String[] temp = new String[listLength + DEFAULT_SIZE];
            for (int i=0; i<listLength; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        data[listLength ++] = element;
        arrayLengh = data.length;
    }

    /**
     * 获取指定位置的元素
     *
     * @param index
     * @return
     */
    public String getElement(int index) {
        return index<0 || index>=data.length ? null : data[index];
    }

    /**
     * 获取给定元素的位置，若存在返回位置下标；不存在则返回0
     *
     * @param element
     * @return
     */
    public int locateElement(String element) {
        int position = 0;
        for (int i=0; i<data.length; i++) {
            if (element.equals(data[i])) {
                position = i;
                break;
            }
        }
        return position;
    }

    /**
     * 指定位置插入元素到顺序表
     *
     * @param element
     * @param index
     * @return
     */
    public int insertElement(String element, int index) {
        int res = 0;
        if (listLength >= data.length) {
            String[] temp = new String[listLength + DEFAULT_SIZE];
            for (int i=0; i<listLength; i++) {
                temp[i] = data[i];
            }
            data = temp;
            arrayLengh = data.length;
        }

        if (index <= listLength) {
            for (int i=listLength-1; i>=index; i--) {
                data[i+1] = data[i];
            }
            data[index] = element;
            listLength++;
            res = 1;
        }

        return res;
    }

    /**
     * 删除指定位置的元素
     *
     * @param index
     */
    public int removeElement(int index) {
        int res = 0;
        if (index < listLength) {
            for (int i=index; i<listLength-1; i++) {
                data[i] = data[i+1];
            }
            listLength--;
            res = 1;
        }
        return res;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (String s : this.data) {
            res.append(s).append(",");
        }
        return res.toString();
    }

    public String toLinearString() {
        StringBuilder res = new StringBuilder();
        for (int i=0; i<this.listLength; i++) {
            res.append(data[i]).append(",");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        SequenceList linearList = new SequenceList();
        linearList.appendElement("a");
        linearList.appendElement("b");
        linearList.appendElement("c");
        linearList.appendElement("d");
        linearList.appendElement("e");
        linearList.appendElement("f");

        System.out.println("arrayLength = " + linearList.arrayLengh);
        System.out.println("listLength = " + linearList.listLength);
        System.out.println(linearList.toString());
        System.out.println(linearList.toLinearString());

        System.out.println("插入新元素后：");
        linearList.insertElement("o", 3);

        System.out.println("arrayLength = " + linearList.arrayLengh);
        System.out.println("listLength = " + linearList.listLength);
        System.out.println(linearList.toString());
        System.out.println(linearList.toLinearString());

        System.out.println("删除元素后：");
        linearList.removeElement(6);

        System.out.println("arrayLength = " + linearList.arrayLengh);
        System.out.println("listLength = " + linearList.listLength);
        System.out.println(linearList.toString());
        System.out.println(linearList.toLinearString());

        System.out.println("查找指定元素：" + linearList.getElement(5));

    }

}
