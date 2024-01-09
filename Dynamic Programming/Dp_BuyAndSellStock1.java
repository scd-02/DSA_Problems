import java.util.ArrayList;

public class Dp_BuyAndSellStock1 {
    // Function to find the days of buying and selling stock for max profit.
    ArrayList<ArrayList<Integer>> stockBuySell(int a[], int n) {
        // code here

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i - 1);
                temp.add(i);
                list.add(temp);
            }
        }
        return list;
    }
}