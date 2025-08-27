import java.util.HashMap;
import java.util.Map;

/**
 * 环境类
 * 存储变量
 *
 * @author WanAn
 */
class Environment {
    // 对父域的引用
    final Environment enclosing;

    private final Map<String, Store> values = new HashMap<>();

    private static class Store {
        // 是否初始化
        boolean initialized;
        // 值
        Object value;

        Store(Object value, boolean initialized) {
            this.initialized = initialized;
            this.value = value;
        }
    }

    Environment() {
        this.enclosing = null;
    }

    Environment(Environment enclosing) {
        this.enclosing = enclosing;
    }

    Object get(Token name) {
        if (values.containsKey(name.lexeme)) {
            Store store = values.get(name.lexeme);
            if (!store.initialized) {
                throw new RuntimeError(name, "Uninitialized variable '" + name.lexeme + "'.");
            }
            return store.value;
        }
        if (enclosing != null) {
            return enclosing.get(name);
        }
        throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");
    }

    void assign(Token name, Object value) {
        if (values.containsKey(name.lexeme)) {
            values.put(name.lexeme, new Store(value, true));
            return;
        }
        if (enclosing != null) {
            enclosing.assign(name, value);
            return;
        }
        throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");
    }

    void define(String name, Object value, boolean initialized) {
        values.put(name, new Store(value, initialized));
    }
}
