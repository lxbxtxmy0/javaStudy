import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class UndoManager {
    private static final int STACK_LIMIT = 50;

    private final Deque<Action> undoStack = new ArrayDeque<>();
    private final Deque<Action> redoStack = new ArrayDeque<>();

    public UndoManager() {}

    public void perform(Action action) {
        if (!action.execute()) {
            return;
        }

        while (undoStack.size() >= STACK_LIMIT) {
            undoStack.removeLast();
        }

        undoStack.addFirst(action);

        redoStack.clear();
    }

    public boolean canUndo() {
        return !undoStack.isEmpty();
    }

    public boolean canRedo() {
        return !redoStack.isEmpty();
    }

    public void undo() {
        if (canUndo()) {
            undoStack.peekFirst().undo();
            redoStack.addFirst(undoStack.removeFirst());
        }
    }

    public void redo() {
        if (canRedo()) {
            if (redoStack.peekFirst().execute()) {
                undoStack.addFirst(redoStack.removeFirst());
            } else {
                redoStack.clear();
            }
        }
    }
}
