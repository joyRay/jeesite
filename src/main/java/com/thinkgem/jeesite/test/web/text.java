package com.thinkgem.jeesite.test.web;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ZhaoHonglei on 2017-3-30.
 */
public class text {

    public static void main(String[] args) {
        String str = "/webapirvice/base/getPersonInfoByNamepersonName=张磊A&appkey=86609f84&time=1490844641962e6e22b8ccd104f8d9fe953012d0abf8c";
        System.out.println(md5JdkAPI(str));
    }
    /**
     * 使用JDK API生成md5
     */
    private static String md5JdkAPI(String input) {
        byte[] source = input.getBytes();
        String s = null;
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };// 用来将字节转换成16进制表示的字符
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            byte tmp[] = md.digest();// MD5 的计算结果是一个 128 位的长整数，
            // 用字节表示就是 16 个字节
            char str[] = new char[16 * 2];// 每个字节用 16 进制表示的话，使用两个字符， 所以表示成 16
            // 进制需要 32 个字符
            int k = 0;// 表示转换结果中对应的字符位置
            for (int i = 0; i < 16; i++) {// 从第一个字节开始，对 MD5 的每一个字节// 转换成 16
                // 进制字符的转换
                byte byte0 = tmp[i];// 取第 i 个字节
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];// 取字节中高 4 位的数字转换,// >>>
                // 为逻辑右移，将符号位一起右移
                str[k++] = hexDigits[byte0 & 0xf];// 取字节中低 4 位的数字转换
            }
            s = new String(str);// 换后的结果转换为字符串
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return s;
    }
}
