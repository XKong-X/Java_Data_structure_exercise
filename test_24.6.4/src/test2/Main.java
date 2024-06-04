package test2;

import java.util.HashSet;
import java.util.Set;

public class Main {
}

class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int x : candyType) {
            set.add(x);
        }
        return Math.min(candyType.length / 2, set.size());
    }
}