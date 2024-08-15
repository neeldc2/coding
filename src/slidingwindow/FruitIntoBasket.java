package slidingwindow;

public class FruitIntoBasket {

    public int totalFruit(int[] fruits) {
        int startIndex = 0;
        int maxFruits = 0;
        if (fruits.length < 3) {
            return fruits.length;
        }

        int elementA = fruits[0];
        int elementB = -1;

        int indexA = 0;
        int indexB = -1;

        for (int i = 1; i < fruits.length; i++) {
            int currentElement = fruits[i];
            if (currentElement == elementA) {
                indexA = i;
            } else if (currentElement == elementB) {
                indexB = i;
            } else {
                if (indexA < indexB) {
                    startIndex = indexA + 1;
                    indexA = i;
                    elementA = currentElement;
                } else {
                    startIndex = indexB + 1;
                    indexB = i;
                    elementB = currentElement;
                }
            }
            maxFruits = Math.max(maxFruits, (i - startIndex + 1));
        }

        return maxFruits;
    }

    public static void main(String[] args) {
        FruitIntoBasket fruitIntoBasket = new FruitIntoBasket();
        System.out.println(fruitIntoBasket.totalFruit(new int[]{1, 2, 3, 2, 2, 4, 4, 2, 6}));
    }
}
