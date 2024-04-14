package com.example.algorithm.algorithm.binary_tree;

public class MaxHeap {

    private int[] Heap;
    private int size;
    private int maxsize;

    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        return pos > (size / 2) && pos <= size;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void siftUp(int pos) {
        while (pos > 0 && Heap[parent(pos)] < Heap[pos]) {
            swap(pos, parent(pos));
            pos = parent(pos);
        }
    }

    public void insert(int element) {
        if (size >= maxsize) {
            return;
        }

        Heap[++size] = element;
        int current = size;

        siftUp(current);
    }

    private void siftDown(int pos) {
        while (!isLeaf(pos)) {
            int left = leftChild(pos);
            int right = rightChild(pos);
            int largerChild = left; // Assume left child is the larger child.

            if (right <= size && Heap[left] < Heap[right]) {
                largerChild = right;
            }

            if (Heap[pos] >= Heap[largerChild]) {
                return;
            }

            swap(pos, largerChild);
            pos = largerChild;
        }
    }

    public int remove() {
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        siftDown(1);
        return popped;
    }

    // Utility method to print the heap
    public void printMaxHeap() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " +
                    Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public static void main(String[] arg) {
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.printMaxHeap();

        System.out.println("The max value is " + maxHeap.remove());

        maxHeap.printMaxHeap();
    }
}
