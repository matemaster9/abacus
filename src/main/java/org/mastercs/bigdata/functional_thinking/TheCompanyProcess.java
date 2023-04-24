package org.mastercs.bigdata.functional_thinking;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author matemaster
 */
public class TheCompanyProcess {

    public static String cleanNames(List<String> nameList) {
        StringBuilder builder = new StringBuilder();
        for (String s : nameList) {
            if (s != null && s.length() > 1) {
                builder.append(capitalizeString(s)).append(",");
            }
        }
        return builder.substring(0, builder.length() - 1).toString();
    }


    public static String cleanNamesByFunctionalProgramming(List<String> nameList) {
        if (nameList == null || nameList.size() == 0) {
            return null;
        }
        return nameList.stream()
                .filter(str -> str != null && str.isEmpty())
                .map(TheCompanyProcess::capitalizeString)
                .collect(Collectors.joining(","));
    }

    public static String capitalizeString(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
