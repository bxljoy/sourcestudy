package com.source.integer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntegerSource {
    private final static Logger logger = LoggerFactory.getLogger(IntegerSource.class);
    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };

    /**
     * integer转为无符号二进制码，shift为进制，1为2进制，3为8进制，4为16进制
     *
     * @param i
     * @param shift
     * @return
     */
    public static String toUnsignedString(int i, int shift) {
        char[] buf = new char[32];
        int charPos = 32;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            buf[--charPos] = digits[i & mask];
            i >>>= shift;
        } while(i != 0);
        return new String(buf, charPos, 32 - charPos);
    }

    /**
     * integer转为32位二进制码，高位补0
     *
     * @param i
     * @return
     */
    public static String integer2BinaryString(int i) {
        char[] buf = new char[32];
        int charPos = 32;
        int mask = 1;
        while(charPos > 0) {
            buf[--charPos] = digits[i & mask];
            i >>>= mask;
        }
//        return new String(buf, charPos, 32 - charPos);
        return new String(buf);
    }


    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (char2Byte(achar[pos]) << 4 | char2Byte(achar[pos + 1]));
        }
        return result;
    }

    private static byte char2Byte(char c) {
        byte b = (byte) "0123456789abcdef".indexOf(c);
        return b;
    }

    /**
     * Byte转Bit
     */
    public static String byteToBit(byte b) {
        return "" +(byte)((b >> 7) & 0x1) +
                (byte)((b >> 6) & 0x1) +
                (byte)((b >> 5) & 0x1) +
                (byte)((b >> 4) & 0x1) +
                (byte)((b >> 3) & 0x1) +
                (byte)((b >> 2) & 0x1) +
                (byte)((b >> 1) & 0x1) +
                (byte)((b >> 0) & 0x1);
    }

    public static String bytesToBit(byte[] b) {
        String bitStr = "";
        for (int i = 0; i < b.length; i++) {
            bitStr = bitStr + (byte) ((b[i] >> 7) & 0x1)
                    + (byte) ((b[i] >> 6) & 0x1) + (byte) ((b[i] >> 5) & 0x1)
                    + (byte) ((b[i] >> 4) & 0x1) + (byte) ((b[i] >> 3) & 0x1)
                    + (byte) ((b[i] >> 2) & 0x1) + (byte) ((b[i] >> 1) & 0x1)
                    + (byte) ((b[i] >> 0) & 0x1);
        }
        return bitStr;
    }

    public static String hexString2BinaryString(String hex) {
        byte[] bytes = hexStringToByte(hex);
        String binStr = bytesToBit(bytes);
        return binStr;
    }

    public static void main(String[] args) {
        int bytes2 = 0b001101110000111;
        String source = Integer.toBinaryString(bytes2);
        logger.info(source);
        String target = toUnsignedString(bytes2, 1);
        logger.info(target);
        String target1 = integer2BinaryString(bytes2);
        logger.info(target1);
        String target2 = toUnsignedString(bytes2, 4);
        logger.info(target2);

        int a = 9;// 1001
        int b = 10;// 1010
        logger.info(integer2BinaryString(a & b));
        logger.info(integer2BinaryString(a | b));
        logger.info(integer2BinaryString(a ^ b));

        int c = -20; //原码
        int cc = ~c; //反码
        int ccc = ~c + 1;  //补码
        logger.info(integer2BinaryString(c));
        logger.info(integer2BinaryString(cc));
        logger.info(integer2BinaryString(ccc));

        String hex = "010000";
        logger.info(hexString2BinaryString(hex));

        int x = 0b000000001100;
        int y = 12;
        logger.info((x == y) + "");
    }

}
