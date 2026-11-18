public interface Action {
    String description();
    boolean execute();
    void undo();
}
