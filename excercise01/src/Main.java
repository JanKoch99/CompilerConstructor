import procedural.*;
import procedural.Number;
import visitor.EvalVisitor;
import visitor.PrintVisitor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Task 1
        //balancer();

        //Task 2
        // a)
        Number five = new Number(5);
        Number two = new Number(2);
        Number ten = new Number(10);
        Mult mult = new Mult(two, ten);
        Sum sum = new Sum(five, mult);
        int a = Expr.eval(sum);
        assert a == 25;
        System.out.println("a) :" + a);
        // e) 1.
        /*
        Just add the class Min and change the eval and add toString to the Expr
         */
        Min min = new Min(sum, two);
        int d = Expr.eval(min);
        assert d == 23;
        System.out.println("e) 1. :" + d);
        System.out.println(Expr.toString(min));

        // b)
        object_oriented.Number fiveO = new object_oriented.Number(5);
        object_oriented.Number twoO = new object_oriented.Number(2);
        object_oriented.Number tenO = new object_oriented.Number(10);
        object_oriented.Mult mult0 = new object_oriented.Mult(twoO, tenO);
        object_oriented.Sum sum0 = new object_oriented.Sum(fiveO, mult0);
        int b = sum0.eval();
        assert b == 25;
        System.out.println("b) :" + b);

        // e) 2.
        /*
        Add a new Min.class and edit every class for the printing
         */
        object_oriented.Min min0 = new object_oriented.Min(sum0, twoO);
        int e = min0.eval();
        assert e == 23;
        System.out.println("e) 2. :" + e);
        System.out.println(min0);


        // c)
        visitor.Number fiveN = new visitor.Number(5);
        visitor.Number twoN = new visitor.Number(2);
        visitor.Number tenN = new visitor.Number(10);
        visitor.Mult multN = new visitor.Mult(twoN, tenN);
        visitor.Sum sumN = new visitor.Sum(fiveN, multN);
        EvalVisitor visitor = new EvalVisitor();
        int c = sumN.accept(visitor);
        assert c == 25;
        System.out.println("c) :" + c);

        // e) 3.
        /*
        Just add a new visitor
         */
        visitor.Min minN = new visitor.Min(sumN, twoN);
        PrintVisitor printVisitor = new PrintVisitor();
        int f = minN.accept(visitor);
        assert f == 23;
        System.out.println("f) 2. :" + f);
        System.out.println(printVisitor.visitMin(minN));


    }

    private static void balancer() {
        System.out.println("Please enter your input string");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] chars = input.toCharArray();
        System.out.println("Your input is: " + input);
        Stack fullStack = new Stack() ;
        for (int i = 0 ; i < chars.length ; i++) {
            char c = chars[i];
            if (c == '(' || c == '{' || c == '[') {
                fullStack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (fullStack.isEmpty()) {
                    System.out.println("Your input is not balanced");
                    return;
                } else if (c == ')' && fullStack.top().toString().charAt(0) == '('){
                    fullStack.pop();
                } else if (c == '}' && fullStack.top().toString().charAt(0) == '{'){
                    fullStack.pop();
                } else if (c == ']' && fullStack.top().toString().charAt(0) == '['){
                    fullStack.pop();
                } else {
                    System.out.println("Your input is not balanced");
                    return;
                }
            }
        }
        if (!fullStack.isEmpty()) {
            System.out.println("Your input is not balanced");
        } else {
            System.out.println("Yout input is balanced");
        }
    }
}