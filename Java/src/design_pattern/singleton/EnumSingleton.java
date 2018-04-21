package design_pattern.singleton;

/**
 * 枚举实现的单例模式
 * <p>
 * 利用 enum 语法糖，JVM 会阻止反射获取枚举类的私有构造方法
 * 同时也会保证线程安全
 * <p>
 * 这种方式唯一的缺点是它并非使用懒加载，其单例对象实在枚举类被加载的时候进行初始化的。
 */
public enum EnumSingleton {
	INSTANCE;
}
