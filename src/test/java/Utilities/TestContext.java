package Utilities;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
    // Senaryo boyunca üretilen verileri Key-Value olarak tutar
    private final Map<String, Object> context = new HashMap<>();

    public void set(String key, Object value) {
        context.put(key, value);
    }

    public Object get(String key) {
        return context.get(key);
    }

    public <T> T get(String key, Class<T> clazz) {
        return clazz.cast(context.get(key));
    }

    public boolean contains(String key) {
        return context.containsKey(key);
    }
}
