package effectivejava.chapter12.item87;
import java.io.*;

// StringList with a reasonable custom serialized form  - Page 349
public final class StringList implements Serializable {
    private transient int size   = 0;
    private transient Entry head = null;

    // No longer Serializable!
    private record Entry(String data, Entry next) {
    }

    // Appends the specified string to the list
    public void add(String s) {
        head = new Entry(s, head);
    }

    /**
     * Serialize this {@code StringList} instance.
     *
     * @serialData The size of the list (the number of strings
     * it contains) is emitted ({@code int}), followed by all of
     * its elements (each a {@code String}), in the proper
     * sequence.
     */
    private void writeObject(ObjectOutputStream s)
            throws IOException {
        s.defaultWriteObject();
        s.writeInt(size);

        // Write out all elements in the proper order.
        for (var entry = head; entry != null; entry = entry.next)
            s.writeObject(entry.data);
    }

    private void readObject(ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        var numElements = s.readInt();

        // Read in all elements and insert them in list
        for (var i = 0; i < numElements; i++)
            add((String) s.readObject());
    }

    // Remainder omitted
}
