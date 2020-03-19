package main.reader;

@FunctionalInterface
public interface Caster<T> {
	T cast(String x);
}
