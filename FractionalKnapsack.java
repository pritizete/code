import java.util.Arrays;

class Item {
    int weight;
    int value;
    double ratio;

    // Constructor to calculate value-to-weight ratio immediately
    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.ratio = (double) value / weight;
    }
}

public class FractionalKnapsack {

    public static double getMaxValue(Item[] items, int capacity) {
        // Step 1: Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0.0;
        int currentWeight = 0;

        // Step 2: Iterate through sorted items
        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                // Take the whole item
                currentWeight += item.weight;
                totalValue += item.value;
            } else {
                // Take the fraction of the item that fits
                int remainingCapacity = capacity - currentWeight;
                totalValue += item.ratio * remainingCapacity;
                break; // Knapsack is full
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item(10, 60),  // ratio = 6.0
            new Item(20, 100), // ratio = 5.0
            new Item(30, 120)  // ratio = 4.0
        };
        int capacity = 50;

        double maxProfit = getMaxValue(items, capacity);
        System.out.println("Maximum value in Fractional Knapsack = " + maxProfit);
    }
}