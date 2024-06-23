package org.example.implementation.normal;

import org.example.definition.Queue;
import org.example.definition.QueueOfQueue;
import org.example.definition.Stack;

import static org.example.util.QueueOfQueueUtil.copyQueueOfQueue;

public class StaticQueueOfQueue implements QueueOfQueue {
    private final int MAX = 10000;
    private final Queue[] queuesArray;
    private int count;

    public StaticQueueOfQueue(int length) {
        this.queuesArray = new Queue[length];
        this.count = 0;
    }

    @Override
    public void addQueue(Queue queue) {
        if (count == MAX) {
            throw new RuntimeException("Cantidad máxima de elementos alcanzada");
        }
        queuesArray[count] = queue;
        count++;
    }

    @Override
    public void removeQueue() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacia");
        }
        for(int i = 0; i < count - 1; i++) {
            queuesArray[i] = queuesArray[i + 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public Queue getFirstQueue() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        return queuesArray[0];
    }

    @Override
    public int getLenght() {
        return count;
    }

    @Override
    public QueueOfQueue concatenate(int length, QueueOfQueue... qoq) {
        QueueOfQueue qoqConcatenated = new StaticQueueOfQueue(length);
        for (QueueOfQueue queueOfQueue : qoq) {
            while (!queueOfQueue.isEmpty()) {
                Queue firstQueue = queueOfQueue.getFirstQueue();
                qoqConcatenated.addQueue(firstQueue);
                queueOfQueue.removeQueue();
            }
        }
        return qoqConcatenated;
    }

    @Override
    public Queue flat(QueueOfQueue queueOfQueue) {
        QueueOfQueue qoq = copyQueueOfQueue(queueOfQueue);
        Queue queue = new StaticQueue();
        while(!qoq.isEmpty()) {
            Queue queueAux = qoq.getFirstQueue();
            while(!queueAux.isEmpty()) {
                queue.add(queueAux.getFirst());
                queueAux.remove();
            }
            qoq.removeQueue();
        }
        return queue;
    }

    @Override
    public QueueOfQueue reverseWithDepth(QueueOfQueue queueOfQueue) {
        int length = queueOfQueue.getLenght();
        QueueOfQueue qoq = copyQueueOfQueue(queueOfQueue);
        QueueOfQueue reverseQoq = new StaticQueueOfQueue(length);
        StaticQueue[] queueAux = new StaticQueue[length];
        int colIndex = 0;
        for (int i = 0; i < length; i++) {
            queueAux[i] = new StaticQueue();
        }

        while (!qoq.isEmpty()) {
            Queue queue = qoq.getFirstQueue();
            while (!queue.isEmpty()) {
                queueAux[colIndex].add(queue.getFirst());
                queue.remove();
            }
            qoq.removeQueue();
            colIndex++;
        }

        for (int i = colIndex - 1; i >= 0; i--) {
            Stack reverseQueue = new StaticStack();
            Queue queueDepth = new StaticQueue();
            while(!queueAux[i].isEmpty()) {
                    reverseQueue.add(queueAux[i].getFirst());
                    queueAux[i].remove();
            }
            while(!reverseQueue.isEmpty()) {
                    queueDepth.add(reverseQueue.getTop());
                    reverseQueue.remove();
            }
            reverseQoq.addQueue(queueDepth);
        }

        return reverseQoq;
    }
}
