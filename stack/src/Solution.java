

/**
 * Created by upupgogogo on 2018/4/26.上午11:38
 */
public class Solution {

    public static boolean isValid(String s) {
        Stack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '{' | c == '[' | c == '(')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                char topChar = stack.pop();
                if (c == '}' && topChar != '{')
                    return false;

                if (c == ']' && topChar != ']')
                    return false;

                if (c == ')' && topChar != ')')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{{{}}}"));
    }
}
