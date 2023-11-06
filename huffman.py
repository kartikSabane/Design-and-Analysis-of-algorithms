import heapq

class MinHeapNode:
    def _init_(self, data, freq):
        self.data = data
        self.freq = freq
        self.left = None
        self.right = None

def print_codes(root, string):
    if root is None:
        return
    if root.data != '$':
        print(root.data + ": " + string)
    print_codes(root.left, string + "0")
    print_codes(root.right, string + "1")

def huffman_code(data, freq):
    min_heap = []

    for i in range(len(data)):
        node = MinHeapNode(data[i], freq[i])
        heapq.heappush(min_heap, (node.freq, id(node), node))

    while len(min_heap) > 1:
        freq1, _, left = heapq.heappop(min_heap)
        freq2, _, right = heapq.heappop(min_heap)
        temp = MinHeapNode('$', freq1 + freq2)
        temp.left = left
        temp.right = right
        heapq.heappush(min_heap, (temp.freq, id(temp), temp))

    root = min_heap[0][2]
    print("Huffman Codes:")
    print_codes(root, "")

if __name__ == "__main__":
    n = int(input("Enter total number of  character to insert: "))
    m = int(input("Enter total number of  frequency to insert: "))
    data = []
    freq = []

    for i in range(n):
        char = input("Enter the character: ")
        data.append(char)
    for i in range(n):
        f = int(input("Enter the frequency: "))
        freq.append(f)

    huffman_code(data, freq)