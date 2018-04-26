package design_pattern.creational.singleton;

/**
 * ConcurrentSingleton 实现的单例也并非完全线程安全。
 * <p>
 * 想象一种场景，当两个线程一先一后访问 getInstance 方法的时候，当线程 A 正在构建对象，B 刚刚进入方法
 * 因为 JVM 编译器存在<strong>指令重排</strong>的原因。
 * <p>
 * 比如 <code>instance = new ConcurrentSingleton()</code>，会被编译器编译成如下 JVM 指令：
 *
 * <code>
 * memory = allocate();     //1: 分配对象的内存空间
 * ctorInstance(memory);    //2: 初始化对象
 * instance = memory;       //3: 设置 instance 指向刚分配的内存地址
 * </code>
 * <p>
 * 但是这些指令的顺序并非一成不变，有时可能会经过 JVM 和 CPU 的优化，指令重排成下面的顺序：
 *
 * <code>
 * memory = allocate();     //1: 分配对象的内存空间
 * instance = memory;       //3: 设置 instance 指向刚分配的内存地址
 * ctorInstance(memory);    //2: 初始化对象
 * </code>
 * <p>
 * 当线程 A 执行完 1、3 时，instance 对象还未完成初始化，但已经不再指向 null。此时如果线程 B 抢占到 CPU 资源，执行
 * <code>if (instance == null)</code> 的结果会是 false，从而返回一个没有初始化完成的 instance 对象！
 * <p>
 * 为了避免这一情况，我们需要在 instance 对象前增加一个修饰符 volatile
 *
 * <strong>volatile 修饰符阻止了变量访问前后的指令重排，保证了指令的执行顺序。</strong>
 * <p>
 * 经过 volatile 的修饰，当线程 A 执行 <code>instance = new AbsoluteConcurrentSingleton();</code> 的时候，JVM 的执行顺序始终保持下面的顺序：
 *
 * <code>
 * memory = allocate();     //1: 分配对象的内存空间
 * ctorInstance(memory);    //2: 初始化对象
 * instance = memory;       //3: 设置 instance 指向刚分配的内存地址
 * </code>
 */
public class AbsoluteConcurrentSingleton {
	private volatile static AbsoluteConcurrentSingleton instance = null;

	private AbsoluteConcurrentSingleton() {
	}

	public static AbsoluteConcurrentSingleton getInstance() {
		if (instance == null) {
			synchronized (AbsoluteConcurrentSingleton.class) {
				if (instance == null) {
					instance = new AbsoluteConcurrentSingleton();
				}
			}
		}
		return instance;
	}
}
