package DAA;
import java.util.*;

class HuffmanNode {
    int data;
    char c;
    HuffmanNode left;
    HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.data - y.data;
    }
}

public class Huffman {
    public static void printHuffmanCodes(HuffmanNode root, String s) {
        if (root.left == null && root.right == null ) {
            System.out.println(root.c + ":" + s);
            return;
        }
        printHuffmanCodes(root.left, s + "0");
        printHuffmanCodes(root.right, s + "1");
    }

    public static void buildHuffmanTree(char[] charArray, int[] charFreq) {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>(charArray.length, new MyComparator());

        for (int i = 0; i < charArray.length; i++) {
            HuffmanNode node = new HuffmanNode();
            node.c = charArray[i];
            node.data = charFreq[i];
            node.left = null;
            node.right = null;
            priorityQueue.add(node);
        }

        while (priorityQueue.size() > 1) {
            HuffmanNode x = priorityQueue.poll();
            HuffmanNode y = priorityQueue.poll();
            HuffmanNode newNode = new HuffmanNode();
            newNode.data = x.data + y.data;
            newNode.c = '-';
            newNode.left = x;
            newNode.right = y;
            priorityQueue.add(newNode);
        }
        printHuffmanCodes(priorityQueue.poll(), "");
    }

    public static void main(String[] args) {
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charFreq = { 5, 9, 12, 13, 16, 45 };

        buildHuffmanTree(charArray, charFreq);
    }
}
