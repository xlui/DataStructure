package design_pattern.singleton;

/**
 * SimpleSingleton，单例模式的简单实现 —— 非线程安全
 * <p>
 * 1、将 SimpleSingleton 的构造方法设为私有
 * 2、instance 是 SimpleSingleton 的静态成员，也即单例对象。它的初始值可以设为 null，也可以设为 new SimpleSingleton()。
 * 3、getInstance 是获取单例对象的方法。
 * <p>
 * 如果单例初始值为 null，则访问单例对象的时候返回新对象，这是单例模式中的 “懒汉模式”
 * 如果单例对象一开始被 new SimpleSingleton() 创建，则不需要判断是否为 null，这是 “饿汉模式”
 */
public class SimpleSingleton {
	private static SimpleSingleton instance = null;

	private SimpleSingleton() {
		super();
	}

	public static SimpleSingleton getInstance() {
		if (instance == null) {
			instance = new SimpleSingleton();
		}
		return instance;
	}
}
