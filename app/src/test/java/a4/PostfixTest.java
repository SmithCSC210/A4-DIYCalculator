package a4;

import static org.junit.Assert.*;
import org.junit.Test;

    
public class PostfixTest {
    @Test
    public void testPostfixEvaluation() {
        String[] expressions = {
            "3.14159", "7", "6 1 +", "0 7 +", "9 2 -", "3.5 2 *", "21 3 /", "2 3 2 + +",
            "2 2 2 1 + + +", "1 1 1 1 1 1 1 + + + + + +", "2 2 + 2 1 + +", "15 6 - 2 -",
            "15 10 2 - -", "1.75 2 2 * *", "1.75 2 * 2 *", "70 5 / 2 /", "70 100 10 / /",
            "28 1 4 / *", "3 1 + 10 3 - * 4 /", "7 1 * 1 / 0 + 0 -"
        };
        
        double[] expectedResults = {
            3.14159, 7, 7, 7, 7, 7, 7, 7,
            7, 7, 7, 7,
            7, 7, 7, 7, 7,
            7, 7, 7
        };
        
        for (int i = 0; i < expressions.length; i++) {
            assertEquals("Failed for expression: " + expressions[i], expectedResults[i], Postfix.postfix(Tokenizer.readTokens(expressions[i])), 0.00001);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPostfixThrowsException() {
        String[] expressions = {"+", "7 *", "7 7 7"};
        for (int i = 0; i < expressions.length; i++) {
            Postfix.postfix(Tokenizer.readTokens(expressions[i]));
        }
    }
}