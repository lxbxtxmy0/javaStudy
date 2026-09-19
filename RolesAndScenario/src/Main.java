

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
        for (int i = 0; i < roles.length; i++) {
            result += roles[i] + ":\n";
            for (int j = 0; j < textLines.length; j++) {
                if (textLines[j].startsWith(roles[i] + ":")) {
                    result += j + 1 + ")" + textLines[j].substring(roles[i].length() + 1) + "\n";
                }
            }
            if (i < roles.length - 1) {
                result += "\n";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String answer = printTextPerRole(roles, textLines);
        System.out.println(answer);
    }
}