package Hashing;

import java.util.LinkedHashMap;
import java.util.Map;

public class FrequencyOfArrayElements {

    static void count(int[] arr, int n) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            System.out.println(e.getKey() + "\t" + e.getValue());
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 12, 10, 15, 10, 20, 12, 12};
        count(arr, arr.length);
    }
}
