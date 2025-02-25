package procedural;

public class Sum extends Expr {
    Expr left;
    Expr right;

    public Sum(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }
}
