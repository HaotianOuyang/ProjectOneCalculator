import javax.swing.*;
import java.util.Stack;

public class ButtonAffect {

    public static void Clear(JTextField TextField) {
        TextField.setText("");
    }

    public static void AppendNumber(JTextField textField, JButton button) {
        String buttonLabel = button.getText();
        int caretPosition = textField.getCaretPosition();
        String currentText = textField.getText();
        String newText = currentText.substring(0, caretPosition) + buttonLabel + currentText.substring(caretPosition);
        textField.setText(newText);
        textField.setCaretPosition(caretPosition + buttonLabel.length());
    }

    public static double calculate(String expression) {
        return evaluateExpression(expression.replaceAll("\\s+", ""));
    }
    private static double evaluateExpression(String expression) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operations = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                int j = findClosingBracket(expression, i);
                numbers.push(evaluateExpression(expression.substring(i + 1, j)));
                i = j;
            } else if (Character.isDigit(ch)) {
                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                numbers.push((double) num);
                i--;
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%') {
                while (!operations.isEmpty() && precedence(operations.peek()) >= precedence(ch)) {
                    applyOperation(numbers, operations);
                }
                operations.push(ch);
            }
        }

        while (!operations.isEmpty()) {
            applyOperation(numbers, operations);
        }

        return numbers.pop();
    }

    private static void applyOperation(Stack<Double> numbers, Stack<Character> operations) {
        double b = numbers.pop();
        double a = numbers.pop();
        char op = operations.pop();
        double result = 0;
        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            case '%':
                result = a % b;
                break;
        }
        numbers.push(result);
    }

    private static int findClosingBracket(String expression, int openIndex) {
        int closeIndex = openIndex;
        int count = 0;
        while (closeIndex < expression.length()) {
            if (expression.charAt(closeIndex) == '(') {
                count++;
            } else if (expression.charAt(closeIndex) == ')') {
                count--;
                if (count == 0) {
                    return closeIndex;
                }
            }
            closeIndex++;
        }
        return -1;
    }

    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            default:
                return 0;
        }
    }


}
