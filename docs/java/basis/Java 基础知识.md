# 1.Java 基本功

## 1.1 Java 入门

### 1.1.1 Java语言有哪些特点

* 简单易学
* 面向对象
* 平台无关
* 可靠、安全、多线程
* 网络编程

### 1.1.2  JVM 、JDK和JRE

* JVM ： Java虚拟机，是运行Java字节码的机器。
* JDK ： JDK 是 Java Development Kit 缩写，它是功能齐全的 Java SDK。它拥有 JRE 所拥有的一切，还有编译器（javac）和工具（如 javadoc 和 jdb）。它能够创建和编译程序。 
* JRE ： JRE 是 Java 运行时环境。它是运行已编译 Java 程序所需的所有内容的集合，包括 Java 虚拟机（JVM），Java 类库，java 命令和其他的一些基础构件。但是，它不能用于创建新程序。 

### 1.1.3 为什么Java语言“编译与解释并存”

 Java 语言既具有编译型语言的特征，也具有解释型语言的特征，因为 Java 程序要经过先编译，后解释两个步骤，由 Java 编写的程序需要先经过编译步骤，生成字节码（*.class 文件），这种字节码必须由 Java 解释器来解释执行。因此，我们可以认为 Java 语言编译与解释并存。 

## 1.2 Java 语法

### 1.2.1 Java繁星了解吗？什么是类型檫除？介绍一下常用的通配符？

* **Java泛型是JDK 5 中引入的一个新特性**，泛型提供了编译时类型安全检测机制，该机制允许程序员在编译时检测到非法的类型。**泛型的本质是参数化类型，也就是所操作的数据类型被指定为一个参数。**
* **Java的泛型是一个伪泛型，这是因为Java在编译期间，所有的泛型信息都会被檫除，这也就是通常所说的类型檫除。**
* 泛型一般有三种使用方式：**泛型类、泛型方法、泛型接口**

* **常用的通配符：T、E、K、V、？**
  * ？ 表示不确定的 java 类型
  * T (type) 表示具体的一个 java 类型
  * K V (key value) 分别代表 java 键值中的 Key Value
  * E (element) 代表 Element

### 1.2.2 == 和 equals 的区别

* **==：**判断两个对象的地址是否相同。即判断两个对象是不是同一个对象。**（基本数据类型比较的是值，引用数据类型比较的是内存地址）**

  >  因为 Java 只有值传递，所以，对于 == 来说，不管是比较基本数据类型，还是引用数据类型的变量，其本质比较的都是值，只是引用类型变量存的值是对象的地址。 

* equals() :他的作用也是判断两个对象是否相等，他不能比较基本数据类型的变量。

* `equals()` 方法存在两种使用情况：

  - 情况 1：类没有覆盖 `equals()`方法。则通过`equals()`比较该类的两个对象时，等价于通过“==”比较这两个对象。使用的默认是 `Object`类`equals()`方法。
  - 情况 2：类覆盖了 `equals()`方法。一般，我们都覆盖 `equals()`方法来两个对象的内容相等；若它们的内容相等，则返回 true(即，认为这两个对象相等)。

**说明：**

- `String` 中的 `equals` 方法是被重写过的，因为 `Object` 的 `equals` 方法是比较的对象的内存地址，而 `String` 的 `equals` 方法比较的是对象的值。
- 当创建 `String` 类型的对象时，**虚拟机会在常量池中查找**有没有已经存在的值和要创建的值相同的对象，如果有就把它赋给当前引用。如果没有就在**常量池中**重新创建一个 `String` 对象。

### 1.2.3 hashCode() 与 equals()

* **hashCode()介绍**

  hashCode（）的作用是获取哈希码，也称为散列码；它实际上是返回一个int整数。这个哈希码的作用是**确定该对象在哈希表中的索引位置**。

   **`Object` 的 hashcode 方法是本地方法**，也就是用 c 语言或 c++ 实现的，该方法通常用来将对象的 内存地址 转换为整数之后返回。 

