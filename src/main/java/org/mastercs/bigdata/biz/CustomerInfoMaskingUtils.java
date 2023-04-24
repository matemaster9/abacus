package org.mastercs.bigdata.biz;


import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CustomerInfoMaskingUtils {

    private CustomerInfoMaskingUtils() {
    }

    /**
     * 对身份证号进行数据脱敏处理
     *
     * @param idCard 原始身份证号
     * @return 脱敏后的身份证号
     */
    public static String maskIdCard(String idCard) {
        if (idCard == null || idCard.length() == 0) {
            return "";
        }
        String regex = "(\\d{6})(\\d{8})(\\w{4})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(idCard);
        if (matcher.find()) {
            String birthDate = matcher.group(2);
            String replacement = "****" + birthDate.substring(4, 8);
            return matcher.replaceFirst("$1" + replacement + "$3");
        }
        return idCard;
    }

    /**
     * 对手机号进行数据脱敏处理
     *
     * @param phone 原始手机号
     * @return 脱敏后的手机号
     */
    public static String maskPhone(String phone) {
        if (phone == null || phone.length() == 0) {
            return "";
        }
        String regex = "(\\d{3})(\\d{4})(\\d{4})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        if (matcher.find()) {
            String replacement = "****";
            return matcher.replaceFirst("$1" + replacement + "$3");
        }
        return phone;
    }

    /**
     * 对中英文姓名进行数据脱敏处理
     *
     * @param name 姓名
     * @return 脱敏后的姓名
     */
    public static String maskChineseName(String name) {
        if (name == null || name.length() == 0) {
            return "";
        }
        // 如果姓名只有一个字，则不进行脱敏，直接返回该字
        if (name.length() == 1) {
            return name;
        }
        String regex = "(?<=.{1}).(?=.{1})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        if (matcher.find()) {
            String replacement = "*";
            return matcher.replaceAll(replacement);
        }
        return name;
    }

    /**
     * 对英文名进行数据脱敏处理
     *
     * @param name 英文名
     * @return 脱敏后的英文名
     */
    public static String maskEnglishName(String name) {
        if (name == null || name.length() == 0) {
            return "";
        }
        String[] nameParts = name.trim().split("\\s+");
        StringBuilder maskedNameBuilder = new StringBuilder();
        for (int i = 0; i < nameParts.length; i++) {
            if (i == nameParts.length - 1) {
                // 最后一个部分不进行脱敏
                maskedNameBuilder.append(nameParts[i]);
            } else {
                // 对其他部分进行脱敏
                maskedNameBuilder.append(nameParts[i].charAt(0));
                maskedNameBuilder.append(StringUtils.repeat("*", Math.max(0, nameParts[i].length() - 1)));
                maskedNameBuilder.append(" ");
            }
        }
        return maskedNameBuilder.toString();
    }

    /**
     * 对地址进行数据脱敏处理
     *
     * @param address        原始地址
     * @param sensitiveWords 需要脱敏的敏感词列表
     * @return 脱敏后的地址
     */
    public static String maskAddress(String address, List<String> sensitiveWords) {
        if (address == null || address.length() == 0) {
            return "";
        }
        if (sensitiveWords == null || sensitiveWords.size() == 0) {
            return address;
        }
        String regex = String.join("|", sensitiveWords);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(address);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String sensitiveWord = matcher.group();
            int len = sensitiveWord.length();
            String replacement = "";
            for (int i = 0; i < len; i++) {
                replacement += "*";
            }
            matcher.appendReplacement(sb, replacement);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        String idCard = "51072219880516571X";

        // 对身份证号进行脱敏，将出生日期部分替换为*
        String maskedIdCard = maskIdCard(idCard);
        System.out.println("身份证号脱敏后：" + maskedIdCard);

        String phone = "13812345678";

        // 对手机号进行脱敏，将手机号中间4位替换为*
        String maskedPhone = maskPhone(phone);
        System.out.println("手机号脱敏后：" + maskedPhone);

        String name = "张三";

        // 对中英文姓名进行脱敏，将姓名中间的字符替换为*
        String maskedName = maskChineseName(name);
        System.out.println("姓名脱敏后：" + maskedName);

        String englishName = "John Michael Smith";

        // 对英文名进行脱敏，将除最后一个单词外的其他单词的第二个字符到最后一个字符替换为*
        String maskedEnglishName = maskEnglishName(englishName);
        System.out.println("英文名脱敏后：" + maskedEnglishName);

        String address = "四川省成都市武侯区桂溪街道天府三街123号";
        List<String> sensitiveWords = Arrays.asList("成都市", "武侯区", "桂溪街道", "天府三街");

        // 对地址进行脱敏，将地址中的敏感词替换为*
        String maskedAddress = maskAddress(address, sensitiveWords);
        System.out.println("地址脱敏后：" + maskedAddress);
    }
}
