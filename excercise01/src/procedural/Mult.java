package procedural;

public class Mult extends Expr {
    Expr left;
    Expr right;

    public Mult(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }
}
