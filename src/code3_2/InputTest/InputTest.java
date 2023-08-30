package code3_2.InputTest;

import java.util.*;

/**
 * 本程序用于展示从控制台的读取
 */

public class InputTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("What's your name?");
        String name = in.nextLine();

        System.out.println("How old are you?");
        int age = in.nextInt();

        System.out.println("Hello, " + name + ". Next year, you'll be " + (++age));

        // 试用 StringBuilder
        System.out.println("Please input word one by one, enter 'x' to exit the program:");
        StringBuilder builder = new StringBuilder();
        while(true) {
            String word = in.next();
            if(word.equals("x"))
                break;
            builder.append(word);
            builder.append(" ");
        }
        String buildStr = builder.toString();
        System.out.println(buildStr);;
    }
}
