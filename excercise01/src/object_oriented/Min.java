package object_oriented;

public class Min implements Expr {
    Expr left;
    Expr right;

    public Min(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int eval() {
        return left.eval() - right.eval();
    }

    @Override
    public String toString() {
        return "( " + left.toString() + " - " + right.toString() + " )";
    }

}
