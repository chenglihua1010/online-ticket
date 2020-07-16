package com.ticket.utils;

import java.util.Random;

public class RandomUtil {
        /**
         * java生成随机数字10位数
         *
         * @param length(随机生成的长度)
         * @return
         */
        public static String getRandomNickname(int length) {
                String val = "";
                Random random = new Random();
                for (int i = 0; i < length; i++) {
                        val += String.valueOf(random.nextInt(30));
                }
                return val;
        }

        /**
         * 获取一定长度的随机字符串
         * @param length 指定字符串长度
         * @return 一定长度的字符串
         */
        public static String getRandomStringByLength(int length) {
                String base = "abcdefghijklmnopqrstuvwxyz0123456789";
                Random random = new Random();
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < length; i++) {
                        int number = random.nextInt(base.length());
                        sb.append(base.charAt(number));
                }
                return sb.toString();
        }

        public static void main(String[] args) {
                System.out.println("java生成随机数字10位数：" + getRandomNickname(30));
        }
}