package slidingwindow;

public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int tempSum = 0;
        for (int i = 0 ; i < k ; i++) {
            tempSum = tempSum + cardPoints[i];
        }
        int maxSum = tempSum;

        for (int i = 0 ; i < k ; i++) {
            tempSum = tempSum - cardPoints[k - i - 1] + cardPoints[cardPoints.length - 1 - i];
            maxSum = Math.max(tempSum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int maxSum;
        MaximumPointsYouCanObtainFromCards points = new MaximumPointsYouCanObtainFromCards();
        maxSum = points.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3);
        System.out.println(maxSum);
    }
}
