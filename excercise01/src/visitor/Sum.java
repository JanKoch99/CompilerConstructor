package visitor;

public class Sum implements Expr {
    Expr left;
    Expr right;

    public Sum(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitSum(this);
    }
}
