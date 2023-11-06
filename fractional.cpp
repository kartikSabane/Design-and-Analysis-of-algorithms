#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Item {
    int weight;
    int value;
};

bool compareItems(const Item& item1, const Item& item2) {
    return (static_cast<double>(item1.value) / item1.weight) > (static_cast<double>(item2.value) / item2.weight);
}

double fractionalKnapsack(int capacity, vector<Item>& items) {
    sort(items.begin(), items.end(), compareItems);

    double maxValue = 0.0;

    for (const Item& item : items) {
        if (capacity == 0)
            break;

        if (item.weight <= capacity) {
            maxValue += item.value;
            capacity -= item.weight;
        } else {
            double fraction = static_cast<double>(capacity) / item.weight;
            maxValue += fraction * item.value;
            capacity = 0;
        }
    }

    return maxValue;
}

int main() {
    int capacity;
    cout << "Enter the capacity of the knapsack: ";
    cin >> capacity;

    int n;
    cout << "Enter the number of items: ";
    cin >> n;

    vector<Item> items(n);

    for (int i = 0; i < n; i++) {
        cout << "Enter weight and value for item " << i + 1 << ": ";
        cin >> items[i].weight >> items[i].value;
    }

    double max_value = fractionalKnapsack(capacity, items);
    cout << "Max Value is: " << max_value << endl;

    return 0;
}