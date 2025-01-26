package platform.kata.academy.javacore.chapter_1;

/*




...


roles:
textLines:




*/

import java.util.regex.Pattern;

public class Exercise_1_6_11 {
    public static void main(String[] args) {
        test();
    }

    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder ret = new StringBuilder();
        for (String role : roles) {
            ret.append(role).append(":\n");
            for (int j = 0; j < textLines.length; j++) {
                if (textLines[j].startsWith(role + ": ")) {
                    ret.append(j + 1).append(")").append(textLines[j].substring(role.length() + 1)).append("\n");
                }
            }
            ret.append("\n");
        }
        return ret.toString();
    }

    public static void test() {
        String[] roles = new String[]{
                "Городничий","Аммос Федорович","Артемий Филиппович","Лука Лукич"};
        String[] textLines = new String[]{
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор."
                ,"Аммос Федорович: Как ревизор?"
                ,"Артемий Филиппович: Как ревизор?"
                ,"Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем."
                ,"Аммос Федорович: Вот те на!","Артемий Филиппович: Вот не было заботы, так подай!"
                ,"Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        System.out.println(printTextPerRole(roles, textLines));
    }
}
