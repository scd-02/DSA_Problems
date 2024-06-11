import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class Greedy_MaximumTipCalculator {
  public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        
    //return rec(arr, brr, x, y, n);

    // HashMap<String, Long> dp = new HashMap<>();
    // return mem(arr, brr, x, y, n, dp);
    
    return optimum(arr, brr, x, y, n);
    
}

static class Order{
    int a_tip;
    int b_tip;
    int diff;
    
    Order(int a_tip, int b_tip){
       this.a_tip = a_tip;
       this.b_tip = b_tip;
       this.diff = Math.abs(a_tip - b_tip);
    }
}

static long optimum(int arr[], int brr[], int x, int y, int n){
    
    ArrayList<Order> orders = new ArrayList<>();
    for(int i = 0; i < n; i++){
        orders.add(new Order(arr[i], brr[i]));
    }
    
    Collections.sort(orders, (o1, o2) -> Integer.compare(o1.diff, o2.diff));
    
    long ans = 0;
    for(int i = n - 1; i >= 0; i--){
        Order o = orders.get(i);
        if((o.a_tip >= o.b_tip && x > 0) || y <= 0){
            ans += o.a_tip;
            x--;
        }else{
            ans += o.b_tip;
            y--;
        }
        
    }
    
    return ans;
}

static long rec(int []arr, int []brr, int x, int y, int i){
    
    if(i == 0) return 0;
    
    if(x != 0 && y != 0){
        
        long inc_arr = arr[i - 1] + rec(arr, brr, x - 1, y, i - 1);
        long inc_brr = brr[i - 1] + rec(arr, brr, x, y - 1, i - 1);
        
        return Math.max(inc_arr, inc_brr);
        
    }
    
    if(x == 0){
        
        return brr[i - 1] + rec(arr, brr, x, y - 1, i - 1);
        
    }else{
        
        return arr[i - 1] + rec(arr, brr, x - 1, y, i - 1);
        
    }
    
}

static long mem(int []arr, int []brr, int x, int y, int i, HashMap<String, Long> dp){
    
    String order = "" + i + "-" + x + "-" + y;
    
    if(dp.get(order) != null) return dp.get(order);
    
    if(i == 0) return 0;
    
    if(x != 0 && y != 0){
        
        long inc_arr = arr[i - 1] + mem(arr, brr, x - 1, y, i - 1, dp);
        long inc_brr = brr[i - 1] + mem(arr, brr, x, y - 1, i - 1, dp);
        
        dp.put(order, Math.max(inc_arr, inc_brr));
        return dp.get(order);
        
    }
    
    if(x == 0){
        
        dp.put(order, brr[i - 1] + mem(arr, brr, x, y - 1, i - 1, dp));
        return dp.get(order);
        
    }else{
        
        dp.put(order, arr[i - 1] + mem(arr, brr, x - 1, y, i - 1, dp));
        return dp.get(order);
    }
    
}
}
