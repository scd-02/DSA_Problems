public class String_CountTheNumberOfConsistentString {
  public int countConsistentStrings(String allowed, String[] words) {
        
    int allowedBits = 0;
    for(int i = 0; i < allowed.length(); i++){
        allowedBits |= 1 << (allowed.charAt(i) - 'a');
    }

    int count = 0;
    for(String word: words){

        boolean isConsistent = true;

        for(int i = 0; i < word.length(); i++){
            int bit = (allowedBits >> (word.charAt(i) - 'a')) & 1;

            if(bit == 0){
                isConsistent = false;
                break;
            }
        }

        if(isConsistent){
            count++;
        }
    }

    return count;
}
}
