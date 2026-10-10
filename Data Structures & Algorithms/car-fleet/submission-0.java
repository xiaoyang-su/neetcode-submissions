class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] position1 = new int[2][position.length];
        for (int i = 0; i < position.length; i++) {
            position1[0][i] = position[i];
            position1[1][i] = speed[i];
        }
        int n = position.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < idx.length; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> Integer.compare(position1[0][b], position1[0][a]));
        int[][] sorted = new int[2][n];
        for (int i = 0; i < n; i++) {
            sorted[0][i] = position1[0][idx[i]];
            sorted[1][i] = position1[1][idx[i]];
        }
        System.arraycopy(sorted[0], 0, position1[0], 0, n);
        System.arraycopy(sorted[1], 0, position1[1], 0, n);
        Deque<Integer> cars = new ArrayDeque<>();
        for (int i = 0; i < position1[0].length; i++) {
            if (cars.isEmpty()) {
                cars.push(i);
            }
            else
            {
                while (!cars.isEmpty() && position1[0][i] < position1[0][cars.peek()]) {
                    if (position1[1][i] <= position1[1][cars.peek()]) {
                        cars.push(i);
                    }
                    else if ((target - position1[0][cars.peek()]) * (position1[1][i] - position1[1][cars.peek()]) < 
                    (- position1[0][i] + position1[0][cars.peek()]) * position1[1][cars.peek()]) {
                        cars.push(i);
                    }
                    else {
                        break;
                    }
                }
            }
        }
        return cars.size();
    }
}
