package design_pattern.creational.singleton;

/**
 * SimpleSingleton 不是线程安全的单例模式，可能存在两个线程创建两个实例的情况。
 * ConcurrentSingleton 在创建实例前使用 synchronized 关键字，锁住整个类（注意，这里不能使用对象锁）。
 * <p>
 * 进入 synchronized 临界区以后，还要再做一次判空。因为当两个线程同时访问的时候，线程 A 构建完对象，线程 B 也已经通过了最初的判空验证，
 * 不做第二次判空的话，线程 B 还是会再次构建 instance 对象。
 * <p>
 * 这种两次判空的机制叫做 双重检测机制。
 */
public class ConcurrentSingleton {
	private static ConcurrentSingleton instance = null;

	private ConcurrentSingleton() {
	}

	public static ConcurrentSingleton getInstance() {
		if (instance == null) {
			synchronized (ConcurrentSingleton.class) {
				// 注意，要锁住整个类
				if (instance == null) {
					instance = new ConcurrentSingleton();
				}
			}
		}
		return instance;
	}
}
