@FunctionalInterface
public interface KiteFunction<T, S, R> {
    R run(T t, S s);
}
