package edu.hw2.Task1;

public sealed interface Expr {
    double evaluate();

    record Constant(double value) implements Expr {
        @Override
        public double evaluate() {
            return value;
        }
    }

    record Negate(Expr value) implements Expr {
        @Override
        public double evaluate() {
            return -this.value.evaluate();
        }
    }

    record Exponent(Expr value, int power) implements Expr {
        @Override
        public double evaluate() {
            return Math.pow(value.evaluate(), power);
        }
    }

    record Addition(Expr left, Expr right) implements Expr {
        @Override
        public double evaluate() {
            return this.left.evaluate() + this.right.evaluate();
        }
    }

    record Multiplication(Expr left, Expr right) implements Expr {
        @Override
        public double evaluate() {
            return this.left.evaluate() * this.right.evaluate();
        }
    }
}
