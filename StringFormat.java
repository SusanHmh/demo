package com.example.hsbc.utils;

import org.apache.commons.lang3.StringUtils;

public class StringFormat {

    /**
     * 删除大于或等于指定长度重复的字符串
     * @param oriData 原始字符串
     * @param delteRepeatLength 指定长度
     * @return
     */
    public static String delteRepeat(String oriData, int delteRepeatLength){
        StringBuilder sbData = new StringBuilder(oriData);
        for (int x = 0; x < sbData.length(); x++) {
            int innerStart = x+1;//内部循环起始位置
            for (int y = innerStart; y < sbData.length(); y++) {
                if (sbData.charAt(x) == sbData.charAt(y)){
                    innerStart ++;
                } else {
                    break;
                }
            }
            //内部循环跨度长度大于等于指定长度
            if (innerStart - x >= delteRepeatLength) {
                sbData.delete(x, innerStart);
                System.out.println("output -> " + sbData.toString());
                return delteRepeat(sbData.toString(), delteRepeatLength);
            }
        }
        return oriData;
    }

    /**
     * 大于或等于指定长度重复的字符串用未重复前的字符替换，无替换字符用“”
     * @param oriData 原始字符串
     * @param replaceRepeatLength 指定长度
     * @return
     */
    public static String replaceRepeat(String oriData, int replaceRepeatLength){
        StringBuilder sbData = new StringBuilder(oriData);
        for (int x = 0; x < sbData.length(); x++) {
            int innerStart = x+1;//内部循环起始位置
            for (int y = innerStart; y < sbData.length(); y++) {
                if (sbData.charAt(x) == sbData.charAt(y)){
                    innerStart ++;
                } else {
                    break;
                }
            }
            //内部循环跨度长度大于等于指定长度
            if (innerStart - x >= replaceRepeatLength) {
                String replace = sbData.substring(x, innerStart);
                String replaceVal = "";
                if (x > 0){
                    replaceVal = String.valueOf(sbData.charAt(x-1));
                }
                sbData.replace(x, innerStart, replaceVal);
                if (StringUtils.isNotBlank(replaceVal)) {
                    System.out.println("output -> " + sbData.toString() + ", "+ replace + " is replaced by " + replaceVal);
                } else {
                    System.out.println("output -> " + sbData.toString());
                }
                return replaceRepeat(sbData.toString(), replaceRepeatLength);
            }
        }
        return oriData;
    }



}
