package design_pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 静态内部类实现的单例模式 —— 无法防止利用反射来重复构建对象
 * <p>
 * 1、从外部无法访问静态内部类，只有当调用 StaticInnerClassSingleton.getInstance 的时候，才能得到单例对象 instance
 * 2、instance 对象初始化的时机并不是在单例类 StaticInnerClassSingleton 被加载的时候，而是在调用 getInstance 方法，使得静态内部类 Inner
 * 被加载的时候。因此这种实现方式是利用 <strong>classloader 的加载机制</strong> 来实现懒加载，并保证构建单例的线程安全。
 */
public class StaticInnerClassSingleton {
	private StaticInnerClassSingleton() {
	}

	public static StaticInnerClassSingleton getInstance() {
		return Inner.instance;
	}

	private static class Inner {
		private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
	}

	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		System.out.println("Break this build singleton way!");
		// 获取单例类的构造器
		Constructor constructor = StaticInnerClassSingleton.class.getDeclaredConstructor();
		// 设置构造器为可访问
		constructor.setAccessible(true);
		// 使用 newInstance 方法构造对象
		StaticInnerClassSingleton singleton1 = (StaticInnerClassSingleton) constructor.newInstance();
		StaticInnerClassSingleton singleton2 = (StaticInnerClassSingleton) constructor.newInstance();
		System.out.println(singleton1.equals(singleton2));
	}
}
