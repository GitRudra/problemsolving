package org.home.algo.misc;

import java.util.Stack;

public class ExpressionConverter {

    class Expression{
        private String expression;
        private String operatorUsed;

        public Expression(String expression, String operatorUsed) {
            this.expression = expression;
            this.operatorUsed = operatorUsed;
        }

        public String getExpression() {
            return expression;
        }

        public void setExpression(String expression) {
            this.expression = expression;
        }

        public String getOperatorUsed() {
            return operatorUsed;
        }

        public void setOperatorUsed(String operatorUsed) {
            this.operatorUsed = operatorUsed;
        }
    }

    /**
     * What you need to do if you really want as few parentheses as possible,
     * is similar to what the algorithm you linked to says. However...
     *
     * You should store an operator for each composite operand in the Stack.
     * Namely, the last operator used in the operand.
     * You could use a second Stack for this. If the operand is not composite,
     * you could add null to the second Stack, since there is no operator.
     * Don't encapsulate the resulted String with parentheses.
     * That is done elsewhere in the algorithm (see below).
     * When you pop the top two values from each of the Stacks, you have 3 operators at hand:
     *
     * The current operator
     * The last used operator in the first operand (if the operator exists)
     * The last used operator in the second operand (if the operator exists)
     * Depending on these three operators, you should encapsulate the first
     * and/or second operand with parentheses, before combining them.
     *
     * You could use operator precedence to determine whether there should be parentheses.
     * The order goes like this: (none), {"*", "/"}, {"+", "-"}
     *
     * The first operand needs parentheses if and only if its operator has a lower precedence
     * than the current operator.
     * The second operand needs parentheses if its operator has a
     * lower precedence than the current operator, or if they have equal precedence
     * where the current operator is either "/" or "-".
     * The rest should be done the way your algorithm described.
     * @param postfixExpression
     */
    public String postfixToInfixConverter(String postfixExpression){
        Stack<Expression> exprStack = new Stack<>();
        for(int i=0;i<postfixExpression.length();i++){
            String token = String.valueOf(postfixExpression.charAt(i));
            if("+".equals(token)
                    || "-".equals(token)){
                String right = exprStack.pop().getExpression();
                String left = exprStack.pop().getExpression();
                exprStack.push(new Expression(left+token+right,token));
            }else if("*".equals(token)
                    || "/".equals(token)){
                String right = correctExpression(exprStack.pop());
                String left = correctExpression(exprStack.pop());
                exprStack.push(new Expression(left+token+right,token));
            }else{
                exprStack.push(new Expression(token,""));
            }
        }
        if(exprStack.size()==1){
            return exprStack.pop().getExpression();
        }else{
            return "";
        }
    }

    private String correctExpression(Expression expr){
        if("+".equals(expr.getOperatorUsed()) || "-".equals(expr.getOperatorUsed())){
            return "("+expr.getExpression()+")";
        }
        return expr.getExpression();
    }

    public String prefixToInfixConverter(String prefixExpression){

        Stack<Expression> exprStack = new Stack<>();
        for(int i=prefixExpression.length()-1;i>=0;i--){
            String token = String.valueOf(prefixExpression.charAt(i));
            if("+".equals(token)
                    || "-".equals(token)){
                String left = exprStack.pop().getExpression();
                String right = exprStack.pop().getExpression();
                exprStack.push(new Expression(left+token+right,token));
            }else if("*".equals(token)
                    || "/".equals(token)){
                String left = correctExpression(exprStack.pop());
                String right = correctExpression(exprStack.pop());
                exprStack.push(new Expression(left+token+right,token));
            }else{
                exprStack.push(new Expression(token,""));
            }
        }
        if(exprStack.size()==1){
            return exprStack.pop().getExpression();
        }else{
            return "";
        }
    }

}
