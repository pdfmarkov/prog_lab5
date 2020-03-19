package main.reader;

@FunctionalInterface
public interface Condition<T> {
	boolean check(String x);
}
