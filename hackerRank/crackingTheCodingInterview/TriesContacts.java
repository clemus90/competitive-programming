import java.util.Scanner;

public class TriesContacts{

  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    Trie t = new Trie();
    int n = in.nextInt();
    for(int a0 = 0; a0 < n; a0++){
        String op = in.next();
        String contact = in.next();
        if(op.equals("add")){
          addWordToTrie(t, contact);
        }
        if(op.equals("find")){
          System.out.println(findPartials(t, contact));
        }
    }
  }

  public static void addWordToTrie(Trie t, String word){
    Trie lastTrie = t;
    for(int i=0; i<word.length(); i++){
      lastTrie = lastTrie.addChild(word.charAt(i));
    }
  }

  public static int findPartials(Trie t, String partial){
    Trie fromTrie = t;
    for(int i=0; i<partial.length(); i++){
      Trie child = fromTrie.getChild(partial.charAt(i));
      if (child != null){
        fromTrie = child;
      }
      else{
        return 0;
      }
    }
    return fromTrie.wordCount;
  }
  
}

class Trie{
  int wordCount;
  Trie[] letters = new Trie[26];

  public static int getIndexFromChar(char c){
    return (int)c - (int)'a';
  }

  public Trie(){
    wordCount = 0;
    for(int i=0; i<26; i++){
      letters[i] = null;
    }
  }

  public Trie addChild(char letter){
    Trie curr = null;
    int index = getIndexFromChar(letter);
    if(letters[index] != null){
      curr = letters[index];
      curr.wordCount++;
    }
    else{
      letters[index] = curr = new Trie();
      curr.wordCount = 1;
    }

    return curr;
  }

  public Trie getChild(char letter){
    return letters[getIndexFromChar(letter)];
  }
}