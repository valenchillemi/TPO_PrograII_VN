package org.example;

import org.example.implementation.normal.StaticQueueOfQueue;
import org.example.implementation.normal.StaticQueueOfStacks;
import org.example.implementation.normal.StaticStack;

import static org.example.util.QueueOfStacksUtil.*;

public class Main {
    public static void main(String[] args) {
        StaticStack sk1 = new StaticStack();
        StaticStack sk2 = new StaticStack();
        StaticStack sk3 = new StaticStack();
        StaticStack sk4 = new StaticStack();
        StaticStack sk5 = new StaticStack();
        StaticStack sk6 = new StaticStack();

        sk1.add(1);
        sk1.add(2);
        sk1.add(3);

        sk2.add(4);
        sk2.add(5);
        sk2.add(6);

        sk3.add(7);
        sk3.add(8);
        sk3.add(9);

        sk4.add(1);
        sk4.add(2);
        sk4.add(3);

        sk5.add(4);
        sk5.add(5);
        sk5.add(6);

        sk6.add(7);
        sk6.add(8);
        sk6.add(9);

        StaticQueueOfStacks queue = new StaticQueueOfStacks(3);

        queue.add(sk1);
        queue.add(sk2);
        queue.add(sk3);

//        int traza = calcularTraza(queue);
//        System.out.println(traza);
//        StaticQueueOfStacks traspuesta = calcularTraspuesta(queue);
//        System.out.println(traspuesta);

        StaticQueueOfStacks queue2 = new StaticQueueOfStacks(3);

        queue2.add(sk4);
        queue2.add(sk5);
        queue2.add(sk6);

        StaticQueueOfStacks sumaQueue = sumarMatrices(queue, queue2);

        StaticQueueOfQueue queueOfQueue = new StaticQueueOfQueue(3);


    }
}