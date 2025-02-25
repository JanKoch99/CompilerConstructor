package visitor;

public class Min implements Expr {
    Expr left;
    Expr right;

    public Min(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitMin(this);
    }
}
