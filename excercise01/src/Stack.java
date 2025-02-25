import java.util.ArrayList;

public class Stack implements IStack{
    ArrayList stack = new ArrayList();

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public void push(Object item) {
        stack.addLast(item);
    }

    @Override
    public Object top() {
        return stack.getLast();
    }

    @Override
    public void pop() {
        stack.removeLast();
    }
}
