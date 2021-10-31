class Solution {
    public String decodeString(String s) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        
         for (int i = 0; i < s.length(); ++i) {
        if (s.charAt(i) != ']') {
            stack.push(s.charAt(i));
        } else {
            StringBuilder sb = new StringBuilder();
            char c;
            while ((c = stack.pop()) != '[') {
                sb.append(c);
                if (c == '[') {
                    break;
                }
            }
            sb.reverse();
            StringBuilder number = new StringBuilder();
            while (!stack.isEmpty() && Character.isDigit(c = stack.peek())) {
                stack.pop();
                number.append(c);
                if (!Character.isDigit(c)) {
                    break;
                }
            }
            int times = Integer.parseInt(number.reverse().toString());
            for (int j = 0; j < times; ++j) {
                for (int k = 0; k < sb.length(); ++ k) {
                    stack.push(sb.charAt(k));
                }
            }
        }
    }
    StringBuilder result = new StringBuilder();
    while (!stack.isEmpty()) {
        result.append(stack.pop());
    }
    return result.reverse().toString();
    }
}