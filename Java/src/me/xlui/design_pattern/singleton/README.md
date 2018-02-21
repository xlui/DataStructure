# 设计模式之单例模式

五种单例模式的实现与优缺点，详细的说明在具体文件中。

## 1. [简单实现](SimpleSingleton.java)

```java
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
```

实现简单，非线程安全。

## 2. [线程安全的单例](ConcurrentSingleton.java)

```java
public class ConcurrentSingleton {
    private static ConcurrentSingleton instance = null;
    
    private ConcurrentSingleton() {}
    
    public static ConcurrentSingleton getInstance() {
        if (instance == null) {
            synchronized (ConcurrentSingleton.class) {
                if (instance == null) {
                    instance = new ConcurrentSingleton();
                }
            }
        }
        return instance;
    }
}
```

使用 **synchronized** 关键字确保线程安全。

## 3. [完全线程安全的单例模式](AbsoluteConcurrentSingleton.java)

```java
public class AbsoluteConcurrentSingleton {
    private volatile static AbsoluteConcurrentSingleton instance = null;
    
    private AbsoluteConcurrentSingleton() {}
    
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
```

使用 **volatile** 关键字阻止 JVM 的指令重排，确保不会因为不想要的优化而产生错误。

## 4. [静态内部类实现](StaticInnerClassSingleton.java)

```java
public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton() {}
    
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
        StaticInnerClassSingleton singleton1 = (StaticInnerClassSingleton)constructor.newInstance();
        StaticInnerClassSingleton singleton2 = (StaticInnerClassSingleton)constructor.newInstance();
        System.out.println(singleton1.equals(singleton2));
    }
}
```

是线程安全的单例模式，但是无法阻止利用反射重复创建实例对象。

## 5. [Enum实现](EnumSingleton.java)

```java
public enum EnumSingleton {
    INSTANCE;
}
```

利用 Enum 语法糖，不仅会禁止利用反射重复创建实例，还保证线程安全。唯一的缺点是并非是用懒加载。
