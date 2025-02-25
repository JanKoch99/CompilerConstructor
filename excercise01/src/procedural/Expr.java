package procedural;

public class Expr {

    public static String toString(Expr node) {
        if (node instanceof Number) {
            return String.valueOf(((Number) node).value);
        }
        if (node instanceof Sum) {
            Sum sum = (Sum) node;
            String evalLeft = toString(sum.left);
            String evalRight = toString(sum.right);
            return "( " + evalLeft + " + " + evalRight + " )";
        }
        if (node instanceof Mult) {
            Mult mult = (Mult) node;
            String evalLeft = toString(mult.left);
            String evalRight = toString(mult.right);
            return "( " + evalLeft + " * " + evalRight + " )";
        }
        if (node instanceof Min) {
            Min min = (Min) node;
            String evalLeft = toString(min.left);
            String evalRight = toString(min.right);
            return "( " + evalLeft + " - " + evalRight + " )";
        }
        throw new IllegalArgumentException("No valid node found");
    }

    public static int eval(Expr node) {
        if (node instanceof Number) {
            return ((Number) node).value;
        }
        if (node instanceof Sum) {
            Sum sum = (Sum) node;
            int evalLeft = eval(sum.left);
            int evalRight = eval(sum.right);
            return evalLeft + evalRight;
        }
        if (node instanceof Mult) {
            Mult mult = (Mult) node;
            int evalLeft = eval(mult.left);
            int evalRight = eval(mult.right);
            return evalLeft * evalRight;
        }
        if (node instanceof Min) {
            Min min = (Min) node;
            int evalLeft = eval(min.left);
            int evalRight = eval(min.right);
            return evalLeft - evalRight;
        }
        throw new IllegalArgumentException("No valid node found");
    }
}
