package edu.hw2;

import edu.hw2.TaskOne.Expr;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.assertj.core.api.Assertions.assertThat;

public class TaskOneTest {
    @Test
    void TestStandard() {
        var two = new Expr.Constant(2);
        var four = new Expr.Constant(4);
        var negOne = new Expr.Negate(new Expr.Constant(1));
        var sumTwoFour = new Expr.Addition(two, four);
        var mult = new Expr.Multiplication(sumTwoFour, negOne);
        var exp = new Expr.Exponent(mult, 2);
        var res = new Expr.Addition(exp, new Expr.Constant(1));

        assertThat(res.evaluate()).isEqualTo(37);
    }

    @Test
    void Negate() {
        var negOne = new Expr.Negate(new Expr.Constant(51));
        assertThat(negOne.evaluate()).isEqualTo(-51);
    }

    @Test
    void Addition() {
        var neg = new Expr.Negate(new Expr.Constant(51));
        var constant = new Expr.Constant(51);
        var add = new Expr.Addition(neg, constant);
        assertThat(add.evaluate()).isEqualTo(0);
    }

    @Test
    void Multiplication() {
        var left = new Expr.Constant(10);
        var right = new Expr.Constant(513);
        var multiplication = new Expr.Multiplication(left, right);
        assertThat(multiplication.evaluate()).isEqualTo(5130);
    }

    @Test
    void InnerExpressionsRandom() {
        var random = new Random();
        int multLeft = random.nextInt(1, 10);
        int multRight = random.nextInt(3, 15);
        int addRight = random.nextInt(4, 20);
        int power = random.nextInt(1, 5);
        var result = new Expr.Exponent(new Expr.Addition(
                new Expr.Multiplication(new Expr.Constant(multLeft), new Expr.Constant(multRight)), new Expr.Constant(addRight)),
                power);
        assertThat(result.evaluate()).isEqualTo(Math.pow(multLeft * multRight + addRight, power));
    }
}
