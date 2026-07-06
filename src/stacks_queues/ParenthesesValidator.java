package stacks_queues;
import java.util.ArrayDeque;

public class ParenthesesValidator {
    public static boolean isValid(String s){
        ArrayDeque<Character> stack=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(' || ch=='{'|| ch=='['){
                stack.push(ch);
            } else if (ch==')'||ch=='}'||ch==']') {

                if(stack.isEmpty()){
                    return false;
                }
                char openBracket=stack.pop();
                if(ch==')'&& openBracket!='(')return false;
                if(ch=='}'&& openBracket!='{')return false;
                if(ch==']'&& openBracket!='[')return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String test1 = "{[]}";
        String test2 = "([)]";

        System.out.println("Test 1 Safe? " + isValid(test1)); // Expected: true
        System.out.println("Test 2 Safe? " + isValid(test2)); // Expected: false
    }
}
