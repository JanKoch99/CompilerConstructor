package procedural;

public class Min extends Expr {
    Expr left;
    Expr right;

    public Min(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }
}
