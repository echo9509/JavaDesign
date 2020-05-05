package com.algorithm.tree;

import java.util.Arrays;

/**
 * @author sh
 */
public class PriorityQueue {

    private int[] array;

    private int size;

    public PriorityQueue(int size) {
        array = new int[size];
    }

    public void enqueue(int value) {
        if (size >= array.length) {
            resize();
        }
        array[size++] = value;
        upAdjust(array);
    }

    public int dequeue() throws Exception {
        if (size < 0) {
            throw new Exception("queue is empty!");
        }
        int head = array[0];
        array[0] = array[--size];
        downAdjust();
        return head;
    }

    private void upAdjust(int[] array) {
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (childIndex > 0 && array[parentIndex] < array[childIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    private void downAdjust() {
        int parenIndex = 0;
        int childIndex = 2 * parenIndex + 1;
        int temp = array[parenIndex];
        while (parenIndex < size) {
            if (childIndex + 1 < size && array[childIndex + 1] > array[childIndex]) {
                childIndex ++;
            }
            if (temp >= array[childIndex]) {
                break;
            }
            array[parenIndex] = array[childIndex];
            parenIndex = childIndex;
            childIndex = 2 * parenIndex + 1;
        }
        array[parenIndex] = temp;
    }

    private void resize() {
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(this.array, newSize);
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) throws Exception {
        PriorityQueue priorityQueue = new PriorityQueue(32);
        priorityQueue.enqueue(3);
        priorityQueue.enqueue(5);
        priorityQueue.enqueue(10);
        priorityQueue.enqueue(2);
        priorityQueue.enqueue(7);
        System.out.println(priorityQueue.toString());
        System.out.println("出队：" + priorityQueue.dequeue());
        System.out.println("出队：" + priorityQueue.dequeue());
    }
}
