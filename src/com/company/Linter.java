package com.company;


/**
 * Beginnings of a JavaScript linter that checks for opening and closing braces.
 * Based on Ruby version from A Common Sense Guide to Data Structures and Algorithms by Jay Wengrow (138-143)
 * Pages 138 - 143
 *
 *
 * Syntax error 1: Opening doesn't have a closing brace
 * Syntax error 2: Closing brace didn't have an opening brace
 * Syntax error 3: Closing brace is not the same type as the opening brace that preceded it.
 *
 * Lint algorithm for braces
 * Ignore any character that isn't a type of brace
 * If an opening brace is found, push it onto the stack
 * If we find a closing brace:
 *    Pop the top element of the stack and inspect it
 *        If it doesn't match the current closing brace, Syntax error 3
 *         If nothing could be popped from the stack (empty), there was no opening brace, Syntax error 2
 *         If it matches, we've closed that opening brace and can continue
 * If we traverse the entire line of code and the stack isn't empty, then there's an opening brace w/o a closing, Syntax error 1
 */
public class Linter {

    private enum Errors {
        NO_OPENING_BRACE("No opening brace to match closing brace: "),
        NO_CLOSING_BRACE("No closing brace was found to match: "),
        NOT_A_MATCH("Closing brace does not match opening brace: ");



        private final String errorText;

        Errors(String errorText) {
            this.errorText = errorText;
        }
    }

    // Create stack to store braces
    private Stack<Character> stack = new Stack<Character>();

    public void linter(String string) {

        char[] characters = string.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            char currentCharacter = characters[i];
            if (isOpeningBrace(currentCharacter)) {
                stack.push(currentCharacter);
            } else if (isClosingBrace(currentCharacter)) {
                Character poppedBrace = stack.pop();
                if (poppedBrace == null) {
                    System.out.println(Errors.NO_OPENING_BRACE.errorText + currentCharacter);
                } else if (isAMatch(poppedBrace, currentCharacter)) {
                    System.out.println("Match for braces found: " + poppedBrace + " " + currentCharacter);
                } else if (!isAMatch(poppedBrace, currentCharacter)) {
                    System.out.println((Errors.NOT_A_MATCH.errorText + poppedBrace + " " + currentCharacter));
                }
            }
        }

        if (stack.peek() != null) {
            do {
                System.out.println(Errors.NO_CLOSING_BRACE.errorText + stack.pop());
            } while (stack.peek() != null);
        } else {
            System.out.println("No opening/closing brace errors found.");
        }

    }

    private boolean isOpeningBrace(Character brace) {
        if ((brace == '(') || (brace == '{') || (brace == '[')) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isClosingBrace(Character brace) {
        if ((brace == ')') || (brace == '}') || brace == ']') {
            return true;
        } else {
            return false;
        }
    }

    private boolean isAMatch(Character openingBrace, Character closingBrace) {
        if ((openingBrace == '(') && (closingBrace == ')')) {
            return true;
        } else if ((openingBrace == '{') && (closingBrace == '}')) {
            return true;
        } else if ((openingBrace == '[') && (closingBrace == ']')) {
            return true;
        } else {
            return false;
        }
    }

}