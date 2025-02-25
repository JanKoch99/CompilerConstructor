package visitor;

public interface Visitor<T> {
    T visitNumber(Number number);
    T visitMult(Mult mult);
    T visitSum(Sum sum);
    T visitMin(Min min);
}
