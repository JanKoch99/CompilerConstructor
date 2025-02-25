package visitor;

public class EvalVisitor implements Visitor<Integer>{
    @Override
    public Integer visitNumber(Number number) {
        return number.value;
    }

    @Override
    public Integer visitMult(Mult mult) {
        return mult.left.accept(this) * mult.right.accept(this);
    }

    @Override
    public Integer visitSum(Sum sum) {
        return sum.left.accept(this) + sum.right.accept(this);
    }

    @Override
    public Integer visitMin(Min min) {
        return min.left.accept(this) - min.right.accept(this);
    }
}
