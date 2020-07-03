package com.data.structure;

public class DataStructurePractise {

    public static boolean isBackStr(String s) throws Exception {
        boolean res = true;
        int len = s.length();
        char[] ch = s.toCharArray();
        if (len % 2 != 0) {
            int middle = (len - 1) / 2;
            for (int i=0; i < middle; i++) {
                if (ch[i] == ch[len - 1 - i]) {
                    continue;
                } else {
                    res = false;
                    break;
                }
            }
        } else {
            int middle = (len / 2) - 1;
            for (int i=0; i <= middle; i++) {
                if (ch[i] == ch[len - 1 - i]) {
                    continue;
                } else {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        String s1 = "abcdefedcba";
        String s2 = "abcdeffedcba";
        String s3 = "sdfasdfasdfs";

        System.out.println(isBackStr(s1));
        System.out.println(isBackStr(s2));
        System.out.println(isBackStr(s3));
    }
}
