package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidParenthesesTest {

    @Test
    void validInputTest(){
        String validInput = "()[]{}";
        assertTrue(ValidParentheses.isValidParentheses(validInput));
    }

    @Test
    void validInputNestedTest(){
        String validInput = "{[()]}";
        assertTrue(ValidParentheses.isValidParentheses(validInput));
    }

    @Test
    void emptyInputTest(){
        String emptyInput = "";
        assertTrue(ValidParentheses.isValidParentheses(emptyInput));
    }

    @Test
    void nullInputTest(){
        String nullInput = null;
        assertTrue(ValidParentheses.isValidParentheses(nullInput));
    }

    @Test
    void oneInputTest(){
        String oneInput = "[";
        assertFalse(ValidParentheses.isValidParentheses(oneInput));
    }

    @Test
    void invalidInputTest(){
        String invalidInput = "(]";
        assertFalse(ValidParentheses.isValidParentheses(invalidInput));
    }

    @Test
    void invalidInput2Test(){
        String invalidInput = "([)]";
        assertFalse(ValidParentheses.isValidParentheses(invalidInput));
    }

    @Test
    void onlyOpiningTest(){
        String invalidInput = "(((((";
        assertFalse(ValidParentheses.isValidParentheses(invalidInput));
    }

    @Test
    void onlyClosingTest(){
        String invalidInput = ")))))";
        assertFalse(ValidParentheses.isValidParentheses(invalidInput));
    }
}
