package a4;

import java.io.StringReader;
import java.util.ArrayDeque;

/** 
 * Class to interpret and compute the result of arithmetic expressions 
 * in POSTFIX format - 
 */
public class Postfix {

    public static double postfix(ArrayDeque<Object> tokens){
        ArrayDeque<Double> stack = new ArrayDeque<>();
        for (Object token : tokens) {
            if(token instanceof Double){
                stack.push((double)token);
                System.out.println(stack);
            }
            else{
                Character operator = (Character)token;
                try{
                    Double number2 = stack.pop();
                    Double number1 = stack.pop();
                } catch(NoSuchElementException e){

                }
                
                System.out.println("removed top 2: " + stack);
                switch (operator) {
                    case '+': stack.push(number1 + number2); break;
                    case '-': stack.push(number1 - number2); break;
                    case '*': stack.push(number1 * number2); break;
                    case '/': stack.push(number1 / number2); break;
                    default: throw new IllegalArgumentException("Invalid operator: " + operator);
                }
            }
        }
        System.out.println("final stack: " + stack);
        return stack.pop();
    }
}