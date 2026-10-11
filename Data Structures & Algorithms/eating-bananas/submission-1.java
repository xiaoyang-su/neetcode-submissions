class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int right = piles[piles.length - 1], left = 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (possibleOrNot(piles, h, mid)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean possibleOrNot(int[] piles, int h, int k) {
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += Math.ceilDiv(piles[i], k);
        }
        if (sum > h) {
            return false;
        }
        else {
        return true;
        }
    }
}
