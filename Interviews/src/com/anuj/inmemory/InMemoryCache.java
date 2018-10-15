package com.anuj.inmemory;

import java.lang.ref.SoftReference;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryCache implements Cache {

	private static final int CLEAN_UP_PERIOD_IN_SEC = 5;

	private final ConcurrentHashMap<String, SoftReference<CacheObject>> cache = new ConcurrentHashMap<>();

	public InMemoryCache() {
		Thread cleanerThread = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				try {
					Thread.sleep(CLEAN_UP_PERIOD_IN_SEC * 1000);
					cache.entrySet().removeIf(entry -> Optional.ofNullable(entry.getValue()).map(SoftReference::get)
							.map(CacheObject::isExpired).orElse(false));
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});
		cleanerThread.setDaemon(true);
		cleanerThread.start();
	}

	@Override
	public void add(String key, Object value, long periodInMillis) {
		if (key == null) {
			return;
		}
		if (value == null) {
			cache.remove(key);
		} else {
			long expiryTime = System.currentTimeMillis() + periodInMillis;
			cache.put(key, new SoftReference<>(new CacheObject(value, expiryTime)));
		}
	}

	@Override
	public void remove(String key) {
		cache.remove(key);
	}

	@Override
	public Object get(String key) {
		return Optional.ofNullable(cache.get(key)).map(SoftReference::get)
				.filter(cacheObject -> !cacheObject.isExpired()).map(CacheObject::getValue).orElse(null);
	}

	@Override
	public void clear() {
		cache.clear();
	}

	@Override
	public long size() {
		return cache.entrySet().stream().filter(entry -> Optional.ofNullable(entry.getValue()).map(SoftReference::get)
				.map(cacheObject -> !cacheObject.isExpired()).orElse(false)).count();
	}

	private static class CacheObject {

		private Object value;
		private long expiryTime;

		public CacheObject(Object value, long expiryTime) {
			super();
			this.value = value;
			this.expiryTime = expiryTime;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public long getExpiryTime() {
			return expiryTime;
		}

		public void setExpiryTime(long expiryTime) {
			this.expiryTime = expiryTime;
		}

		boolean isExpired() {
			return System.currentTimeMillis() > expiryTime;
		}
	}

	public static void main(String[] args) {
		// while (true) {
		CopyOnWriteArrayList al = new CopyOnWriteArrayList<>();
		InMemoryCache inCache = new InMemoryCache();
		inCache.add("one", new CacheObject("Anuj", 200L), 200L);
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(inCache.cache.get("one"));
		}
		// }
	}
}