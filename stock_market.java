import java.util.Arrays;
public class StockPriceAnalysis {
    public static int[] findNextGreaterPrices(int[] prices) {
        int[] result = new int[prices.length];
        Arrays.fill(result, -1); 
        findNextGreater(prices, result, prices.length - 1);
        return result;
    }
    private static void findNextGreater(int[] prices, int[] result, int index) {
        if (index < 0) {
            return;
        for (int j = index + 1; j < prices.length; j++) {
            if (prices[j] > prices[index]) {
                result[index] = prices[j];
                break;
            }
        }
        findNextGreater(prices, result, index - 1);
    }
    public static void main(String[] args) {
        int[] arr1 = {6, 8, 0, 1, 3};
        System.out.println(Arrays.toString(findNextGreaterPrices(arr1)));
        System.out.println(Arrays.toString(findNextGreaterPrices(arr2))); 
        int[] arr3 = {10, 20, 30, 50};
        System.out.println(Arrays.toString(findNextGreaterPrices(arr3))); 
        int[] arr4 = {50, 40, 30, 10};
        System.out.println(Arrays.toString(findNextGreaterPrices(arr4)));
    }
}
