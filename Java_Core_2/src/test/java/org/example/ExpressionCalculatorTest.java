package org.example;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExpressionCalculatorTest {
    @Test
    public void testSimpleExpression() {
        String expression = "2 + 3 * 4";
        double expected = 14.0;
        double result = ExpressionCalculator.evaluate(expression);
        assertEquals(expected, result, 0.001);
    }

    @Test
    public void testComplexExpression() {
        String expression = "(3 + 4) * (5 - 2)";
        double expected = 21.0;
        double result = ExpressionCalculator.evaluate(expression);
        assertEquals(expected, result, 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        String expression = "5 / 0";
        ExpressionCalculator.evaluate(expression);
    }
    @Test
    public void testPi() {
        String expression = "pi";
        double expected = Math.PI;
        double result = ExpressionCalculator.evaluate(expression);
        assertEquals(expected, result, 0.001);
    }

    @Test
    public void testE() {
        String expression = "e";
        double expected = Math.E;
        double result = ExpressionCalculator.evaluate(expression);
        assertEquals(expected, result, 0.001);
    }

    @Test
    public void testSqrt() {
        String expression = "sqrt(9)";
        double expected = 3.0;
        double result = ExpressionCalculator.evaluate(expression);
        assertEquals(expected, result, 0.001);
    }
}
