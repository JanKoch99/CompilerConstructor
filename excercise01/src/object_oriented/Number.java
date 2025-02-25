package object_oriented;

public class Number implements Expr {
    int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int eval() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
