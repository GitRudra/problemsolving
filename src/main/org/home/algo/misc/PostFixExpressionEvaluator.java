package org.home.algo.misc;

import java.util.Stack;

/**
 * The Postfix notation is used to represent algebraic expressions.
 * The expressions written in postfix form are evaluated faster compared
 * to infix notation as parenthesis are not required in postfix.
 * We have discussed infix to postfix conversion.
 * In this post, evaluation of postfix expressions is discussed.
 *
 * Following is algorithm for evaluation postfix expressions.
 * 1) Create a stack to store operands (or values).
 * 2) Scan the given expression and do following for every scanned element.
 * …..a) If the element is a number, push it into the stack
 * …..b) If the element is a operator, pop operands for the operator from stack.
 *       Evaluate the operator and push the result back to the stack
 * 3) When the expression is ended, the number in the stack is the final answer
 *
 * There are following limitations of above implementation.
 * 1) It supports only 4 binary operators ‘+’, ‘*’, ‘-‘ and ‘/’.
 *    It can be extended for more operators by adding more switch cases.
 * 2) The allowed operands are only single digit operands.
 *    The program can be extended for multiple digits by adding a
 *    separator like space between all elements (operators and operands) of given expression.
 */
public class PostFixExpressionEvaluator {

    public static String evaluateExpression(String expression){
        Stack<String> exprStack = new Stack<>();

        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i) == '+' ||
                    expression.charAt(i) == '-' ||
                    expression.charAt(i) == '*' ||
                    expression.charAt(i) == '/' ){
                int operand1 = Integer.parseInt(exprStack.pop());
                int operand2 = Integer.parseInt(exprStack.pop());
                int res=0;
                switch(expression.charAt(i)){
                    case '+':
                        res = operand2+operand1;
                        break;
                    case '-':
                        res = operand2-operand1;
                        break;
                    case '*':
                        res = operand2*operand1;
                        break;
                    case '/':
                        res = operand2/operand1;
                        break;
                }

                exprStack.push(String.valueOf(res));

            }else{
                exprStack.push(String.valueOf(expression.charAt(i)));
            }
        }
        return exprStack.pop();
    }
}
