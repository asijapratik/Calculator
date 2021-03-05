package Calculator;

import javax.lang.model.util.ElementScanner6;

public class Model {

    public double calculate(double number1, double number2, String operator) {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 == 0)
                    return 0;

                return number1 / number2;
            case "x^y":
                return Math.pow(number1,number2);
            case "mod":
                return number1%number2;
        }
        System.out.println("Unknown operator - " + operator);
        return 0;
    }
    public double calculate1(double number1,String operator){
        switch(operator){
            case "1/x":
                if(number1==0)
                    return 0;
                    
                return 1/number1;
            case "sqrt":
                return Math.sqrt(number1);
            case "log":
                return Math.log10(number1);
            case "ln":
                return Math.log(number1);
            case "+/-":
                return 0-number1;
        }
        return 0;
    }
}
