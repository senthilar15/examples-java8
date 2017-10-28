package test.examples;

@FunctionalInterface
public interface ColorTransformer<X, Y, T, Z> {
	
	Z transform(X x, Y y, T c);

}
