import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='(') stack.push(c);
            else if(stack.isEmpty() || stack.peek()!='(') return false;
            else stack.pop();
        }
        return stack.size()==0;
    }
}
