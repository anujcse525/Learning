package com.anuj.inmemory;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

class DataNode {
	String key;
	String value;
	DataNode prev;
	DataNode next;

	public DataNode(String key, String value) {
		this.key = key;
		this.value = value;
		this.prev = null;
		this.next = null;
	}

	@Override
	public String toString() {
		return "DataNode [key=" + key + ", value=" + value + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataNode other = (DataNode) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		return true;
	}

}

class LRUMultiThread implements Runnable {

	LRUCache lruCache = null;
	String threadName = null;

	public LRUMultiThread(LRUCache lruCache, String name) {
		this.lruCache = lruCache;
		this.threadName = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			lruCache.add(threadName + " - " + i, threadName + "-value");
		}
		lruCache.printList();
	}

}

public class LRUCache {

	ConcurrentHashMap<String, DataNode> lruMap = new ConcurrentHashMap<String, DataNode>();
	LinkedList<DataNode> list = new LinkedList<DataNode>();
	DataNode front, rear;
	int MAX_LENGTH = 5;

	public synchronized void add(String key, String value) {
		DataNode node = new DataNode(key, value);

		if (front == null) {
			front = rear = node;
			lruMap.put(key, node);
			return;
		}

		if (lruMap.containsKey(key)) {
			DataNode temp = lruMap.get(key);
			deleteFromList(temp);
			addInFront(node);
			lruMap.put(key, node);
			return;
		}

		if (lruMap.size() >= MAX_LENGTH) {
			DataNode temp = rear.next;
			temp.prev = null;
			lruMap.remove(rear.key);
			rear = temp;
			addInFront(node);
			lruMap.put(key, node);
			return;
		}

		lruMap.put(key, node);
		addInFront(node);
	}

	public synchronized void get(String key) {
		if (lruMap.containsKey(key)) {
			DataNode node = lruMap.get(key);
			deleteFromList(node);
			addInFront(node);
		}
	}

	public synchronized void deleteFromList(DataNode node) {
		DataNode temp = front, prev = null;
		while (temp != node) {
			prev = temp;
			temp = temp.prev;
		}
		if (temp == rear) {
			prev.prev = null;
			rear = prev;
			return;
		}
		temp.prev.next = temp.next;
		prev.prev = temp.prev;
	}

	public synchronized void addInFront(DataNode node) {
		if (front == null) {
			front = rear = node;
			return;
		}
		node.prev = front;
		front.next = node;
		front = node;
	}

	public synchronized void printList() {
		DataNode temp = front;
		System.out.println("\n<-----");
		while (temp != null) {
			System.out.println(temp);
			temp = temp.prev;
		}
		System.out.println("----->\n");
	}

	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache();
		Thread th = new Thread(new LRUMultiThread(lruCache, "First"));
		Thread th1 = new Thread(new LRUMultiThread(lruCache, "Second"));
		Thread th2 = new Thread(new LRUMultiThread(lruCache, "Third"));
		th.start();
		th1.start();
		th2.start();
		/*
		 * lruCache.add("abc", "xyz"); lruCache.add("bcd", "wxy");
		 * lruCache.add("cde", "vwx"); lruCache.add("def", "uvw");
		 * lruCache.get("abc"); lruCache.add("efg", "tuv"); lruCache.add("fgh",
		 * "stu"); lruCache.add("ghi", "rst"); lruCache.add("ijk", "qrs");
		 */
		try {
			th1.join();
			th2.join();
			th.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lruCache.printList();
	}

}
