package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;

/**
 * Класс для вычисления математических выражений с поддержкой переменных и функций.
 */
public class ExpressionCalculator {
    // Хранилище переменных
    private static final Map<String, Double> variables = new HashMap<>();
    // Хранилище функций
    private static final Map<String, Function<Double, Double>> functions = new HashMap<>();

    // Статический блок инициализации переменных и функций по умолчанию
    static {
        // Добавляем значения по умолчанию: pi и e
        variables.put("pi", Math.PI);
        variables.put("e", Math.E);
        // Добавляем функцию sqrt
        functions.put("sqrt", Math::sqrt);
    }

    /**
     * Установить значение переменной.
     *
     * @param name  имя переменной
     * @param value значение переменной
     */
    public static void setVariable(String name, double value) {
        variables.put(name, value);
    }

    /**
     * Добавить пользовательскую функцию.
     *
     * @param name     имя функции
     * @param function функция
     */
    public static void addFunction(String name, Function<Double, Double> function) {
        functions.put(name, function);
    }

    /**
     * Вычислить математическое выражение.
     *
     * @param expression выражение, которое нужно вычислить
     * @return результат вычисления
     */
    public static double evaluate(String expression) {
        char[] tokens = expression.toCharArray();

        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ')
                continue;

            if (Character.isLetter(tokens[i])) { // Проверяем, является ли токен буквой (переменной или функцией)
                StringBuilder sb = new StringBuilder();
                while (i < tokens.length && Character.isLetterOrDigit(tokens[i])) {
                    sb.append(tokens[i++]);
                }
                i--;
                String token = sb.toString();
                if (variables.containsKey(token)) {
                    values.push(variables.get(token));
                } else if (functions.containsKey(token)) {
                    int openingBracketIndex = expression.indexOf('(', i);
                    if (openingBracketIndex == -1) {
                        throw new IllegalArgumentException("Missing opening bracket");
                    }

                    int closingBracketIndex = expression.indexOf(')', openingBracketIndex);
                    if (closingBracketIndex == -1) {
                        throw new IllegalArgumentException("Missing closing bracket");
                    }

                    String contentInsideBrackets = expression.substring(openingBracketIndex + 1, closingBracketIndex);

                    double arg = Double.parseDouble(contentInsideBrackets);
                    values.push(functions.get(token).apply(arg));

                    i = closingBracketIndex + 1;
                } else {
                    throw new IllegalArgumentException("Undefined variable or function: " + token);
                }
            } else if (Character.isDigit(tokens[i])) {
                StringBuilder sb = new StringBuilder();
                while (i < tokens.length && (Character.isDigit(tokens[i]) || tokens[i] == '.')) {
                    sb.append(tokens[i++]);
                }
                i--;
                values.push(Double.parseDouble(sb.toString()));
            } else if (tokens[i] == '(') {
                operators.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (operators.peek() != '(')
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                operators.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                while (!operators.empty() && hasPrecedence(tokens[i], operators.peek()))
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                operators.push(tokens[i]);
            }
        }

        while (!operators.empty())
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));

        return values.pop();
    }

    /**
     * Проверить, имеет ли оператор op1 более высокий приоритет, чем оператор op2.
     *
     * @param op1 первый оператор
     * @param op2 второй оператор
     * @return true, если оператор op1 имеет более высокий приоритет, чем оператор op2, в противном случае - false
     */
    private static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        return (op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-');
    }

    /**
     * Применить оператор к двум операндам.
     *
     * @param operator оператор (+, -, *, /)
     * @param b        второй операнд
     * @param a        первый операнд
     * @return результат вычисления оператора над операндами
     * @throws ArithmeticException если операция деления на ноль
     */
    private static double applyOperator(char operator, double b, double a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new ArithmeticException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
}
