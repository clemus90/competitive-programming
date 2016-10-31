import java.util.Stack

public class ValidSequenceOfBrackets{
  public int solution(String S, int K){
    Stack<Character> brackets = new Stack<>();
    for(int i=0; i<S.length(); i++){
      brackets.push(S.charAt(i));
    }
  }
}