public class String_ColumnNameFromAGivenColumnNumber {
  String colName (long n)
    {
        String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder ans = new StringBuilder("");
        
        while(n != 0){
            
            long digit = (n - 1) % 26;
            ans.insert(0, alph.charAt((int)digit));
            n = (n - 1) / 26;
            
        }
        
        return ans.toString();
    }
}
