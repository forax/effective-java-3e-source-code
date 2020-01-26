package effectivejava.chapter11.item79;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Simple test of ObservableSet - Page 319
public class Test3 {
    public static void main(String[] args) {
        var set =
                new ObservableSet<>(new HashSet<Integer>());

// Observer that uses a background thread needlessly
        set.addObserver(new SetObserver<>() {
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if (e == 23) {
                    var exec = Executors.newSingleThreadExecutor();
                    try {
                        exec.submit(() -> s.removeObserver(this)).get();
                    } catch (ExecutionException | InterruptedException ex) {
                        throw new AssertionError(ex);
                    } finally {
                        exec.shutdown();
                    }
                }
            }
        });

        for (var i = 0; i < 100; i++)
            set.add(i);
    }
}