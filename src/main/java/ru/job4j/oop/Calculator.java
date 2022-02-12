package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return x - y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int a) {
        return x / a;
    }

    public int sumAllOperation(int a, int b, int c, int d) {
        return a + b + c + d;
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        int rslMinus = minus(10);
        System.out.println(rslMinus);
        int rslDivide = calculator.divide(5);
        System.out.println(rslDivide);
        int rslSumAllOperation = calculator.sumAllOperation(result, rsl, rslMinus, rslDivide);
        System.out.println(rslSumAllOperation);
    }
}
