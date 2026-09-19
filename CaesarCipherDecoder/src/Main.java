import java.util.Arrays;

public class Main {
    static String[] roles = {
            "Городничий", "Аммос Федорович",
            "Артемий Филиппович",
            "Лука Лукич"
    };
    static String[] textLines = {
            "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
            "Аммос Федорович: Как ревизор?",
            "Артемий Филиппович: Как ревизор?",
            "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
            "Аммос Федорович: Вот те на!",
            "Артемий Филиппович: Вот не было заботы, так подай!",
            "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
    };

    static private String printTextPerRole(String[] roles, String[] textLines) {
        String result = "";
        for (String role : roles) {
            result += role + "\n";
            int count = 1;
            for (String line : textLines) {
                if (line.contains(role)) {
                    result += count + ")" + line.substring(role.length() + 1) + "\n";
                    count += 1;
                }
            }
            result += "\n";
        }

        return result;
    }

    public static void main(String[] args) {
        String answer = printTextPerRole(roles, textLines);
        System.out.println(answer);
    }
}