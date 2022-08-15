package longest.common.prefix;

import java.util.Scanner;

public class LongestCommonPrefix {

    private static Scanner scanner = new Scanner(System.in);
    private String s1;
    private String s2;

    public String getCommonPrefix() {
        String result = "";
        System.out.println("Input first String");
        s1 = scanner.next();
        System.out.println("Input second String");
        s2 = scanner.next();

        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            if (s1.substring(0, i).equals(s2.substring(0, i))) {
                result = s1.substring(0, i);
            }
        }
        System.out.println("The common prefix is: " + result);
        return result;
    }

}
