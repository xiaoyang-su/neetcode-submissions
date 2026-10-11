class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m - 1;
        if (target < matrix[0][0]) {
            return false;
        }
        else if(target > matrix[m - 1][0]) {
            int left1 = 0, right1 = n - 1;
            while (left1 < right1) {
                int mid = left1 + (right1 - left1) / 2;
                if (matrix[m - 1][mid] == target) {
                    return true;
                }
                else if (matrix[m - 1][mid] < target) {
                    left1 = mid + 1;
                }
                else {
                    right1 = mid;
                }
            }
            if (matrix[m - 1][left1] == target) {
                return true;
            }
            else {
                return false;
            }
        }
        // if (m == 1) {
        //     int left1 = 0, right1 = n - 1;
        //     while (left1 < right1) {
        //         int mid = left1 + (right1 - left1) / 2;
        //         if (matrix[0][mid] == target) {
        //             return true;
        //         }
        //         else if (matrix[0][mid] < target) {
        //             left1 = mid + 1;
        //         }
        //         else {
        //             right1 = mid;
        //         }
        //     }
        //     if (matrix[0][left1] == target) {
        //         return true;
        //     }
        //     else {
        //         return false;
        //     }
        // }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) {
                return true;
            }
            else if (matrix[mid][0] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        if (matrix[left][0] == target) {
            return true;
        }
        else {
            int left1 = 0, right1 = n - 1;
            while (left1 < right1) {
                int mid = left1 + (right1 - left1) / 2;
                if (matrix[left - 1][mid] == target) {
                    return true;
                }
                else if (matrix[left - 1][mid] < target) {
                    left1 = mid + 1;
                }
                else {
                    right1 = mid;
                }
            }
            if (matrix[left - 1][left1] == target) {
                return true;
            }
            else {
                return false;
            }
        }
        // return false;
    }
}