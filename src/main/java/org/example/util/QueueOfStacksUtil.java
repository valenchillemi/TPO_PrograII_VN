package org.example.util;

import org.example.definition.Stack;
import org.example.implementation.normal.StaticQueue;
import org.example.implementation.normal.StaticQueueOfStacks;
import org.example.implementation.normal.StaticStack;

public class QueueOfStacksUtil {

    public static int calcularTraza(StaticQueueOfStacks queueOfStacks) { // Calculamos la traza de una matriz de cola de pilas
        int trace = 0;
        StaticQueueOfStacks queue = copyQueueOfStacks(queueOfStacks);
        int n = queueOfStacks.getN(); // Tomamos el tamaño de cada pila y la cantidad de pilas en la cola
        int i;
        int j;
        for (i = 0; i <= n - 1; i++) {
            Stack stack = queue.getFirstSk();
            if (i == 0) {// Para la primer pila de la cola
                for (j = 0; j < n - 1; j++) {
                    stack.remove();
                }
                trace += stack.getTop();
            }
            queue.removeStack();
            if (i > 0 && i < n - 1) { // Para las pilas entre la primera y la última
                int nRemover = (n - 1) - i;
                for (j = 0; j < nRemover; j++) {
                    stack.remove();
                }
                trace += stack.getTop();
            }
            if (i == n - 1) { // Para la última pila
                trace += stack.getTop();
            }
        }
        return trace;
    }

    public static StaticQueueOfStacks calcularTraspuesta(StaticQueueOfStacks queueOfStacks) {
        StaticQueueOfStacks queueOfSk = copyQueueOfStacks(queueOfStacks);
        int n = queueOfStacks.getN(); // Tomamos el tamaño de cada pila y la cantidad de pilas en la cola
        if (queueOfSk.getSize() != n) {
            throw new RuntimeException("Cada cola debe tener exactamente " + n + " pilas.");
        }

        StaticQueueOfStacks transposedQueueOfStacks = new StaticQueueOfStacks(n); // Creo la cola de pilas traspuesta
        StaticQueue[] queAuxs = new StaticQueue[n];
        int colIndex = 0;

        for (int i = 0; i < n; i++) {
            queAuxs[i] = new StaticQueue();
        }

        while (!queueOfSk.isEmpty()) {
            Stack stack = queueOfSk.getFirstSk();
            if (stack.size() != n) {
                throw new RuntimeException("Cada pila debe tener exactamente " + n + " elementos.");
            }
            while (!stack.isEmpty()) {
                queAuxs[colIndex].add(stack.getTop());
                stack.remove();
            }
            queueOfSk.removeStack();
            colIndex++;
        }

        for (int i = 0; i <= n - 1; i++){
            StaticStack transposedStack = new StaticStack();
            for (int j = n - 1; j >= 0; j--) {
                transposedStack.add(queAuxs[j].getFirst()); // tomamos el primer elemento de cada cola auxiliar
                queAuxs[j].remove();
            }
            transposedQueueOfStacks.add(transposedStack);
        }
        return transposedQueueOfStacks;
    }

    public static StaticQueueOfStacks sumarMatrices(StaticQueueOfStacks matrix1, StaticQueueOfStacks matrix2) {
        StaticQueueOfStacks queue1 = copyQueueOfStacks(matrix1);
        StaticQueueOfStacks queue2 = copyQueueOfStacks(matrix2);
        int n = matrix1.getN();

        if (queue1.getSize() != queue2.getSize()) {
            throw new RuntimeException("Las matrices deben tener el mismo tamaño y número de pilas.");
        }

        StaticQueueOfStacks sumQueueOfStacks = new StaticQueueOfStacks(n);

        while (!queue1.isEmpty()) {
            Stack stack1 = queue1.getFirstSk();
            Stack stack2 = queue2.getFirstSk();
            if (stack1.size() != n || stack2.size() != n) {
                throw new RuntimeException("Cada pila debe tener exactamente " + n + " elementos.");
            }
            StaticStack sumStackAux = new StaticStack();
            StaticStack sumStack = new StaticStack();
            for (int i = 0; i < n; i++) {
                sumStackAux.add(stack1.getTop() + stack2.getTop());
                stack1.remove();
                stack2.remove();
            }
            while (!sumStackAux.isEmpty()) {
                sumStack.add(sumStackAux.getTop());
                sumStackAux.remove();
            }
            sumQueueOfStacks.add(sumStack);
            queue1.removeStack();
            queue2.removeStack();
        }
        return sumQueueOfStacks;
    }


    public static StaticQueueOfStacks copyQueueOfStacks(StaticQueueOfStacks qsk) {
        StaticQueueOfStacks original = new StaticQueueOfStacks(qsk.getN());
        StaticQueueOfStacks copy = new StaticQueueOfStacks(qsk.getN());

        while (!qsk.isEmpty()) {
            copy.add(qsk.getFirstSk());  // generamos una copia de la orginal y una copia auxiliar
            original.add(qsk.getFirstSk());
            qsk.removeStack();
        }
        while (!original.isEmpty()) {
            qsk.add(original.getFirstSk()); // volvemos a completar la cola original que quedo vacía
            original.removeStack();
        }

        return copy; // devolvemos una copia de la cola de pilas original
    }
}
