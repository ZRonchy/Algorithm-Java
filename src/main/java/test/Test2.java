package test;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by chizhang on 21/05/17.
 */
public class Test2 {

    public static void main(String[] args) {
        String initialReference = "initial value referenced";

        AtomicReference<String> atomicStringReference =
                new AtomicReference<String>(initialReference);

        String newReference = "new value referenced";
        boolean exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("exchanged: " + exchanged);

        exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("exchanged: " + exchanged);
    }
}
