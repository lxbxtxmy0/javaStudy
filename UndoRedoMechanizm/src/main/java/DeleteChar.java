public class DeleteChar implements Action {
    private Character ch = null;
    final private StringBuilder buffer;

    public DeleteChar(StringBuilder buffer) {
        this.buffer = buffer;
    }

    @Override
    public boolean execute() {
        if (!buffer.isEmpty()) {
            ch = buffer.charAt(buffer.length() - 1);
            buffer.deleteCharAt(buffer.length() -1);
            return true;
        } else {
            ch = null;
            return false;
        }
    }

    @Override
    public void undo() {
        if (ch != null) {
            buffer.append(ch);
        }
    }

    @Override
    public String description() {
        return "Удаление символа";
    }
}
