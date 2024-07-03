package utils;

import ui.*;

import java.util.Stack;

public class Calculations {
    private float result;
    private Stack <Character> parrStack;
    private Stack <Float> valStack;
    
    public Calculations(){
        this.result=0;
        parrStack=new Stack<>();
        valStack=new Stack<>();
    }

    public float calculate(String expression)throws CalculationException{
        checkExpression(expression);
        expression=toPostfix(expression);
        evaluate(expression);
        return result;
    }

    private void checkExpression(String exp) throws CalculationException{
        for(int i=0;i<exp.length();i++){
            if((i==exp.length()-1 && isOperator(exp.charAt(i))) || (i<exp.length()-1 && isOperator(exp.charAt(i)) && isOperator(exp.charAt(i+1)))){
                throw new CalculationException();
            }
            if(exp.charAt(i)=='(')
                parrStack.push(exp.charAt(i));
            else if(exp.charAt(i)==')'){
                if(parrStack.isEmpty() || (char)parrStack.peek() != '(')
                    throw new CalculationException();
                else
                    parrStack.pop();
            }
        }
        if(!parrStack.isEmpty())
            throw new CalculationException();
    }
    
    private boolean isOperator(char c) {
    	return c=='+' || c=='-' || c=='x' || c=='/' || c=='^';
    }
    private String toPostfix(String exp){
        StringBuffer postfix=new StringBuffer();

        int size=exp.length();
        for(int i=0;i<size;i++){
            if(exp.charAt(i)>='0' && exp.charAt(i)<='9'){
                while(i<size && ((exp.charAt(i)>='0' && exp.charAt(i)<='9')||(exp.charAt(i)=='.'))){
                    postfix.append(exp.charAt(i));
                    i++;
                }
                postfix.append(",");
                i--;
            }
            else if(exp.charAt(i)=='(')
                parrStack.push(exp.charAt(i));
            else if(exp.charAt(i)==')'){
                while(!parrStack.isEmpty() && (char)parrStack.peek() != '('){
                    postfix.append(parrStack.pop());
                }
                parrStack.pop();
            }
            else{
                while(!parrStack.isEmpty() && (precedence(exp.charAt(i)) < precedence((char)parrStack.peek()) ||
                precedence(exp.charAt(i)) == precedence((char)parrStack.peek()) && exp.charAt(i)!='^')){
                    postfix.append(parrStack.pop());
                }
                parrStack.push(exp.charAt(i));
            }
        }
        while(!parrStack.isEmpty())
            postfix.append(parrStack.pop());

        return postfix.toString();
    }

    private int precedence(char c){
        if(c=='^')
            return 3;
        else if(c=='x' || c=='/')
            return 2;
        else if(c=='+' || c=='-')
            return 1;
        return 0;
    }

    private void evaluate(String exp) throws CalculationException{
        for(int i=0;i<exp.length();i++){
            if((exp.charAt(i)>='0' && exp.charAt(i)<='9')){
                StringBuilder number = new StringBuilder();
                while (exp.charAt(i) != ',') {
                    number.append(exp.charAt(i++));
                }
                valStack.push(Float.parseFloat(number.toString()));
            }
            else if(exp.charAt(i)!='('){
                float op2=valStack.pop();
                float op1=valStack.pop();
                switch(exp.charAt(i)){
                    case '+':
                        valStack.push(op1 + op2);
                        break;
                    case '-':
                        valStack.push(op1 - op2);
                        break;
                    case 'x':
                        valStack.push(op1 * op2);
                        break;
                    case '/':
                        if(op2 == 0)
                            throw new CalculationException();
                        valStack.push(op1 / op2);
                        break;
                    case '^':
                        valStack.push((float)Math.pow(op1,op2));
                        break;
                    default:
                        throw new CalculationException();
                }
            }
        }
        this.result=valStack.pop();
    }

    public static void main(String[] args) throws CalculationException{
    	/*Calculations c=new Calculations();
    	float val=c.calculate("(4)^2");
    	System.out.println(val);*/
    }
}
