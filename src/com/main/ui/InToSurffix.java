package com.lenovo.test;

import java.util.Stack;

public class InToSurffix {

	public static String inToSurffix(String exp){
		//中缀表达式转换为后缀表达式
		char[] chs = exp.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		StringBuilder s = new StringBuilder();
		char temp;
		
		for(int i=0;i<chs.length;i++){
			switch(chs[i]){
			case ' ':
				break;
			case '(':
				stack.push(chs[i]);
				break;
			case '+':
			case '-':
				while(!stack.isEmpty()){
					temp = stack.pop();
					if(temp == '('){
						stack.push(temp);
						break;
					}
					s.append(temp);
				}
				stack.push(chs[i]);
				break;
				
			case '*':
			case '/':
				while(!stack.isEmpty()){
					temp = stack.pop();
					if(temp == '(' || temp == '+' || temp == '-'){
						stack.push(temp);
						break;
					}
					s.append(temp);
				}
				stack.push(chs[i]);
				break;
			case ')':
				while(!stack.isEmpty()){
					temp = stack.pop();
					if(temp == '('){
						break;
					}
					s.append(temp);
				}
				break;
			
			default:
				s.append(chs[i]);
				break;
			}
		}
		while(!stack.isEmpty()){
			s.append(stack.pop());
		}
		
		return s.toString();
	}
}
