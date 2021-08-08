class Solution {
    
    private final List<String> answers = new ArrayList<>();
    static int n;
    
    private void find(String cur, int opened_num, int closed_num) {
        if(closed_num == n) {
            answers.add(cur);
        } else if(opened_num < n) {
            find(cur + "(", opened_num + 1, closed_num);
        } 
        
        if(closed_num < opened_num) {
            find(cur + ")", opened_num, closed_num + 1);
        }
    }
    public List<String> generateParenthesis(int n) {
       this.n = n;
        
        if(n == 1) {
            answers.add("()");
            return answers;
        } else{
            find("", 0, 0);
        }
        return answers;
    }
}