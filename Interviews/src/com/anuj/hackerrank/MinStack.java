package com.anuj.hackerrank;

class Elem {
	public int value;
	public int min;
	public Elem next;

	public Elem(int value, int min) {
		this.value = value;
		this.min = min;
	}

	@Override
	public String toString() {
		return "Elem [value=" + value + ", min=" + min + ", next=" + next + "]";
	}

}

public class MinStack {
	public Elem top;

	/** initialize your data structure here. */
	public MinStack() {

	}

	public void push(int x) {
		if (top == null) {
			top = new Elem(x, x);
		} else {
			Elem e = new Elem(x, Math.min(x, top.min));
			e.next = top;
			top = e;
		}

	}

	public void pop() {
		if (top == null)
			return;
		Elem temp = top.next;
		top.next = null;
		top = temp;

	}

	public int top() {
		if (top == null)
			return -1;
		return top.value;
	}

	public int getMin() {
		if (top == null)
			return -1;
		return top.min;
	}

	@Override
	public String toString() {
		return "MinStack [top=" + top + "]";
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 3, 2, 3, 1, 1, 3 };
		MinStack minStack = new MinStack();

		for (int i = 0; i < arr.length - 1;) {
			if (arr[i] == 1) {
				minStack.push(arr[++i]);
			} else if (arr[i] == 2) {
				minStack.pop();
			} else if (arr[i] == 3) {
				System.out.println(minStack.getMin());
			}
			i++;
			System.out.println(minStack);
		}
	}
}
