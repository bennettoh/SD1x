package week2;

public class Counter {
    int count = 0;
    public int increment() {
	count += 1;
	return count;
    }
    public int decrement() {
	count -= 1;
	return count;
    }
    public int getCount() {
	return count;
    }
}