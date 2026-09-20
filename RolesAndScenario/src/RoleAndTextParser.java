public class RoleAndTextParser {
    public RoleAndTextParser() {}

    public String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < roles.length; i++) {
            result.append(roles[i] + ":\n");
            for (int j = 0; j < textLines.length; j++) {
                if (textLines[j].startsWith(roles[i] + ":")) {
                    result.append(j + 1 + ") " + textLines[j].substring(roles[i].length() + 2) + "\n");
                }
            }
            if (i < roles.length - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }
}