*  **为什么要有 hashCode？** 

  我们以“`HashSet` 如何检查重复”为例子来说明为什么要有 hashCode？

  当你把对象加入 `HashSet` 时，`HashSet` 会先计算对象的 hashcode 值来判断对象加入的位置，同时也会与其他已经加入的对象的 hashcode 值作比较，如果没有相符的 hashcode，`HashSet` 会假设对象没有重复出现。但是如果发现有相同 hashcode 值的对象，这时会调用 `equals()` 方法来检查 hashcode 相等的对象是否真的相同。如果两者相同，`HashSet` 就不会让其加入操作成功。如果不同的话，就会重新散列到其他位置。（摘自我的 Java 启蒙书《Head First Java》第二版）。这样我们就大大减少了 equals 的次数，相应就大大提高了执行速度。

* **为什么重写 `equals` 时必须重写 `hashCode` 方法？**

  如果两个对象相等，则 hashcode 一定也是相同的。两个对象相等,对两个对象分别调用 equals 方法都返回 true。但是，两个对象有相同的 hashcode 值，它们也不一定是相等的 。**因此，equals 方法被覆盖过，则 `hashCode` 方法也必须被覆盖。**

* **为什么两个对象有相同的 hashcode 值，它们也不一定是相等的？**

  在这里解释一位小伙伴的问题。以下内容摘自《Head Fisrt Java》。

  因为 `hashCode()` 所使用的杂凑算法也许刚好会让多个对象传回相同的杂凑值。越糟糕的杂凑算法越容易碰撞，但这也与数据值域分布的特性有关（所谓碰撞也就是指的是不同的对象得到相同的 `hashCode`。

  我们刚刚也提到了 `HashSet`,如果 `HashSet` 在对比的时候，同样的 hashcode 有多个对象，它会使用 `equals()` 来判断是否真的相同。也就是说 `hashcode` 只是用来缩小查找成本。

  更多关于 `hashcode()` 和 `equals()` 的内容可以查看：[Java hashCode() 和 equals()的若干问题解答](https://www.cnblogs.com/skywang12345/p/3324958.html)



## 1.3 基本数据类型

### 1.3.1 Java中的几种基本数据类型是什么？对应的包装类型是什么？各占多少字节呢？

* Java**中**有 8 种基本数据类型，分别为：

1. 6 种数字类型 ：byte、short、int、long、float、double
2. 1 种字符类型：char
3. 1 种布尔型：boolean。

*  这八种基本类型都有对应的包装类分别为：Byte、Short、Integer、Long、Float、Double、Character、Boolean 

| 基本类型 | 位数 | 字节 | 默认值  |
| -------- | ---- | ---- | ------- |
| int      | 32   | 4    | 0       |
| short    | 16   | 2    | 0       |
| long     | 64   | 8    | 0L      |
| byte     | 8    | 1    | 0       |
| char     | 16   | 2    | 'u0000' |
| float    | 32   | 4    | 0f      |
| double   | 64   | 8    | 0d      |
| boolean  | 1    |      | false   |

### 1.3.2 自动装箱和拆箱

- **装箱**：将基本类型用它们对应的引用类型包装起来；
- **拆箱**：将包装类型转换为基本数据类型；

更多内容见：[深入剖析 Java 中的装箱和拆箱](https://www.cnblogs.com/dolphin0520/p/3780005.html)

### 1.3.3 8中基本数据类型的包装类和常量池

 **Java 基本类型的包装类的大部分都实现了常量池技术，即 Byte,Short,Integer,Long,Character,Boolean；前面 4 种包装类默认创建了数值[-128，127] 的相应类型的缓存数据，Character 创建了数值在[0,127]范围的缓存数据，Boolean 直接返回 True Or False。如果超出对应范围仍然会去创建新的对象。** 为啥把缓存设置为[-128，127]区间？（[参见 issue/461](https://github.com/Snailclimb/JavaGuide/issues/461)）性能和资源之间的权衡。 

## 1.4. 方法（函数）

### 1.4.1 Java的四种引用类型

[参考](https://www.cnblogs.com/liyutian/p/9690974.html)

> Java 中的垃圾回收机制在判断是否回收某个对象的时候，都需要依据“引用”这个概念。
> 在不同垃圾回收算法中，对引用的判断方式有所不同：
>
> - 引用计数法：为每个对象添加一个引用计数器，每当有一个引用指向它时，计数器就加1，当引用失效时，计数器就减1，当计数器为0时，则认为该对象可以被回收（目前在Java中已经弃用这种方式了）。
> - 可达性分析算法：从一个被称为 GC Roots 的对象开始向下搜索，如果一个对象到GC Roots没有任何引用链相连时，则说明此对象不可用。
>
> JDK1.2 之前，一个对象只有“已被引用”和"未被引用"两种状态，这将无法描述某些特殊情况下的对象，比如，当内存充足时需要保留，而内存紧张时才需要被抛弃的一类对象。

>  所以在 JDK.1.2 之后，Java 对引用的概念进行了扩充，将引用分为了：**强引用（Strong Reference）、软引用（Soft Reference）、弱引用（Weak Reference）、虚引用（Phantom Reference）**4 种，这 4 种引用的强度依次减弱。 

* **强引用：**

   Java中默认声明的就是强引用，比如：

  ```java
  Object obj = new Object(); //只要obj还指向Object对象，Object对象就不会被回收
  obj = null;  //手动置null
  ```

   只要强引用存在，垃圾回收器将永远不会回收被引用的对象，哪怕内存不足时，JVM也会直接抛出OutOfMemoryError，不会去回收。**如果想中断强引用与对象之间的联系，可以显示的将强引用赋值为null**，这样一来，JVM就可以适时的回收对象了 

* **软引用：**

   **如果一个对象只具有软引用，则内存空间足够，垃圾回收器就不会回收它；如果内存空间不足了，就会回收这些对象的内存。**只要垃圾回收器没有回收它，该对象就可以被程序使用。

   在 JDK1.2 之后，用java.lang.ref.SoftReference类来表示软引用。 

* **弱引用：** 

  弱引用的引用强度比软引用要更弱一些，**无论内存是否足够，只要 JVM 开始进行垃圾回收，那些被弱引用关联的对象都会被回收**。在 JDK1.2 之后，用 java.lang.ref.WeakReference 来表示弱引用。 

* **虚引用：**

  虚引用是最弱的一种引用关系，如果一个对象仅持有虚引用，那么它就和没有任何引用一样，它随时可能会被回收，在 JDK1.2 之后，用 PhantomReference 类来表示，通过查看这个类的源码，发现它只有一个构造函数和一个 get() 方法，而且它的 get() 方法仅仅是返回一个null，也就是说将永远无法通过虚引用来获取对象，虚引用必须要和 ReferenceQueue 引用队列一起使用。 

* **引用队列（ReferenceQueue）：**

  引用队列可以与软引用、弱引用以及虚引用一起配合使用，当垃圾回收器准备回收一个对象时，如果发现它还有引用，那么就会在回收对象之前，把这个引用加入到与之关联的引用队列中去。程序可以通过判断引用队列中是否已经加入了引用，来判断被引用的对象是否将要被垃圾回收，这样就可以在对象被回收之前采取一些必要的措施。

  与软引用、弱引用不同，虚引用必须和引用队列一起使用。

### 1.4.2 为什么Java中只有值传递

首先回顾一下在程序设计语言中有关将参数传递给方法（或函数）的一些专业术语。**按值调用(call by value)表示方法接收的是调用者提供的值，而按引用调用（call by reference)表示方法接收的是调用者提供的变量地址。一个方法可以修改传递引用所对应的变量值，而不能修改传递值调用所对应的变量值。** 它用来描述各种程序设计语言（不只是 Java)中方法参数传递方式。

**Java 程序设计语言总是采用按值调用。也就是说，方法得到的是所有参数值的一个拷贝，也就是说，方法不能修改传递给它的任何参数变量的内容。**  **（重点）**

### 1.4.3 重载和重写

* **重载：** 发生在同一个类中（或者父类和子类之间），方法名必须相同，参数类型不同、个数不同、顺序不同，方法返回值和访问修饰符可以不同。 
* **重写：** 重写发生在**运行期**，是**子类对父类**的**允许方法**的实现过程进行重新编写。
  * 返回值类型、方法名、参数列表必须相同，抛出的异常范围小于等于父类，访问修饰符范围大于等于父类。
  * 如果父类方法访问修饰符为 `private/final/static` 则子类就不能重写该方法，但是被 static 修饰的方法能够被再次声明。
  * 构造方法无法被重写

### 1.4.4 深拷贝 vs 浅拷贝

* **深拷贝：** 对基本数据类型进行值传递，对引用数据类型，创建一个新的对象，并复制其内容。

* **浅拷贝：**对基本数据类型进行值传递，对引用数据类型进行引用传递。

  ![](https://my-blog-to-use.oss-cn-beijing.aliyuncs.com/2019-7/java-deep-and-shallow-copy.jpg)

# 2. Java面向对象

## 2.1 类和对象

### 2.1.1 成员变量和局部变量的区别？

* **从语法形式上：**成员变量属于类，局部变量属于方法、代码块。
* **从修饰符上：** 成员变量可以被public、private和static等修饰符修饰，而局部变量不可以。
* **从内存存储上：** 成员变量使用static修饰，这个成员变量属于类；没有用static修饰，这个成员变量属于实例。而对象存在于堆内存中，局部变量存在于栈内存中。
* **从变量在内存中的生存时间上看:**成员变量是对象的一部分，它随着对象的创建而存在，而局部变量随着方法的调用而自动消失。
* **从默认值上：**成员变量如果没有被赋初值，则会自动以类型的默认值而赋值（一种情况例外:被 final 修饰的成员变量也必须显式地赋值），而局部变量则不会自动赋值。

## 2.2 面向对象的三大特征

> 封装、继承和多态

## 2.3 修饰符

* 在一个静态方法内调用一个非静态成员为什么是非法的？
* 静态方法和实例方法有何不同？

## 2.4 其他知识

### 2.4.1 String、StringBuffer、StringBuilder的区别是什么？String 为什么是不可变的？

* **可变性：**
  * String 类中使用final关键字修饰字符数组，所以是不可变的。
  * StringBuffer、StringBuilder都继承自AbstractStringBuilder类，未使用final关键字修饰字符数组，因此是可变的。
* **线程安全性：**
  * String：对象是不可变的因此线程安全
  * StringBuffer：对方法加了同步锁，线程安全
  * StringBuilder：未加同步锁，线程不安全

### 2.4.2 Object类的常见方法总结

```Java

public final native Class<?> getClass()//native方法，用于返回当前运行时对象的Class对象，使用了final关键字修饰，故不允许子类重写。

public native int hashCode() //native方法，用于返回对象的哈希码，主要使用在哈希表中，比如JDK中的HashMap。
public boolean equals(Object obj)//用于比较2个对象的内存地址是否相等，String类对该方法进行了重写用户比较字符串的值是否相等。

protected native Object clone() throws CloneNotSupportedException//naitive方法，用于创建并返回当前对象的一份拷贝。一般情况下，对于任何对象 x，表达式 x.clone() != x 为true，x.clone().getClass() == x.getClass() 为true。Object本身没有实现Cloneable接口，所以不重写clone方法并且进行调用的话会发生CloneNotSupportedException异常。

public String toString()//返回类的名字@实例的哈希码的16进制的字符串。建议Object所有的子类都重写这个方法。

public final native void notify()//native方法，并且不能重写。唤醒一个在此对象监视器上等待的线程(监视器相当于就是锁的概念)。如果有多个线程在等待只会任意唤醒一个。

public final native void notifyAll()//native方法，并且不能重写。跟notify一样，唯一的区别就是会唤醒在此对象监视器上等待的所有线程，而不是一个线程。

public final native void wait(long timeout) throws InterruptedException//native方法，并且不能重写。暂停线程的执行。注意：sleep方法没有释放锁，而wait方法释放了锁 。timeout是等待时间。

public final void wait(long timeout, int nanos) throws InterruptedException//多了nanos参数，这个参数表示额外时间（以毫微秒为单位，范围是 0-999999）。 所以超时的时间还需要加上nanos毫秒。

public final void wait() throws InterruptedException//跟之前的2个wait方法一样，只不过该方法一直等待，没有超时时间这个概念

protected void finalize() throws Throwable { }//实例被垃圾回收器回收的时候触发的操作

```

### 2.4.3Java序列化如果有些字段不想进行序列化，怎么办？

对于不想进行序列化的变量，使用 transient 关键字修饰。

transient 关键字的作用是：阻止实例中那些用此关键字修饰的的变量序列化；当对象被反序列化时，被 transient 修饰的变量值不会被持久化和恢复。transient 只能修饰变量，不能修饰类和方法。



# 3.Java核心技术

## 3.1 反射机制

### 3.1.1 何为反射

反射是框架设计的灵魂，通过反射可以获得一个类中所有的属性和方法，并可以调用这些属性和方法。

### 3.1.2 反射的优缺点

* 优点： 可以让代码更加灵活
* 缺点： 反射的性能较差



### 3.1.3 反射的应用场景

*  Spring/Springboot/Mybatis框架中

* JDK 动态代理：

  ```java
  public class DebugInvocationHandler implements InvocationHandler {
      /**
       * 代理类中的真实对象
       */
      private final Object target;
  
      public DebugInvocationHandler(Object target) {
          this.target = target;
      }
  
  
      public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
          System.out.println("before method " + method.getName());
          Object result = method.invoke(target, args);
          System.out.println("after method " + method.getName());
          return result;
      }
  }
  
  ```

* Spring中的注解 ` @Component `等

## 3.2 异常

### 3.2.1 Java异常类层次结构图

![](https://guide-blog-images.oss-cn-shenzhen.aliyuncs.com/2020-12/Java%E5%BC%82%E5%B8%B8%E7%B1%BB%E5%B1%82%E6%AC%A1%E7%BB%93%E6%9E%84%E5%9B%BE.png)

在 Java 中，所有的异常都有一个共同的祖先 `java.lang` 包中的 `Throwable` 类。`Throwable` 类有两个重要的子类 `Exception`（异常）和 `Error`（错误）。`Exception` 能被程序本身处理(`try-catch`)， `Error` 是无法处理的(只能尽量避免)。

`Exception` 和 `Error` 二者都是 Java 异常处理的重要子类，各自都包含大量子类。

- **`Exception`** :程序本身可以处理的异常，可以通过 `catch` 来进行捕获。`Exception` 又可以分为 受检查异常(必须处理) 和 不受检查异常(可以不处理)。
- **`Error`** ：`Error` 属于程序无法处理的错误 ，我们没办法通过 `catch` 来进行捕获 。例如，Java 虚拟机运行错误（`Virtual MachineError`）、虚拟机内存不够错误(`OutOfMemoryError`)、类定义错误（`NoClassDefFoundError`）等 。这些异常发生时，Java 虚拟机（JVM）一般会选择线程终止。

### 3.2.2 Throwable 类的常用方法

- **`public string getMessage()`**:返回异常发生时的简要描述
- **`public string toString()`**:返回异常发生时的详细信息
- **`public string getLocalizedMessage()`**:返回异常对象的本地化信息。使用 `Throwable` 的子类覆盖这个方法，可以生成本地化信息。如果子类没有覆盖该方法，则该方法返回的信息与 `getMessage（）`返回的结果相同
- **`public void printStackTrace()`**:在控制台上打印 `Throwable` 对象封装的异常信息

### 3.2.3 try-catch-finally

- **`try`块：** 用于捕获异常。其后可接零个或多个 `catch` 块，如果没有 `catch` 块，则必须跟一个 `finally` 块。
- **`catch`块：** 用于处理 try 捕获到的异常。
- **`finally` 块：** 无论是否捕获或处理异常，`finally` 块里的语句都会被执行。当在 `try` 块或 `catch` 块中遇到 `return` 语句时，`finally` 语句块将在方法返回之前被执行。

### 3.2.4 有用过try-with-resources吗？

1. **适用范围（资源的定义）：** 任何实现 `java.lang.AutoCloseable`或者 `java.io.Closeable` 的对象
2. **关闭资源和 final 的执行顺序：** 在 `try-with-resources` 语句中，任何 catch 或 finally 块在声明的资源关闭后运行

>  面对必须要关闭的资源，我们总是应该优先使用 `try-with-resources` 而不是`try-finally`。随之产生的代码更简短，更清晰，产生的异常对我们也更有用。`try-with-resources`语句让我们更容易编写必须要关闭的资源的代码，若采用`try-finally`则几乎做不到这点。 

* 样例：

```java
try (Scanner scanner = new Scanner(new File("test.txt"))) {
    while (scanner.hasNext()) {
        System.out.println(scanner.nextLine());
    }
} catch (FileNotFoundException fnfe) {
    fnfe.printStackTrace();
}

```

## 3.3 多线程

### 3.3.1 线程、程序和进程的基本概念

*  **线程**与进程相似，但线程是一个比进程更小的执行单位。一个进程在其执行的过程中可以产生多个线程。与进程不同的是同类的多个线程共享同一块内存空间和一组系统资源，所以系统在产生一个线程，或是在各个线程之间作切换工作时，负担要比进程小得多，也正因为如此，线程也被称为轻量级进程。 

*  **程序**是含有指令和数据的文件，被存储在磁盘或其他的数据存储设备中，也就是说程序是静态的代码。 
*  **进程**是程序的一次执行过程，是系统运行程序的基本单位，因此进程是动态的。系统运行一个程序即是一个进程从创建，运行到消亡的过程。 

### 3.3.2 线程有哪些基本状态

* 初始、运行、阻塞、等待、超时等待、终止

  ![](https://my-blog-to-use.oss-cn-beijing.aliyuncs.com/19-1-29/Java%E7%BA%BF%E7%A8%8B%E7%9A%84%E7%8A%B6%E6%80%81.png)

![]() ![Java线程状态变迁](https://my-blog-to-use.oss-cn-beijing.aliyuncs.com/19-1-29/Java%20%E7%BA%BF%E7%A8%8B%E7%8A%B6%E6%80%81%E5%8F%98%E8%BF%81.png) 

## 3.4 文件和IO流

### 3.4.1 Java中的io流分几种？

- 按照流的流向分，可以分为输入流和输出流；
- 按照操作单元划分，可以划分为字节流和字符流；
- 按照流的角色划分为节点流和处理流。

 按操作方式分类结构图： 

![](https://my-blog-to-use.oss-cn-beijing.aliyuncs.com/2019-6/IO-%E6%93%8D%E4%BD%9C%E6%96%B9%E5%BC%8F%E5%88%86%E7%B1%BB.png)

 按操作对象分类结构图： 

![](https://my-blog-to-use.oss-cn-beijing.aliyuncs.com/2019-6/IO-%E6%93%8D%E4%BD%9C%E5%AF%B9%E8%B1%A1%E5%88%86%E7%B1%BB.png)

### 3.4.2 BIO、NIO、AIO有什么区别？

- **BIO (Blocking I/O):** **同步阻塞 I/O 模式**，数据的读取写入必须阻塞在一个线程内等待其完成。在活动连接数不是特别高（小于单机 1000）的情况下，这种模型是比较不错的，可以让每一个连接专注于自己的 I/O 并且编程模型简单，也不用过多考虑系统的过载、限流等问题。线程池本身就是一个天然的漏斗，可以缓冲一些系统处理不了的连接或请求。但是，当面对十万甚至百万级连接的时候，传统的 BIO 模型是无能为力的。因此，我们需要一种更高效的 I/O 处理模型来应对更高的并发量。
- **NIO (Non-blocking/New I/O):** NIO 是一种**同步非阻塞的 I/O 模型**，在 Java 1.4 中引入了 NIO 框架，对应 java.nio 包，提供了 Channel , Selector，Buffer 等抽象。NIO 中的 N 可以理解为 Non-blocking，不单纯是 New。它支持面向缓冲的，基于通道的 I/O 操作方法。 NIO 提供了与传统 BIO 模型中的 `Socket` 和 `ServerSocket` 相对应的 `SocketChannel` 和 `ServerSocketChannel` 两种不同的套接字通道实现,两种通道都支持阻塞和非阻塞两种模式。阻塞模式使用就像传统中的支持一样，比较简单，但是性能和可靠性都不好；非阻塞模式正好与之相反。对于低负载、低并发的应用程序，可以使用同步阻塞 I/O 来提升开发速率和更好的维护性；对于高负载、高并发的（网络）应用，应使用 NIO 的非阻塞模式来开发
- **AIO (Asynchronous I/O):** AIO 也就是 NIO 2。在 Java 7 中引入了 NIO 的改进版 NIO 2,它是**异步非阻塞的 IO 模型**。异步 IO 是基于事件和回调机制实现的，也就是应用操作之后会直接返回，不会堵塞在那里，当后台处理完成，操作系统会通知相应的线程进行后续的操作。AIO 是异步 IO 的缩写，虽然 NIO 在网络操作中，提供了非阻塞的方法，但是 NIO 的 IO 行为还是同步的。对于 NIO 来说，我们的业务线程是在 IO 操作准备好时，得到通知，接着就由这个线程自行进行 IO 操作，IO 操作本身是同步的。查阅网上相关资料，我发现就目前来说 AIO 的应用还不是很广泛，Netty 之前也尝试使用过 AIO，不过又放弃了。