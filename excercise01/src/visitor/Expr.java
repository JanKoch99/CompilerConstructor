package visitor;

public interface Expr {
    <T> T accept(Visitor<T> visitor);
}
