package visitor;

public class PrintVisitor implements Visitor<String>{

    @Override
    public String visitNumber(Number number) {
        return String.valueOf(number.value);
    }

    @Override
    public String visitMult(Mult mult) {
        return "( " + mult.left.accept(this) + " * " + mult.right.accept(this) + " )";
    }

    @Override
    public String visitSum(Sum sum) {
        return "( " + sum.left.accept(this) + " + " + sum.right.accept(this) + " )";
    }

    @Override
    public String visitMin(Min min) {
        return "( " + min.left.accept(this) + " - " + min.right.accept(this) + " )";
    }
}
