package visitor;

public class Number implements Expr {
    int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitNumber(this);
    }
}
