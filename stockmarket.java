import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;
public class StockMarket {
    public static List<Integer> minStockPrices(int[] prices, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            while (!deque.isEmpty() && prices[deque.peekLast()] > prices[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                result.add(prices[deque.peek()]);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] stockPrices = {120, 110, 115, 100, 105, 98, 102};
        int k = 3;
        List<Integer> minPrices = minStockPrices(stockPrices, k);
        System.out.println(minPrices); // Output: [110, 100, 100, 98, 98]
    }
}
