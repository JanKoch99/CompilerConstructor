package visitor;

public class Mult implements Expr {
    Expr left;
    Expr right;

    public Mult(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }


    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitMult(this);
    }
}
