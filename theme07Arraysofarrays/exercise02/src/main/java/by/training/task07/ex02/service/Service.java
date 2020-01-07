package by.training.task07.ex02.service;

public class Service {
    public int[][] createArray(int n) {
        int[][] array = new int[n][n];

        for (int i = 0; i < n; ++i) {
            int amountOfOne = 0;
            if (i <= n / 2) {
                amountOfOne = (i + 1) * 2;
            } else {
                amountOfOne = (n - i) * 2;
            }

            int oneUp = amountOfOne / 2;
            int oneDown = oneUp;

            if (oneDown == 3) {
                System.out.println("qqq");
            }

            for (int j = 0; j < n / 2; ++j) {
                if (oneUp > 0) {
                    array[i][j] = 1;
                    --oneUp;
                } else {
                    array[i][j] = 0;
                }
            }

            for (int j = n - 1; j >= n / 2; --j) {
                if (oneDown > 0) {
                    array[i][j] = 1;
                    --oneDown;
                } else {
                    array[i][j] = 0;
                }
            }

        }
        return array;
    }
}
