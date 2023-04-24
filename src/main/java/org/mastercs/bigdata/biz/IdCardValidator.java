package org.mastercs.bigdata.biz;

import com.google.common.collect.ImmutableSet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class IdCardValidator {

    private IdCardValidator() {
    }

    // 正则表达式
    private static final String REGEX_ID_CARD = "^([1-9]\\d{5})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9Xx])$";

    // 省份代码
    private static final Set<String> PROVINCE_CODE_SET = ImmutableSet.of(
            "11", "12", "13", "14", "15", "21", "22", "23", "31", "32", "33",
            "34", "35", "36", "37", "41", "42", "43", "44", "45", "46", "50", "51",
            "52", "53", "54", "61", "62", "63", "64", "65", "71", "81", "82"
    );

    // 每位身份证号码的权值
    private static final int[] POWER_LIST = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    // 校验码列表
    private static final char[] CHECK_CODE_LIST = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

    /**
     * 验证身份证号码是否合法
     *
     * @param idCardNumber 身份证号码
     * @return true表示合法，false表示不合法
     */
    public static boolean validate(String idCardNumber) {
        if (idCardNumber == null || idCardNumber.isEmpty()) {
            return false;
        }

        // 格式验证
        Pattern pattern = Pattern.compile(REGEX_ID_CARD);
        Matcher matcher = pattern.matcher(idCardNumber);
        if (!matcher.matches()) {
            return false;
        }

        // 省份验证
        String provinceCode = idCardNumber.substring(0, 2);
        if (!PROVINCE_CODE_SET.contains(provinceCode)) {
            return false;
        }

        // 日期验证
        String birthday = idCardNumber.substring(6, 14);
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            dateFormat.setLenient(false);
            dateFormat.parse(birthday);
        } catch (ParseException e) {
            return false;
        }

        // 校验码验证
        char[] idArray = idCardNumber.toCharArray();
        int sum = 0;
        for (int i = 0; i < POWER_LIST.length; i++) {
            int value = idArray[i] - '0';
            sum += value * POWER_LIST[i];
        }
        return idArray[17] == CHECK_CODE_LIST[sum % 11];
    }

    public static void main(String[] args) {
        System.out.println(validate("341125200008257798"));
        System.out.println(validate("320102198510162039"));
    }
}
