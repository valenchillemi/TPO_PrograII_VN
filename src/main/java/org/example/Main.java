package org.example;

import org.example.definition.Queue;
import org.example.definition.QueueOfQueue;
import org.example.implementation.normal.StaticQueue;
import org.example.implementation.normal.StaticQueueOfQueue;
import org.example.implementation.normal.StaticQueueOfStacks;
import org.example.implementation.normal.StaticStack;

import static org.example.util.QueueOfStacksUtil.*;

public class Main {
    public static void main(String[] args) {
//        StaticStack sk1 = new StaticStack();
//        StaticStack sk2 = new StaticStack();
//        StaticStack sk3 = new StaticStack();
//        StaticStack sk4 = new StaticStack();
//        StaticStack sk5 = new StaticStack();
//        StaticStack sk6 = new StaticStack();
//
//        sk1.add(1);
//        sk1.add(2);
//        sk1.add(3);
//
//        sk2.add(4);
//        sk2.add(5);
//        sk2.add(6);
//
//        sk3.add(7);
//        sk3.add(8);
//        sk3.add(9);
//
//        sk4.add(1);
//        sk4.add(2);
//        sk4.add(3);
//
//        sk5.add(4);
//        sk5.add(5);
//        sk5.add(6);
//
//        sk6.add(7);
//        sk6.add(8);
//        sk6.add(9);
//
//        StaticQueueOfStacks queue = new StaticQueueOfStacks(3);
//
//        queue.add(sk1);
//        queue.add(sk2);
//        queue.add(sk3);

//        int traza = calcularTraza(queue);
//        System.out.println(traza);
//        StaticQueueOfStacks traspuesta = calcularTraspuesta(queue);
//        System.out.println(traspuesta);

//        StaticQueueOfStacks queue2 = new StaticQueueOfStacks(3);
//
//        queue2.add(sk4);
//        queue2.add(sk5);
//        queue2.add(sk6);
//
//        StaticQueueOfStacks sumaQueue = sumarMatrices(queue, queue2);
//
//        StaticQueueOfQueue queueOfQueue = new StaticQueueOfQueue(3);

        StaticQueue queue1 = new StaticQueue();
        StaticQueue queue2 = new StaticQueue();
        StaticQueue queue3 = new StaticQueue();
        StaticQueue queue4 = new StaticQueue();
        StaticQueue queue5 = new StaticQueue();
        StaticQueue queue6 = new StaticQueue();
        QueueOfQueue qoq1 = new StaticQueueOfQueue(3);
        QueueOfQueue qoq2 = new StaticQueueOfQueue(3);

        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        queue2.add(4);
        queue2.add(5);
        queue2.add(6);
        queue3.add(7);
        queue3.add(8);
        queue3.add(9);

        queue4.add(1);
        queue4.add(2);
        queue4.add(3);
        queue5.add(4);
        queue5.add(5);
        queue5.add(6);
        queue6.add(7);
        queue6.add(8);
        queue6.add(9);

        qoq1.addQueue(queue1);
        qoq1.addQueue(queue2);
        qoq1.addQueue(queue3);

        qoq2.addQueue(queue4);
        qoq2.addQueue(queue5);
        qoq2.addQueue(queue6);

        // QueueOfQueue qconcatenate = qoq1.concatenate(6, qoq1, qoq2);
        // Queue queueFlat = qoq1.flat(qoq1);

        QueueOfQueue reverse = qoq2.reverseWithDepth(qoq2);
    }
}