package edu.hw2;

import edu.hw2.Task1.Expr.Exponent;
import edu.hw2.Task1.Expr.Negate;
import edu.hw2.Task1.Expr.Multiplication;
import edu.hw2.Task1.Expr.Constant;
import edu.hw2.Task1.Expr.Addition;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    void TestStandard() {
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));

        assertThat(res.evaluate()).isEqualTo(37);
    }

    @Test
    void Negate() {
        var negOne = new Negate(new Constant(51));
        assertThat(negOne.evaluate()).isEqualTo(-51);
    }

    @Test
    void Addition() {
        var neg = new Negate(new Constant(51));
        var constant = new Constant(51);
        var add = new Addition(neg, constant);
        assertThat(add.evaluate()).isEqualTo(0);
    }

    @Test
    void Multiplication() {
        var left = new Constant(10);
        var right = new Constant(513);
        var multiplication = new Multiplication(left, right);
        assertThat(multiplication.evaluate()).isEqualTo(5130);
    }

    @Test
    void InnerExpressionsRandom() {
        var random = new Random();
        int multLeft = random.nextInt(1, 10);
        int multRight = random.nextInt(3, 15);
        int addRight = random.nextInt(4, 20);
        int power = random.nextInt(1, 5);
        var result = new Exponent(new Addition(
                new Multiplication(new Constant(multLeft), new Constant(multRight)), new Constant(addRight)),
                power);
        assertThat(result.evaluate()).isEqualTo(Math.pow(multLeft * multRight + addRight, power));
    }
}
