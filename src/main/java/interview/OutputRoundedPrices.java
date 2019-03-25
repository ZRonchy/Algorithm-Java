package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * We need to output a list of doubles like [10.4, 10.3] as integers.
 * 10.4+10.3 = 20.7 so actually the output should sum up to round(20.7) = 21.
 * We also need to round each double in the list so that their sum equals to 21.
 * so [10.4, 10.3] will be rounded as [10, 11] or [11, 10]. Note each double could be rounded via ceil or floor.
 * We need to output a list of integers (rounded), so that the sum of the diffs is minimized.
 * [10.4, 10.3] will be rounded as [11, 10] not [10, 11] because the diff |10.4 - 11| is less than |10.3 -11|
 *
 * Solution, 10.4 + 10.3 = 20.7, natural rounded price sum is 10 + 10 = 20. We need one integer to be rounded up,
 * rather then rounded down. So we are actually trying to find the top k smallest diff of these prices
 */
public class OutputRoundedPrices {

    static List<Integer> outputRoundedPrices(List<Double> prices) {
        List<Integer> result = new ArrayList<>();
        if (prices == null || prices.size() == 0) {
            return result;
        }
        int roundedSum = 0;
        double sum = 0;

        for (int i = 0; i < prices.size(); i++) {
            roundedSum += Math.round(prices.get(i));
            sum += prices.get(i);
        }

        int target = roundedSum - new Double(Math.round(sum)).intValue(); // could be larger than 1 like 3
        boolean useCeil;
        if (target > 0) {
            useCeil = false;
        } else {
            useCeil = true;
        }
        target = Math.abs(target);
        // Note same diff will be overridden, so use List<Integer> to store index
        TreeMap<Double, List<Integer>> diffToIndexMap = new TreeMap<>();

        for (int i = 0; i < prices.size(); i++) {
            if (useCeil) {
                double diff = Math.ceil(prices.get(i)) - prices.get(i);
                List<Integer> list = diffToIndexMap.getOrDefault(diff, new ArrayList<>());
                list.add(i);
                diffToIndexMap.put(diff, list);  // O(Logn)
            } else {
                double diff = prices.get(i) - Math.floor(prices.get(i));
                List<Integer> list = diffToIndexMap.getOrDefault(diff, new ArrayList<>());
                list.add(i);
                diffToIndexMap.put(diff, list);  // O(Logn)
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        while (target > 0 && !diffToIndexMap.isEmpty()) { // Note diffToIndexMap cannot be empty
            List<Integer> indexList = diffToIndexMap.firstEntry().getValue(); // O(Logn)
            while (target > 0 && !indexList.isEmpty()) {
                int index = indexList.get(0);
                int value = useCeil ?
                        new Double(Math.ceil(prices.get(index))).intValue() : new Double(Math.floor(prices.get(index))).intValue();
                map.put(index, value);
                indexList.remove(0);
                target--;
            }
        }

        // O(n)
        for (int i = 0; i < prices.size(); i++) {
            if (map.containsKey(i)) {
                result.add(map.get(i));
            } else {
                result.add(new Double(Math.round(prices.get(i))).intValue());
            }
        }

        return result;
    }


    // 1. int, empty, all ceil, all floor
    public static void main(String[] args) {
        List<Double> tests = new ArrayList<>();
        tests.add(0.5);  // 2
        tests.add(0.5);
        tests.add(0.2);
        tests.add(0.1);
        //5.4, 4.3, 3.7
        System.out.println(outputRoundedPrices(tests));
    }
}
