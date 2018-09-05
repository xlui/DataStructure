package question;

class Singleton1 {
	private static Singleton1 instance = null;

	private Singleton1() {
	}

	public static Singleton1 getInstance() {
		if (instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}
}

class Singleton2 {
	private static Singleton2 instance;

	private Singleton2() {
	}

	public static Singleton2 getInstance() {
		synchronized (Singleton2.class) {
			if (instance == null) {
				instance = new Singleton2();
			}
			return instance;
		}
	}
}

class Singleton3 {
	private static volatile Singleton3 instance;

	private Singleton3() {
	}

	public static Singleton3 getInstance() {
		if (instance == null) {
			synchronized (Singleton3.class) {
				if (instance == null) {
					instance = new Singleton3();
				}
			}
		}
		return instance;
	}
}

class Singleton4 {
	private static Singleton4 instance = new Singleton4();

	private Singleton4() {
	}

	public static Singleton4 getInstance() {
		return instance;
	}
}

public class Singleton {
	private Singleton() {
	}

	public static Singleton getInstance() {
		return Inner.instance;
	}

	private static class Inner {
		static Singleton instance = new Singleton();
	}
}

enum Singleton5 {
	Instance;
	public Singleton5 getInstance() {
		return Instance;
	}
}