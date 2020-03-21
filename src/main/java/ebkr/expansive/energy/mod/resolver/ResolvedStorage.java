package ebkr.expansive.energy.mod.resolver;

import java.util.HashMap;

public class ResolvedStorage<T> {

    private static HashMap<String, Object> storage = new HashMap<>();

    public T get(Class clazz) {
        return (T) storage.get(clazz.getName());
    }

    public void set(Class clazz, T object) {
        if (!storage.containsKey(clazz.getName())) {
            storage.put(clazz.getName(), object);
        }
    }

}
