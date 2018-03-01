# DsAlgoDp

数据结构、算法、设计模式 -- Java 描述

## 目录

数据结构：

1. [数组](#数组)
1. [链表](#链表)
1. [双向链表](#双向链表)
1. [循环链表](#循环链表)
1. [栈](#栈)
1. [队列](#队列)
1. [二叉树](#二叉树)
1. [完全二叉树](#完全二叉树)
1. [二叉搜索（查找）树](#二叉搜索树)
1. [AVL 树](#AVL树)
1. [伸展树](#伸展树)
1. [哈夫曼树（最优二叉树）](#哈夫曼树)
1. [红黑树](#红黑树)
1. [二叉堆](#二叉堆)
1. [左倾堆](#左倾堆)
1. [斜堆](#斜堆)
1. [二项堆](#二项堆)
1. [斐波那契堆](#斐波那契堆)
1. [图](#图)
1. [容器](#容器)

算法：

1. [最大子序列和](#最大子序列和)
1. [二分查找](#二分查找)
1. [辗转相除法](#辗转相除法)
1. [选择排序](#选择排序)
1. [冒泡排序](#冒泡排序)
1. [插入排序](#插入排序)
1. [希尔排序](#希尔排序)
1. [堆排序](#堆排序)
1. [归并排序](#归并排序)
1. [快速排序](#快速排序)
1. [桶排序](#桶排序)
1. [基数排序](#基数排序)
1. [散列](#散列)

设计模式：

1. [单例模式](#单例模式)

一些问题：

1. [O(1) 时间内删除链表结点](#删除链表结点)
1. [判断链表中是否有环](#判断链表中是否有环)
1. [单链表转置](#单链表转置)
1. [中缀表达式转后缀表达式](#中缀表达式转后缀表达式)
1. [后缀表达式求值](#后缀表达式求值)

协议：

[MIT](LICENSE)

## 数组

数组的特点是：**数据是连续的，随机访问速度很快**

但是插入删除涉及到元素的移动，开销较大。

## 链表

单向链表（单链表）由结点组成，每个结点都包含下一个结点的指针。

单链表的特点：**结点的链接方向是单向的，插入删除速度很快**

但是相对于数组来说，随机访问速度较慢。

## 双向链表

双向链表（双链表）是链表的一种。和单链表一样，双链表也是由结点组成，它的每个结点中有两个指针，分别指向**直接后继**和**直接前驱**。

## 循环链表

循环链表与单链表相比，其末尾结点的后继结点是表头结点。

## 栈

栈是一种线性存储结构，它有以下几个特点：

1. 栈中数据按照“后进先出”（LIFO, Last In First Out）的方式进出栈。
1. 向栈中添加/删除数据时，只能从栈顶进行操作。

栈通常包括三种操作：`push`、`peek`、`pop`：

- push —— 向栈中添加元素
- peek —— 返回栈顶元素
- pop —— 返回并删除栈顶元素

栈的实现可以通过数组也可以通过链表，数组实现有空间限制，而链表实现没有。

## 队列

队列也是一种线性存储结构，它有以下几个特点：

1. 队列中的数据按照“先进先出”（FIFO, First In First Out）的方式进出队列。
1. 队列只允许在队首进行删除操作，在队尾进行插入操作。

队列通常包括三种操作：`add`、`peek`、`poll`：

- add —— 向队列中添加元素
- peek —— 返回队首元素
- poll —— 返回并删除队首元素

队列也可以通过数组、链表实现。

## 二叉树

二叉树T：一个有穷的结点集合。这个集合**可以为空**。若不为空，则它是由**根结点**和称为**左子树TL**和**右子树TR**的两个不相交的二叉树组成。

二叉树有几个重要的性质：

1. 一个二叉树第 i 层的最大结点数为 2^(i-1), i >= 1
1. 深度为 k 的二叉树有最大结点数为 2^k - 1, k >= 1
1. 对任何非空二叉树 T，若 n0 表示叶结点的个数、n2 表示度为 2 的非叶结点的个数，那么两者满足关系 n0 = n2 + 1

对于第三条性质，通过边来证明：

> 从树底往上看，每个结点都往上有一条边，根结点往上没有边。
>
> 从树顶往下看，n0 往下没有边，n1 往下有一条边，n2 往下有两条边。

故有：n0 + n1 + n2 -1 = 0 * n0 + 1 * n1 + 2 * n2

得：`n0 = n2 + 1`

二叉树通常包括几种操作：前序遍历、中序遍历、后序遍历、层次遍历。

> 在任何一次遍历过程中，对于某一个结点总会访问三次。前序遍历就是在第一次访问的时候输出结点中信息，中序遍历则是在第二次访问的时候输出，后序遍历是在第三次访问的时候进行输出。

前序遍历和中序遍历也可以利用**栈**来进行非递归遍历，后序遍历的非递归实现比较复杂。

层次遍历利用**队列**实现，每次从队列中取出一个结点访问，然后将该结点的左右儿子（非空）放入队列。

问题1：输出二叉树的叶结点

在二叉树的前序、中序、后序遍历的时候加一个判断：

```java
if (node.left == null && node.right == null) {
    System.out.print(node.data + " ");
}
```

问题2：输出二叉树的高度

递归计算树的高度，每次返回左子树和右子树高度的最大值+1：

```java
private int height(Node node) {
    int highLeft, highRight;
    if (node != null) {
        highLeft = height(node.left);
        highRight = height(node.right);
        return (Math.max(highLeft, highRight) + 1);
    }
    return 0;
}
```

## 完全二叉树

完全二叉树是：有 n 个结点的二叉树，对树中结点按从上至下、从左到右的顺序进行编号，编号为 i（1 <= i <= n）结点与满二叉树中编号为 i 结点在二叉树中位置相同。

完全二叉树有以下几个重要的性质：

1. 非根结点（序号 i > 1）的 父结点 的序号是 [i/2] (向下取整)
1. 结点 i 的左孩子的序号是 2i。如果 2i > n，则没有左孩子
1. 结点 i 的右孩子的序号是 2i+1。如果 2i+1 > n，则没有右孩子

## 二叉搜索树

二叉搜索树是特殊的二叉树：对于二叉树，假设 x 为二叉树中任意一个结点，x 结点包含关键字 key，结点 x 的 key 值记为 key[x]。如果 y 是 x 的左子树中的一个结点，则 key[y] <= key[x]；如果 y 是 x 右子树的一个结点，则 key[y] >= key[x]。那么，这棵树就是二叉搜索树。

在二叉搜索树中：

1. 若任意结点的左子树不空，则左子树上所有结点的值均小于它的根结点的值
1. 若任意结点的右子树不空，则右子树上所有结点的值均大于它的根结点的值
1. 任意结点的左、右子树也分别为二叉搜索树
1. 没有键值相等的结点

二叉搜索树常用的操作有：插入、删除、查找、查找最大值、查找最小值。

## AVL树

AVL 树是高度平衡的二叉树。它的特点是：AVL 树中任何两个子树的高度最大差别为 1。

AVL 树中一个重要的操作就是旋转，在每次插入删除后都要检测 AVL 树的平衡是否被打破，如果被打破就要进行相应的旋转来保持平衡。

AVL 树的高度：

按照维基百科上的定义：树的高度为最大层次。即空二叉树的高度为 0，非空二叉树的高度为根结点左右子树的最大高度 + 1：

```java
private int height(Node node) {
    if (node != null)
        return node.height;
    return 0;
}
```

AVL 树中主要涉及到了四种旋转：LL旋转（右旋）、RR旋转（左旋）、LR旋转（先左旋，再右旋）、RL旋转（先右旋，再左旋）。

RR旋转（左旋）：

```java
private Node rightRightRotation(Node node) {
    Node tmp = node.right;
    node.right = tmp.left;
    tmp.left = node;

    node.height = Math.max(height(node.left), height(node.right)) + 1;
    tmp.height = Math.max(height(tmp.left), height(tmp.left)) + 1;

    return tmp;
}
```

LL旋转（右旋）：

```java
// LL 旋转。T 结点的左子树的左子树插入结点导致平衡因子改变。
private Node leftLeftRotation(Node node) {
    // 定义临时结点，指向 node 的左孩子，旋转后替代 node 的位置
    Node tmp = node.left;
    // 将 node（失衡结点）的左孩子指向 tmp 的右孩子上
    node.left = tmp.right;
    // 将 tmp 的右孩子指向 node
    tmp.right = node;
    // 以上，旋转完成

    // 重新计算高度
    node.height = Math.max(height(node.left), height(node.right)) + 1;
    tmp.height = Math.max(height(tmp.left), height(tmp.right)) + 1;
    return tmp;
}
```

LR旋转：

```java
// LR 旋转，首先进行 RR 旋转使其变为 LL 失衡状态，然后进行 LL 旋转
private Node leftRightRotation(Node node) {
    node.left = rightRightRotation(node.left);
    return leftLeftRotation(node);
}
```

RL 旋转：

```java
// RL 旋转，首先进行 LL 旋转使其变为 RR 失衡状态，然后进行 RR 旋转
private Node rightLeftRotation(Node node) {
    node.right = leftLeftRotation(node.right);
    return rightRightRotation(node);
}
```

## 伸展树

伸展树是特殊的二叉搜索树。它的特殊之处在于：当某个结点被访问时，伸展树会通过旋转使该结点成为树根。

伸展树保证从空树开始任意连续 M 次对树的操作最多花费 O(M log N) 时间。

伸展树最重要的操作是旋转：

```java
/**
    * 算法思想参考了《数据结构与算法分析 —— C语言描述》中伸展树自底向上展开
    * 以下注释中，
    * <strong>根结点</strong>指的是调用 splay 时传入的 node 结点
    * <strong>目标结点</strong>是程序中调用 splay 函数的语句返回的结点
    */
private Node splay(Node node, E key) {
    if (node == null) {
        // 如果结点为空，返回 null
        return null;
    }

    if (key.compareTo(node.key) < 0) {
        // 处理左侧，key < root.key
        if (node.left == null) {
            // 如果根结点没有左儿子，说明不存在值为 key 的结点，将根结点返回作为新的根。
            return node;
        }
        if (key.compareTo(node.left.key) < 0) {
            // 如果 key 小于根结点的左儿子，则对根结点的左儿子的左儿子进行 splay 调用
            node.left.left = splay(node.left.left, key);
            // 调用结束后对根结点进行一次右旋，根结点指向其原左儿子，目标结点（（原根结点的左儿子的左儿子）旋转到根结点的左儿子
            //  A       B
            // B   =>  C A
            //C     目标结点是 C
            node = rightRotation(node);
        } else if (key.compareTo(node.left.key) > 0) {
            // 如果 key 大于根结点的左儿子，则对根结点的左儿子的右儿子进行 splay 调用
            node.left.right = splay(node.left.right, key);
            if (node.left.right != null)
                // 如果调用结束目标结点（根结点的左儿子的右儿子）非空，则在左儿子处进行一次左旋，将目标结点旋转到根结点的左儿子
                node.left = leftRotation(node.left);
            //  A       A
            // B   =>  C    C 是目标结点
            //  C     B
        }

        // 最后如果根结点左儿子为空，则不存在 key 结点，返回当前根结点
        if (node.left == null) {
            return node;
        } else {
            // 如果左儿子非空，则说明 key 结点存在，并且就在根结点的左儿子，进行一次右旋将其旋转为新的根结点
            return rightRotation(node);
        }
    } else if (key.compareTo(node.key) > 0) {
        // 处理右侧，key > root.key
        if (node.right == null) {
            // 如果根结点没有右儿子，说明不存在值为 key 的结点，将当前结点返回作为根。
            return node;
        }
        if (key.compareTo(node.right.key) < 0) {
            // 如果 key 小于根结点的右儿子，则对根结点的右儿子的左儿子进行 splay 调用
            node.right.left = splay(node.right.left, key);
            if (node.right.left != null)
                // 如果调用结束并且目标结点（根结点的右儿子的左儿子）非空，则对根结点的右儿子进行一次右旋，将目标结点旋转为根结点的右儿子
                node.right = rightRotation(node.right);
            // A        A
            //  B  =>    C      C是目标结点
            // C          B
        } else if (key.compareTo(node.right.key) > 0) {
            // 如果 key 大于根结点的右儿子，则对根结点的右儿子的右儿子进行 splay 调用
            node.right.right = splay(node.right.right, key);
            // 调用结束后对根结点进行一次左旋，根结点指向其右儿子，现在根结点的右儿子是目标结点（原根结点的右儿子的右儿子）
            node = leftRotation(node);
            // A        B
            //  B  =>  A C
            //   C    C是目标结点
        }

        // 最后如果根结点右儿子为空，则不存在 key 结点，返回当前根结点
        if (node.right == null) {
            return node;
        } else {
            // 如果右儿子非空，则说明 key 结点存在，并且就在根结点的右儿子，进行一次左旋将其旋转为新的根结点
            return leftRotation(node);
        }
    } else {
        // 如果找到，直接返回
        return node;
    }
}
```

## 哈夫曼树

哈夫曼树，又称最优二叉树。

定义：给定 n 个权值作为 n 个叶子结点，构造一颗二叉树，若树的带权路径长度达到最小，则这棵树称为哈夫曼树。

路径和路径长度：在一棵树中，从一个结点往下可以达到的孩子或孙子结点之间的通路，称为路径。通路中分支的数目称为路径长度。若规定根结点的层数为 1，则从根结点到第 L 层结点的路径长度为 L-1。

结点的权：若将树中结点赋给一个有着某种含义的数值，则这个数值称为该结点的权。

结点的带权路径长度：从根结点到该结点之间的路径长度与该结点的权的乘积。

树的带权路径长度：所有叶子结点的带权路径长度之和。

可以利用优先队列（最大堆）来创建哈夫曼树：

```java
public HuffmanTree(int... elements) {
    Node parent = null;
    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.key));
    for (int element : elements) {
        queue.add(new Node(element));
    }
    while (queue.size() > 1) {
        // 当最后两个结点被取出计算 parent 后，parent 又放入队列中，此时应该停止循环。
        // 停止的条件就是 size > 1
        Node left = queue.poll();
        Node right = queue.poll();
        parent = new Node(left.key + right.key, left, right);
        queue.add(parent);
    }
    this.root = parent;
}
```

## 红黑树

Red-Black Tree，又称红黑树，是一种特殊的二叉搜索树。红黑树上的每个结点都有存储位表示结点的颜色，可以是红（Red）或黑（Black）。

红黑树的着色性质：

1. 每个结点或者是红色，或者是黑色
1. 根是黑色的
1. 如果一个结点是红色的，那么它的子结点必须是黑色的
1. 从一个结点到一个 null 指针的每一条路径必须包含相同数目的黑色结点

着色法则的一个推论是，红黑树的高度最多为 2log(N + 1)。因此，查找保证是一种对数的操作。事实上，最红黑树的操作在最坏情况下花费 O(logN) 时间。

红黑树的应用比较广泛，主要是用它来存储有序的数据，它的时间复杂度是 O(logN)，效率非常之高。例如，Java集合中的 TreeSet 和 TreeMap，C++ STL 中的 set、map，以及 Linux 虚拟内存的管理，都是通过红黑树去实现的。

红黑树实现起来太复杂了，容后再做 :cry:

## 二叉堆

堆（heap），这里说的堆是数据结构中的堆，而不是内存模型中的堆。堆通常可以被看作一棵树，他满足以下性质：

1. 堆中任意结点的值总是不大于（不小于）其子结点的值
1. 堆总是一颗完全树

将任意结点不大于其子结点的堆叫做**最小堆**，而将任意结点不小于其子结点的堆叫做**最大堆**。常见的堆有二叉堆、左倾堆、斜堆、二项堆、斐波那契堆等等。

二叉堆是完全二元树或者是近似完全二元树，它分为两种：最大堆或最小堆。

二叉堆一般都通过**数组**实现。数组实现的二叉堆，父结点和子结点的位置存在一定的关系。有时候，我们将二叉堆的第一个元素放在索引 0 的位置，有时候放在 1 的位置。当然，它们的本质一样，只是实现上稍微有一丁点的区别。

假设第一个元素在数组中索引为 0，则父结点和子结点的位置关系如下：

1. 索引 i 结点的左孩子的索引是 (2i + 1)
1. 索引 i 结点的右孩子的索引是 (2i + 2)
1. 索引 i 结点的父结点的索引是 (i - 1) / 2 取整数

假设第一个元素在数组中索引为 1，则父结点和子结点的位置关系如下：

1. 索引 i 结点的左孩子的索引是 2i
1. 索引 i 结点的右孩子的索引是 2i + 1
1. 索引 i 结点的父结点的索引是 i / 2 取整数

我的代码实现里统统采用**二叉堆的第一个元素在数组索引为 0** 的方式

最大堆的添加：

```java
public void add(T t) {
    this.heap.add(t);

    int current = this.heap.size() - 1;
    int parent = (current - 1) / 2;
    while (current > 0) {
        if (this.heap.get(parent).compareTo(t) < 0) {
            // 父结点位置元素小于新插入结点元素的值
            // 交换小的元素到新插入的位置
            this.heap.set(current, this.heap.get(parent));
            // current 移动到父结点的位置继续比较
            current = parent;
            // parent 移动到现在 current 的父结点
            parent = (current - 1) / 2;
        } else {
            // 父结点位置元素大于等于新插入结点元素的值，无需移动
            break;
        }
    }
    this.heap.set(current, t);
}
```

最大堆删除元素：

```java
public void remove(T t) {
    if (this.heap.isEmpty()) {
        // 堆为空，返回
        return;
    }

    int index = this.heap.indexOf(t);
    int size = this.heap.size();
    if (-1 == index) {
        // 堆中没有要删除的元素，返回
        return;
    }
    // 用最后的元素填补要删除元素的位置
    this.heap.set(index, this.heap.get(size - 1));
    // 删除最后的元素
    this.heap.remove(size - 1);

    if (this.heap.size() > 1) {
        // 进行调整
        int left = 2 * index + 1;   // 左孩子
        int end = this.heap.size() - 1;
        T tmp = this.heap.get(index);
        while (left <= end) {
            if (left < end && this.heap.get(left).compareTo(this.heap.get(left + 1)) < 0) {
                left++; // left 指向左右孩子中较大者
            }
            if (tmp.compareTo(this.heap.get(left)) < 0) {
                // 填补的元素比左右孩子中较大者小
                // 将较大者交换到填补位置
                this.heap.set(index, this.heap.get(left));
                // index 指向较大者位置
                index = left;
                // left 指向 index 的左儿子
                left = 2 * index + 1;
            } else {
                // 调整结束
                break;
            }
        }
        this.heap.set(index, tmp);
    }
}
```

添加元素从下往上修正，删除元素从上往下修正。

## 左倾堆

左倾堆（leftist tree 或 leftist heap），又称为左偏树、左偏堆、最左堆等。它和二叉堆一样，都是优先队列的实现方式，当优先队列中涉及到**对两个优先队列进行合并**的问题时，二叉堆的效率就无法令人满意了，而左倾堆则可以很好的解决这类问题。

左倾堆的结点除了和二叉堆一样具有左右儿子键值之外，还有一个属性：零距离。

- 零距离（NPL，Null Path Length）：从一个结点到一个最近的不满结点的长度。
- 不满结点：该结点左右孩子至少有一个为 NULL。

叶结点的 NPL 为 0，NULL结点的 NPL 为 -1

左倾堆有以下几个基本性质：

1. 结点的键值小于或等于它的左右子结点的键值
1. 结点的左孩子的 NPL >= 右孩子的 NPL
1. 结点的 NPL = 它的右孩子的 NPL + 1

左倾堆中最重要的操作是合并，其基本思想如下：

1. 如果一个空左倾堆和一个非空左倾堆合并，返回非空左倾堆
1. 如果两个左倾堆都非空，比较两个根结点，取较小堆的根结点为新的根结点。将较小堆的根结点的右孩子和较大堆进行合并
1. 如果新堆的右孩子的 NPL > 左孩子的 NPL，则交换左右孩子
1. 设置新堆的根结点的 NPL = 右孩子的 NPL + 1

相关代码实现：

```java
private Node merge(Node<T> x, Node<T> y) {
    if (x == null) {
        return y;
    }
    if (y == null) {
        return x;
    }

    // 合并 x 和 y 时，将 x 作为合并后的根
    if (x.key.compareTo(y.key) > 0) {
        Node node = x;
        x = y;
        y = node;
    }

    // 将 x 的右孩子和 y 合并，**合并后树的根**是 x 的右孩子
    x.right = this.merge(x.right, y);

    // 如果 x 的左孩子为空或者 x 的左孩子的 npl < 右孩子的 npl，交换左右孩子
    if (x.left == null || x.left.npl < x.right.npl) {
        Node node = x.left;
        x.left = x.right;
        x.right = node;
    }
    if (x.right == null || x.left == null) {
        // 如果为叶子结点，则 npl 为 0
        x.npl = 0;
    } else {
        // 否则，npl 为
        x.npl = x.left.npl > x.right.npl ? x.right.npl + 1 : x.left.npl + 1;
    }
    return x;
}
```

## 斜堆

斜堆（skew heap）也叫自适应堆（self-adjusting heap），它是左倾堆的一个变种。和左倾堆一样，它通常也适用于优先队列；作为一种自适应的左倾堆，它的合并操作的时间复杂度也是 O(log N)。

斜堆和左倾堆的差别是：

1. 斜堆的结点没有零距离这个属性
1. 斜堆的合并操作和左倾堆的合并算法不同

斜堆的合并操作：

1. 如果一个空斜堆与一个非空斜堆合并，返回非空斜堆
1. 如果两个斜堆都非空，那么比较两个根结点，取较小堆的根结点为新的根结点。并将较小堆的根结点的右孩子和较大堆进行合并
1. 合并后，交换新根结点的左孩子和右孩子

第三步是斜堆和左倾堆合并操作的关键所在，如果是左倾堆，合并后要比较左右孩子的零距离大小，若左孩子零距离 < 右孩子零距离，则需要交换左右孩子。而斜堆无论任何情况都交换左右孩子。

斜堆的合并算法：

```java
private Node merge(Node<T> x, Node<T> y) {
    if (x == null) {
        return y;
    }
    if (y == null) {
        return x;
    }

    // 合并 x 和 y 时，将 x 作为合并后的树根
    if (x.key.compareTo(y.key) > 0) {
        Node<T> node = x;
        x = y;
        y = node;
    }

    // 将 x 的右孩子和 y 合并，合并后直接交换 x 的左右孩子
    Node tmp = merge(x.right, y);
    x.right = x.left;
    x.left = tmp;

    return x;
}
```

## 二项堆

二项堆是二项树的集合。在了解二项堆之前，先对二项树进行介绍。

二项树是一种递归定义的有序树：

1. 二项树 B0 只有一个结点
1. 二项树 Bk 由两颗二项树 B(k-1) 组成，其中一颗树是另一棵树的最左孩子

具体实现太过复杂 :cry:

## 斐波那契堆

:cry:

## 图

图的几个概念：

1. 图的种类：根据边是否有方向，将图分为无向图和有向图
1. 邻接点：一条边上的两个顶点叫邻接点
1. 度：在无向图中，某个顶点的度是邻接到该顶点的边的数目
1. 路径：如果顶点 v1 和顶点 v2 之间存在一个顶点序列，则表示 v1 到 v2 是一条路径
1. 路径长度：路径中边的数目
1. 简单路径：一条路径上的顶点不重复出现
1. 回路：路径的第一个顶点和最后一个顶点相同
1. 简单回路：第一个顶点和最后一个顶点相同，且其他顶点不重复的路径
1. 连通图：对于无向图，任意两个顶点之间都存在一条无向路径，则称无向图为连通图
1. 连通分量：无向图的极大连通子图

>主要有两个条件：
>
>1、极大顶点数：再加一个顶点就不连通了
>
>2、极大边数：包含子图中所有顶点相连的所有边

图的存储：

1. 邻接矩阵：容易判断两个顶点之间是否有边，耗费空间
1. 邻接表：相对节省空间，但是不容易判断两个顶点之间是否有边

相关算法（均基于领接矩阵无向图，其他图实现方式类似）：

### 查找边的邻接点：

```java
private List<Integer> adjacent(int v) {
    List<Integer> list = new ArrayList<>();
    if (v < 0 || v > graph.vertices.length - 1) {
        // v 的索引不合法
        return list;
    }

    for (int i = 0; i < graph.vertexCount; i++) {
        if (graph.edges[v][i] > 0) {
            // 说明 v 到 i 有一条边
            list.add(i);
        }
    }

    return list;
}
```

### 深度优先遍历：

```java
/**
* 深度优先遍历 —— Depth First Search
*
* 和树的先序遍历类似。
*
* 它的思想：假设初始状态所有顶点均未被访问，则从某个顶点 v 出发，首先访问该顶点，然后依次从它的各个邻接点出发进行深度优先搜索，直至途中所有和 v 有路径连通的顶点都被访问到。若此时还有其他顶点没有被访问到，则另选一个未被访问的顶点作为起始点，重复上述过程，直至图中所有的顶点都被访问到。
* 
* 显示，深度优先遍历是一个递归的过程。
*/
public void DFS() {
    boolean[] visited = new boolean[graph.vertexCount];

    for (int i = 0; i < graph.vertexCount; i++) {
        visited[i] = false;
    }

    System.out.println("Depth First Search: ");
    for (int i = 0; i < graph.vertices.length; i++) {
        if (!visited[i]) {
            this.depthFirstSearch(i, visited);
        }
    }
    System.out.println();
}

private void depthFirstSearch(int v, boolean[] visited) {
    visited[v] = true;
    System.out.print(graph.vertices[v] + " ");
    for (Integer integer : this.adjacent(v)) {
        if (!visited[integer]) {
            this.depthFirstSearch(integer, visited);
        }
    }
}
```

### 广度优先遍历：

```java
/**
* 广度优先遍历 —— Breadth First Search
* 
* 外层 for 循环的作用是完全访问这种图（不连通图）：A-B   C-D
* 内层使用队列，队列中的元素始终是访问过的，每次我们从队列中取出元素，访问其邻接点，然后再把访问过的邻接点放入队列。循环直到队列为空。
*/
public void BFS() {
    boolean[] visited = new boolean[graph.vertexCount];
    Queue<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < graph.vertexCount; i++) {
        visited[i] = false;
    }

    System.out.println("Breadth First Search: ");
    for (int i = 0; i < graph.vertices.length; i++) {
        if (!visited[i]) {
            visited[i] = true;
            System.out.print(graph.vertices[i] + " ");
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (Integer integer : this.adjacent(v)) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    System.out.print(graph.vertices[integer] + " ");
                    queue.add(integer);
                }
            }
        }
    }
}
```

### 拓扑排序：

拓扑排序（Topological Order）是指，将一个有向无环图（Directed Acyclic Graph，简称 DAG）进行排序进而得到一个有序的线性序列。

拓扑排序的基本步骤：

1. 构造一个队列 Q 和拓扑排序结果队列 T
1. 将所有没有依赖顶点的结点放入 Q
1. 当 Q 中还有顶点的时候，执行下面的步骤：
> 1. 从 Q 中取出一个顶点 M，放入 T
> 1. 对 m 的每一个邻接点 n（m 是起点，n 是终点）:
>>
>> 去掉边 `<m, n>`
>>
>> 如果 n 没有依赖顶点，把 n 放入 Q 

邻接表有向图中代码实现：

```java
public void topologicalSort() {
    Map<String, Integer> inDegree = new HashMap<>();    // 入度
    Queue<Integer> queue = new ArrayDeque<>();          // 保存入度为 0 的顶点
    List<Integer> result = new ArrayList<>();           // 结果序列

    // 计算每个顶点的入度
    for (int i = 0; i < vertexCount; i++) {
        Node node = vertices[i].firstNode;
        while (node != null) {
            // 初次初始化，使用 getOrDefault 来避免 NullPointerException
            inDegree.put(node.vertex, inDegree.getOrDefault(node.vertex, 0) + 1);
            node = node.next;
        }
    }

    // 入度为 0 的顶点入队列
    for (int i = 0; i < vertexCount; i++) {
        // 因为可能存在入度为 0 的顶点，所以这里也是用 getOrDefault 在未设置值的时候返回默认值
        if (inDegree.getOrDefault(vertices[i].vertex, 0) == 0) {
            queue.add(i);
        }
    }

    while (!queue.isEmpty()) {
        int v = queue.poll();   // 弹出入度为 0 的顶点
        result.add(v);          // 加入结果序列
        Node node = vertices[v].firstNode;  // 获得其邻接序列

        while (node != null) {
            // 更新 v 邻接序列的入度
            // v 的邻接序列的入度一定非 0，所以不需要设置 map 默认值
            inDegree.put(node.vertex, inDegree.get(node.vertex) - 1);

            if (inDegree.get(node.vertex) == 0) {
                queue.add(valueOf(node.vertex));
            }

            node = node.next;
        }
    }

    if (result.size() != vertexCount) {
        System.out.println("Graph has a cycle!");
        return;
    }

    for (Integer integer : result) {
        System.out.print(vertices[integer].vertex + " ");
    }
    System.out.println();
}
```

### Dijkstra 算法：

Dijkstra 算法是典型的最短路径算法，用于计算一个结点到其他结点的最短路径。它的主要特点是以起始点为中心向外层层层扩展（广度优先算法思想），直到扩展到终点为止。

基本思想：

通过 Dijkstra 算法计算最短路径的时候需要指定起点 s。

同时，引进两个集合 S 和 U。S 的作用是记录已求出最短路径的顶点（以及相应的最短路径长度），U 则是记录还未求出最短路径的顶点（以及该顶点到起点 s 的距离）。

初始时，S 中只有 s；U 中是除 s 之外的顶点，并且 U 中顶点的路径是 “起点 s 到该顶点的路径”。然后，从 U 中找出路径最短的顶点，并将其加入 S 中；接着，更新 U 中的顶点和顶点对应的路径。然后，再从 U 中找出路径最短的顶点，并将其加入 S 中；接着，...。重复该操作，直到遍历完所有顶点

操作步骤：

1. 初始时，S 只包含 s，U 包含除 s 之外的其他定点，且 U 中顶点的距离为 “起点 s 到该顶点的距离”（例如：U 中顶点 v 的距离为 (s, v) 的长度。如果 s 和 v 不相邻，则 v 的距离为 ∞）。
1. 从 U 中选出“距离最短的顶点 k”，并将顶点 k 加入 S 中，同时从 U 中移除 k。
1. 更新 U 中各个顶点到起点 s 的距离。之所以更新，是因为上一步中确定了 k 是最短距离，从而可以利用 k 来更新其他顶点的距离。
1. 重复步骤 2 和 3，直到遍历完所有顶点。

邻接矩阵无向图的代码实现：

```java
public void Dijkstra(int v) {
    boolean[] flag = new boolean[this.vertexCount]; // flag[i] = true 表示顶点 v 到顶点 i 的最短路径已经成功找到
    int[] distance = new int[this.vertexCount];     // 长度数组，distance[i] 是顶点 v 到顶点 i 的最短路径长度
    int k = 0;  // k 位置顶点是已获得的最短路径

    for (int i = 0; i < this.vertexCount; i++) {
        flag[i] = false;            // 顶点 i 的最短路径还没找到
        distance[i] = edges[v][i];  // 顶点 i 的最短路径为顶点 v 到顶点 i 的权，权值的默认值为 Integer.MAX_VALUE
    }

    // 对顶点 v 进行初始化
    flag[v] = true;
    distance[v] = 0;
    System.out.println("Dijkstra: ");
    System.out.println(vertices[v] + " 到 " + vertices[v] + " 的最短路径是：" + distance[v]);

    // 进行 vertexCount - 1 次循环
    for (int i = 1; i < this.vertexCount; i++) {
        int min = INF;
        // 获取未找到最短路径顶点中最小值及其索引
        for (int j = 0; j < this.vertexCount; j++) {
            if (!flag[j] && distance[j] < min) {
                min = distance[j];
                k = j;
            }
        }

        // 标记顶点 k 为已经获得的最短路径
        flag[k] = true;
        System.out.println(vertices[v] + " 到 " + vertices[k] + " 的最短路径是：" + distance[k]);

        // 修正未获得最短路径的顶点集合中的路径长度
        for (int j = 0; j < this.vertexCount; j++) {
            // tmp 此处的判断是：如果从顶点 k 到顶点 j 有边，那么暂存 min+边的权值
            int tmp = (edges[k][j] == INF ? INF : (min + edges[k][j]));
            if (!flag[j] && tmp < distance[j]) {
                // 如果 tmp 比 distance[j] 大，说明 j 到 v 之间有较短路径
                // 如果 tmp 比 distance[j] 小，说明需要更新 distance[j]
                distance[j] = tmp;
            }
        }
    }
}
```

### Kruskal 算法

最小生成图：

在含有 n 个顶点的连通图中选择 n - 1 条边，构成一颗极小连通子图，并使该连通子图中 n - 1 条边上权值之和最小，则称其为连通网（网，带权值的图）的最小生成树。

Kruskal 算法是用来求加权连通图的最小生成树的算法。

基本思想：

按照权值从小到大的顺序选择 n - 1 条边，并保证这 n - 1 条边不构成回路。

具体做法：

首先构造一个只含 n 个结点的森林，然后依权值大小从连通网中选择边加入森林中，并使森林不产生回路，直至森林变成一棵树为止。

算法分析：

Kruskal 算法重点需要解决以下两个问题：

1. 对图中的边按照权值大小进行排序
1. 将边添加到最小生成树中时，怎样判断是否形成了回路

第一个问题很好解决，采用排序算法即可。

第二个问题的处理方式是：记录顶点再最小生成树中的**终点**，顶点的终点是“在最小生成树中与它连通的最大顶点”。然后每次需要将一条边添加到最小生成树时，判断该边的两个终点是否重合，重合的话则构成回路。

![](https://raw.githubusercontent.com/wangkuiwu/datastructs_and_algorithm/master/pictures/graph/kruskal/04.jpg)

在将 <E, F>, <C, D>, <D, E> 加入到最小生成树中之后，这几条边的顶点都有了终点：

> C 的终点是 F
> D 的终点是 F
> E 的终点是 F
> F 的终点是 F

关于终点，就是将所有顶点按照从小到大的顺序排列好之后，某个顶点的终点就是“与它连通的最大顶点”

Kruskal 算法的邻接矩阵代码实现：

```java
public void Kruskal() {
    int[] vEnds = new int[this.edgeCount];
    // 使用优先队列保存边，创建优先队列时设置比较器为从小到大
    PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparing(e -> e.weight));
    // 结果列表
    List<Edge> edgeList = new ArrayList<>();
    int resultWeight = 0;

    // 初始化边
    for (int i = 0; i < this.vertexCount; i++) {
        for (int j = 0; j < i; j++) {
            if (this.edges[i][j] != INF) {
                // 因为创建边的时候 i 为第一下标，j 为第二下标，所以数组中应该是
                //   A B C
                // A
                // B
                // C
                // ...
                // 因为使用邻接矩阵保存，为避免加入队列的时候出现一条边加入两次的情况，内次循环只循环 i 次
                // 但是如果循环 i 次，会造成只访问了左下半部分元素，如果我们需要 A B 形式而不是 B A 形式的边，我们必须在保存的时候交换 i j 位置
                edges.add(new Edge(j, i, this.edges[i][j]));
            }
        }
    }

    Edge edge;
    int start, end; // 边开始顶点位置，结束顶点位置
    int sEnd, eEnd; // 开始顶点的终点，结束顶点的终点
    while (!edges.isEmpty()) {
        edge = edges.poll();    // 权值最小的边出队列
        start = edge.start;
        end = edge.end;

        sEnd = this.getEnd(vEnds, start);   // 获取 start 的终点
        eEnd = this.getEnd(vEnds, end);     // 获取 end 的终点

        if (sEnd != eEnd) {                 // 如果两个终点相同，则说明可能产生回路
            vEnds[sEnd] = eEnd;
            edgeList.add(edge);
            resultWeight += edge.weight;
        }
    }

    System.out.println("Kruskal 最小生成树的权值：" + resultWeight);
    System.out.println("Kruskal 最小生成树的边: ");
    for (Edge edge1 : edgeList) {
        System.out.println(this.vertices[edge1.start] + ", " + this.vertices[edge1.end]);
    }
}
```

### Prim 算法

Prim 算法和 Kruskal 算法一样，是用来求加权连通图的最小生成树的算法。

基本思想：

对于图 G，V 是所有顶点的集合。现在，设置两个新的集合 U 和 T，其中 U 用于存放 G 的最小生成树中的顶点，T 存放 G 的最小生成树的边。从所有 u ∈ U，v ∈ (V-U) 的边中选取权值最小的边(u, v)，将顶点 v 加入集合 U 中，将边 (u, v) 加入集合 T 中，如此不断重复，直至 U=V 为止，最小生成树构造完毕，这时，集合 T 中包含了最小生成树的所有边。

Prim 算法的邻接矩阵代码实现：

```java
public void Prim(int start) {
    int[] weight = new int[vertexCount];    // 权值数组，权值为 0 视为已加入最小生成树
    List<String> list = new ArrayList<>();
    int resultWeight = 0;

    // prim 最小生成树的第一个数是 start 顶点
    list.add(this.vertices[start]);
    // 初始化权值列表
    System.arraycopy(edges[start], 0, weight, 0, vertexCount);
    // 初始化顶点 start 的权值
    weight[start] = 0;

    for (int i = 0; i < vertexCount; i++) {
        if (i == start) {
            // 不需要再处理 start 顶点
            continue;
        }

        int k = 0, min = INF;
        // 找到未被加入最小生成树的顶点中权值最小的顶点
        for (int j = 0; j < vertexCount; j++) {
            if (weight[j] != 0 && weight[j] < min) {
                // weight[j] == 0 代表着 j 已经加入最小生成树
                min = weight[j];
                k = j;
            }
        }

        // 将第 k 个顶点加入最小生成树的结果数组
        list.add(this.vertices[k]);
        // 将 k 顶点的权值标记为 0，意味着第 k 个顶点已经加入最小生成树
        weight[k] = 0;
        resultWeight += min;

        // 更新剩下顶点的权值
        for (int j = 0; j < vertexCount; j++) {
            if (weight[j] != 0 && weight[j] > this.edges[k][j]) {
                weight[j] = this.edges[k][j];
            }
        }
    }

    System.out.println("Prim 最小生成树的权值：" + resultWeight);
    System.out.println("Prim 最小生成树的边：");
    for (String s : list) {
        System.out.print(s + " ");
    }
    System.out.println();
}
```

## 容器

![](https://images0.cnblogs.com/blog/497634/201309/08171028-a5e372741b18431591bb577b1e1c95e6.jpg)

### Collection

Collection 是一个接口，是高度抽象出来的集合，它包括了集合的基本操作和属性。

Collection 包括了 List 和 Set 两大分支：

1. List 是一个有序的序列，每一个元素都有它的索引。List 的实现类有 LinkedList，ArrayList，Vector，Stack
1. Set 是一个不允许有重复元素的集合。Set 的实现类有 HashSet 和 TreeSet。HashSet 依赖于 HashMap，它实际上通过 HashMap 实现；TreeSet 依赖与 TreeMap，它实际上通过 TreeMap 实现。

### Map

Map 是一个映射接口，即 key-value 键值对。Map 中的每一个元素包含 “一个 key” 和 “key 对应的 value”。

AbstractMap 是一个抽象类，它实现了 Map 接口中的大部分 API。而 HashMap，TreeMap，WeakHashMap 都是继承于 AbstractMap。

HashTable 虽然继承于 Dictionary，但它实现了 Map 接口。

### Iterator

Iterator 是遍历集合的工具，即我们通常通过 Iterator 迭代器来遍历集合。Collection 依赖于 Iterator，所有 Collection 的实现类都要实现 iterator() 函数，返回一个 Iterator 对象。

ListIterator 是专门为遍历 List 而存在的。

### Enumeration

Enumeration 的作用和 Iterator 一样，也是遍历集合。但是 Enumeration 的功能要比 Iterator 少。

### Arrays 和 Collections

Arrays 和 Collections 是用来操作数组、集合的两个工具类。

### List

List 是有序的序列，List 中可以有重复的元素。

### Set

Set 是数学概念中的集合，Set 中没有重复元素。

### ArrayList

ArrayList 是一个数组队列，相当于**动态数组**。与 Java 中的数组相比，它的容量能动态增长，初始值为 **10**。它继承于 AbstractList，实现了 List, RandomAccess, Cloneable, java.io.Serializable 这些接口。

和 Vector 不同，**ArrayList 的操作不是线程安全的**！所以，建议在单线程中才使用 ArrayList，而在多线程中可以选择 Vector 或者 CopyOnWriteArrayList。

当 ArrayList 的容量不足以容纳全部元素时，ArrayList 会重新设置容量(扩大三倍)：

```java
int newCapacity = oldCapacity + (oldCapacity >> 1);
```

### Iterator 的 fail-fast 机制

fail-fast 是 Java 集合（Collection）中的一种错误机制。当多个线程对同一集合的内容进行操作时，就可能产生 fail-fast 事件。

例如：当某一个线程A通过iterator去遍历某集合的过程中，若该集合的内容被其他线程所改变了；那么线程A访问集合时，就会抛出ConcurrentModificationException 异常，产生 fail-fast 事件。

ArrayList 每次调用 next() 和 remove() 等方法时，都会执行 checkForComodification()：

```java
if (expectedModCount != ArrayList.this.modCount)
    throw new ConcurrentModificationException();
```

如果 modCount 不等于 expectedModCount，则抛出 ConcurrentModificationException 异常，产生 fail-fast 事件。

而 `java.util.concurrent.CopyOnWriteArrayList` 则使用了 volatile 关键字保证内存一致性。

fail-fast 机制，是一种错误检测机制。它只能被用来检测错误，因为 JDK 并不保证 fail-fast 机制一定会发生。若在多线程环境下使用 fail-fast 机制的集合，建议使用 `java.util.concurrent` 包下的类去取代 `java.util` 包下的类。

### LinkedList

LinkedList 是一个继承于 AbstractSequentialList 的双向链表。它也可以被当作堆栈、队列、或双端队列进行操作。LinkedList 实现了 List, Deque, Cloneable, java.io.Serializable 接口。

LinkedList 是非同步的。

LinkedList 实际上是通过双向链表实现的，它包含一个非常重要的内部类 Entry。Entry 是双向链表结点所对应的数据结构。

### Vector

Vector 是矢量队列，继承于 AbstractList，实现了 List, RandomAccess, Cloneable, java.io.Serializable 接口。

和 ArrayList 不同，Vector 中的操作是线程安全的。

Vector 默认容量大小为 10。

当 Vector 的容量不够时，会根据增长因子的情况增加容量：

```java
int newCapacity = oldCapacity + ((capacityIncrement > 0) ? 
capacityIncrement : oldCapacity);
```

### Stack

Stack 是栈，它的特性是：**先进后出(FILO, First In Last Out)**

Stack 继承于 Vector 的，而 Vector 是通过数组实现的，这就意味着，**Stack 也是通过数组实现的，而非链表**。当然，我们也可以把 LinkedList 当作栈来使用。

### List 总结

如果涉及到 “栈”、“队列”、“链表” 等操作，应该考虑 List，具体选择哪个 List，以下有几条标准：

1. 对于需要快速插入、删除元素，应该使用 LinkedList
1. 对于需要快速随机访问的元素，应该使用 ArrayList
1. 对于“单线程环境”或者“多线程环境，但是 List 只会被单个线程操作”，应该使用非同步的类（如 ArrayList）
1. 对于“多线程环境，且 List 可能同时被多个线程操作”，此时应该使用同步的类（如 Vector）

### HashMap

HashMap 继承自 AbstractMap，实现了 Map, Cloneable, Serializable 接口。

HashMap 的实现是不同步的，这意味着它不是线程安全的。

HashMap 的 key、value 都可以为 null。

HashMap 中的映射不是有序的。

HashMap 中有两个参数影响其性能：**初始容量**和**加载因子**。初始容量是哈希表在创建时的容量。加载因子是哈希表在其容量自动增加之前可以达到多满的一种尺度。通常，**默认的加载因子是 0.75**

### Hashtable

和 HashMap 一样，Hashtable 也是一个散列表，它存储的内容是键值对（key-value）映射。

Hashtable 继承于 Dictionary，实现了 Map, Cloneable, java.io.Serializable 接口。

Hashtable 的函数都是同步的，这意味着它是线程安全的。

Hashtable 的 key、value 都不可以为 null。

Hashtable 中的映射不是有序的。

和 HashMap 一样，Hashtable 中也有两个参数影响其性能：**初始容量**和**加载因子**。加载因子默认是 0.75。

### TreeMap

TreeMap 是一个有序的 key-value 集合，它的内部是通过**红黑树**实现的。

TreeMap 继承于 AbstractMap，实现了 NavigableMap, Cloneable, java.io.Serializable 接口。实现 NavigableMap 意味着它支持一系列的导航方法。

TreeMap 是基于**红黑树（Red-Black Tree）**实现。该映射根据其**键的自然顺序**进行排序，或者根据**创建映射时提供的 Comparator 进行排序**。

TreeMap 是非同步的。

### WeakHashMap

WeakHashMap 继承于 AbstractMap，实现了 Map 接口。

和 HashMap 一样，WeakHashMap 也是一个散列表，它存储的内容也是键值对映射，而且键和值都可以是 null。

不过，WeakHashMap 中的键是**弱键**。在 WeakHashMap 中，当某个键不再正常使用时，会被从 WeakHashMap 中自动移除。更准确的说，对于一个给定的键，其映射的存在并不组织垃圾回收器对其键的丢弃，这就是该键称为可终止的，被终止，然后被回收。某个键被终止时，它对应的键值对也就从映射中有效地移除了。

**弱键**的原理，大致上是通过**WeakReference和ReferenceQueue**实现的。WeakHashMap 的 key 时弱键，即是 WeakReference 类型的；ReferenceQueue 是一个队列，它会保存被 GC 回收的弱键。实现步骤是：

1. 新建 WeakHashMap，将键值对添加到 WeakHashMap 中。
1. 当**某弱键不再被其他对象引用，并被GC回收时**，在 GC 回收该弱键时，这个弱键也同样会被添加到 ReferenceQueue 队列中。
1. 当下一次我们需要操作 WeakHashMap 时，会先同步内部的 table 和 ReferenceQueue，也即，删除 table 中被 GC 回收的键值对。

WeakHashMap 是不同步的。

### Map总结

1. HashMap 是基于拉链（分离链接）法实现的散列表，一般用于单线程程序中
1. Hashtable 也是基于拉链法实现的散列表，一般用于多线程程序中
1. WeakHashMap 也是基于拉链法实现的散列表，它一般也用于单线程程序中
1. TreeMap 是有序的 Map，它是通过红黑树实现的，一般用于单线程中存储有序的映射

### HashSet

HashSet 是一个没有重复元素的集合，它是由 HashMap 实现的，**不保证元素顺序**，并且**允许使用 null 元素**。

HashSet 是非同步的，可以通过 `Collections.synchronizedSet` 方法来包装 set。

### TreeSet

TreeSet 是一个有序的集合，继承于 AbstractSet 类，实现了 NavigableSet, Cloneable, java.io.Serializable 接口。

TreeSet 是基于 TreeMap 实现的。TreeSet 中的元素支持两种排序方式：自然排序或者根据创建 TreeSet 时提供的 Comparator 进行排序。TreeSet 为基本操作（add、remove等）提供受保证的 log (N) 时间开销。

TreeSet 是非线程安全的。

### Iterator 与 Enumeration 比较

Enumeration 是一个接口：

```java
public interface Enumeration<E> {
    boolean hasMoreElements();
    E nextElement();
}
```

Iterator 也是一个接口：

```java
public interface Iterator<E> {
    boolean hasNext();
    E next();
    default void remove() {
        throw new UnsupportedOperationException("remove");
    }
    default void forEachRemaining(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
    }
}
```

他们之间主要的区别有：

1. 函数接口不同
1. Iterator 支持 fail-fast 机制，而 Enumeration 不支持

Enumeration 是 JDK 1.0 添加的接口，使用它的类包括 Vector、Hashtable 等，这些类都是 JDK 1.0 中加入的，Enumeration 存在的目的就是为他们提供遍历接口。Enumeration 本身并没有支持同步，而在 Vector、Hashtable 实现 Enumeration 时，添加了同步。

Iterator 是 JDK 1.2 添加的接口，它也是为了 HashMap、ArrayList 等集合提供遍历接口。Iterator 是支持 fail-fast 机制的：当多个线程对同一个集合的内容进行操作时，就可能会产生 fail-fast 事件。

## 最大子序列和

给定整数 A1, A2, ..., An(可能有负数)，求 ∑(k=i, j)Ak 的最大值（为方便起见，如果所有整数均为负数，则最大子序列和为 0）

### 算法一 —— 遍历所有子序列

```java
public static int maxSubSequenceSum(int[] sequence) {
    int max = 0, this_sum = 0;

    for (int i = 0; i < sequence.length; i++) {
        for (int j = i; j < sequence.length; j++) {
            this_sum = 0;

            for (int k = i; k <= j; k++) {
                this_sum += sequence[k];
            }

            if (this_sum > max) {
                max = this_sum;
            }
        }
    }

    return max;
}
```

算法的时间复杂度 O(N³)

### 算法二 —— 对算法一稍微改进

```java
public static int maxSubSequenceSum(int[] sequence) {
    int max = 0, this_sum = 0;

    for (int i = 0; i < sequence.length; i++) {
        this_sum = 0;
        // 相对一算法 1 的改进，直接计算和，没必要再遍历一次
        for (int j = i; j < sequence.length; j++) {
            this_sum += sequence[j];

            if (this_sum > max) {
                max = this_sum;
            }
        }
    }

    return max;
}
```

算法的时间复杂度：O(N²)

### 算法三 —— 分治

分治算法，将序列分为左右两个子序列，分别计算 左、右、中间 的子序列和，比较最大的并返回。

```java
public static int maxSubSequenceSum(int[] sequence, int left, int right) {
    int center;
    int maxLeftSum, maxRightSum;
    int leftBorderSum, rightBorderSum;
    int maxLeftBorderSum, maxRightBorderSum;

    if (left == right) {
        if (sequence[left] > 0) {
            return sequence[left];
        } else {
            return 0;
        }
    }

    center = left / 2 + right / 2;
    // 计算左侧的最大子序列和
    maxLeftSum = maxSubSequenceSum(sequence, left, center);
    // 计算右侧的最大子序列和
    maxRightSum = maxSubSequenceSum(sequence, center + 1, right);

    // 计算包括中间的最大子序列和
    leftBorderSum = 0;
    maxLeftBorderSum = 0;
    for (int i = center; i >= left; i--) {
        leftBorderSum += sequence[i];

        if (leftBorderSum > maxLeftBorderSum) {
            maxLeftBorderSum  = leftBorderSum;
        }
    }

    rightBorderSum = 0;
    maxRightBorderSum = 0;
    for (int i = center + 1; i < right; i++) {
        rightBorderSum += sequence[i];

        if (rightBorderSum > maxRightBorderSum) {
            maxRightBorderSum = rightBorderSum;
        }
    }

    return Math.max(Math.max(maxLeftSum, maxRightSum), maxLeftBorderSum + maxRightBorderSum);
}
```

算法的时间复杂度 O(N log N)

### 算法四 —— 联机算法

只对数据进行一次扫描即可。

```java
public static int maxSubSequenceSum(int[] sequence) {
    int max = 0, this_sum = 0;

    for (int i : sequence) {
        this_sum += i;

        if (this_sum > max) {
            max = this_sum;
        } else if (this_sum < 0) {
            this_sum = 0;
        }
    }

    return max;
}
```

算法的时间复杂度 O(N)

## 二分查找

对于一个排序好的序列，如果要查找其中是否有某个元素，遍历的做法是十分低效的，我们可以使用二分查找法。

二分查找的思想是每次比较序列的中间值，大于中间值就比较右半序列，小于就比较左半序列，直到找到元素或者找不到循环退出。

```java
public class BinarySearch {
    public static void main(String[] args) {
        int[] sequence = new int[]{1, 3, 4, 5, 6, 7, 9, 14, 17};
        System.out.println(binarySearch(sequence, 4));
    }

    public static int binarySearch(int[] sequence, int n) {
        int low = 0, high = sequence.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            System.out.println("Try " + sequence[mid]);
            if (n < sequence[mid]) {
                high = mid;
            } else if (n > sequence[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
```

算法的时间复杂度 O(log N)

## 辗转相除法

辗转相除法，又名欧几里得算法，是计算两个数的最大公约数的简便算法

```java
public class EuclidGCD {
    public static void main(String[] args) {
        System.out.println(euclid(1989, 1590));	// 3
    }

    public static int euclid(int number1, int number2) {
        // 欧几里得 -- 辗转相除法，求两个数的最大公约数
        int remainder;

        while (number2 > 0) {
            remainder = number1 % number2;
            number1 = number2;
            number2 = remainder;
        }

        return number1;
    }
}
```

算法的时间复杂度 O(log N)

## 选择排序

选择排序（Selection Sort）是一种简单直观的排序算法。

它的基本思想是：首先在未排序的数列中**找到最小（或最大）的元素，然后将其存放到数列的起始位置**；接着，再从剩余未排序的元素中继续寻找最小（或最大）元素，然后放到已排序序列的末尾。以此类推，直到所有的元素排序完毕。

```java
public static void sort(int[] numbers) {
    int min;
    for (int i = 0, len = numbers.length; i < len; i++) {
        min = i;
        for (int j = i + 1; j < len; j++) {
            // 获取未排序元素中的最小值
            if (numbers[j] < numbers[min])
                min = j;
        }
        // 若 min != i，则交换 numbers[i] 和 numbers[min]
        if (min != i) {
            int tmp = numbers[i];
            numbers[i] = numbers[min];
            numbers[min] = tmp;
        }
    }
}
```

选择排序算法的平均时间复杂度：`O(N²)`，最坏情况下的时间复杂度：`O(N²)`，额外的空间复杂度：`O(1)`，稳定性：**不稳定**。

## 冒泡排序

冒泡排序（Bubble Sort），又称为起泡排序或者泡沫排序。

它是一种较简单的排序算法。它会遍历若干次要排序的序列，每次遍历时，它都会比较相邻两个数的大小；如果前者比后者大，则交换它们的位置。这样，**一次遍历结束，最大的元素就在数列的末尾**。采用相同的方法再次遍历时，第二大的元素就在最大元素之前。重复此操作，直到整个序列有序。

```java
public static void sort(int[] numbers) {
    // 从后往前开始遍历，每次外层循环结束，i 位置（当前最后）的元素为 0 - i 中最大的元素
    for (int i = numbers.length - 1; i > 0; i--) {
        for (int j = 0; j < i; j++) {
            if (numbers[j] > numbers[i]) {
                int tmp = numbers[j];
                numbers[j] = numbers[i];
                numbers[i] = tmp;
            }
        }
    }
}

/**
    * 优化策略：如果一趟排序中没有发生任何数据交换，说明数据已经是有序的了，直接终止循环。
    */
public static void optimize_sort(int[] numbers) {
    boolean flag;
    for (int i = numbers.length - 1; i > 0; i--) {
        flag = true;

        for (int j = 0; j < i; j++) {
            if (numbers[j] > numbers[i]) {
                int tmp = numbers[j];
                numbers[j] = numbers[i];
                numbers[i] = tmp;
                flag = false;
            }
        }

        if (flag) {
            break;
        }
    }
}
```

对冒泡排序还可以做一次优化：如果一趟遍历中没有发生过元素交换，则说明数列已经有序，跳出循环。

冒泡排序算法的平均时间复杂度：`O(N²)`，最坏情况下的时间复杂度：`O(N²)`，额外的空间复杂度：`O(1)`，稳定性：**稳定**。

## 插入排序

插入排序（Insertion Sort）类似于起牌，每次起到手里的牌都是有序的。

基本思想是：将 n 个待排序序列的元素看成一个有序表和一个无序表。开始有序表只包含一个元素，无序表包含 n - 1 个元素，排序过程中**每次从无序表中取出第一个元素，将它插入到有序表中的适当位置**，使之成为新的有序表，重复 n - 1 次即可完成排序过程。

```java
public static void sort(int[] numbers) {
    int j;
    for (int i = 1, len = numbers.length; i < len; i++) {
        // i 位置元素是待排序元素，i 前元素是有序序列
        int tmp = numbers[i];
        for (j = i; j > 0 && numbers[j - 1] > tmp; j--) {
            // 进行比较，移动元素，空出合适的位置
            // numbers[j - 1] > tmp 说明应将 numbers[j - 1] 后移
            // 如果 numbers[j - 1] < tmp，说明应插入元素位置为 j
            numbers[j] = numbers[j - 1];
        }
        numbers[j] = tmp;
    }
}
```

插入排序算法的平均时间复杂度：`O(N²)`，最坏情况下的时间复杂度：`O(N²)`，额外的空间复杂度：`O(1)`，稳定性：**稳定**。

## 希尔排序

希尔排序（Shell Sort）是插入排序的一种，它是针对插入排序算法的一种改进。该方法又称为缩小增量排序。

希尔排序实质上是一种分组插入方法，它的基本思想是：对于 n 个元素的待排序序列，取一个小于 n 的整数 gap 将待排序序列分为若干个子序列，所有距离为 gap 的倍数的记录放在同一个组中。然后，对各组内的元素进行插入排序。这一趟排序完成后，每一个组的元素都是有序的。然后减小 gap 的值，并重复执行上述分组和排序。重复这样的操作，当 gap 为 1 的时候，整个数列就是有序的。

```java
public static void sort(int[] numbers) {
    int k;
    for (int i = numbers.length / 2; i > 0; i /= 2) {
        for (int j = i; j < numbers.length; j++) {
            int tmp = numbers[j];
            for (k = j; k >= i && numbers[k - i] > tmp; k -= i) {
                numbers[k] = numbers[k - i];
            }
            numbers[k] = tmp;
        }
    }
}
```

希尔排序的时间复杂度与增量序列的选取有关。例如，当增量选为 1 的时候，希尔排序直接退化为直接插入排序，此时的时间复杂度为 O(N²)；而 Hibbard 增量序列的希尔排序的时间复杂度为 O(N^3/2)。

希尔排序算法的平均时间复杂度：`O(N^d)`，最坏情况下的时间复杂度：`O(N²)`，额外的空间复杂度：`O(1)`，稳定性：**不稳定**。

## 堆排序

堆排序（Heap Sort）是指利用堆这种数据结构所设计的一种排序算法。

堆分为`最大堆`和`最小堆`，最大堆通常被用来进行升序排序，最小堆通常被用来进行降序排序。

Java 中优先队列内部就是堆实现，我们只需要在创建的时候传入一个比较器即可指定最大堆或者最小堆。

```java
public static void sort(int[] numbers) {
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Comparator.comparing(Integer::intValue));

    for (int number : numbers) {
        heap.add(number);
    }

    for (int i = 0; i < numbers.length; i++) {
        numbers[i] = heap.poll();
    }
}
```

堆排序算法的平均时间复杂度：`O(N log N)`，最坏情况下的时间复杂度：`O(N log N)`，额外的空间复杂度：`O(1)`，稳定性：**不稳定**。

## 归并排序

将两个有序数列合并成一个有序树列，我们称之为“归并”。

归并排序（Merge Sort）就是利用归并思想对数列进行排序。根据具体实现，归并排序包括“从下往上”和“从上往下”两种方式。

1. 从下往上的归并排序

将待排序的数列分成若干个长度为 1 的子数列，然后将这些数列两两合并，得到若干长度为 2 的数列，再将这些数列两两合并；直到合并为一个数列为止。这样就得到了我们想要的排序结果。

2. 从上往下的归并排序

第一步：将当前区间一分为二

第二步：递归地对两个区间进行归并排序，递归的终结条件是子区间的长度为 1

第三步：将已排序的两个子区间归并为一个有序的区间

```java
// 自顶向下排序
public static void sortUp2Down(int[] numbers) {
    sortUp2Down(numbers, 0, numbers.length - 1);
}

// 自底向上排序
public static void sortDown2Up(int[] numbers) {
    if (numbers == null) {
        return;
    }
    for (int i = 1, len = numbers.length; i < len; i *= 2) {
        sortDown2Up(numbers, len, i);
    }
}

private static void sortUp2Down(int[] numbers, int start, int end) {
    if (numbers == null || start >= end) {
        return;
    }
    int mid = start / 2 + end / 2;
    sortUp2Down(numbers, start, mid);
    sortUp2Down(numbers, mid + 1, end);

    merge(numbers, start, mid, end);
}

private static void sortDown2Up(int[] numbers, int len, int gap) {
    int twoLen = gap * 2;
    int i;
    // 将每两个相邻的子数组进行归并
    for (i = 0; i + twoLen - 1 < len; i += twoLen) {
        merge(numbers, i, i + gap - 1, i + twoLen - 1);
    }

    // 若 i + gap - 1 < len - 1，则剩余一个子数组没有配对
    // 将该子数组归并到已排序的数组中
    if (i + gap - 1 < len - 1) {
        merge(numbers, i, i + gap - 1, len - 1);
    }
}

// 合并一个数组中的两个相邻有序区间
private static void merge(int[] numbers, int start, int mid, int end) {
    int[] tmp = new int[end - start + 1];
    int t = 0;  // tmp 数组的索引
    int i = start;
    int j = mid + 1;

    while (i <= mid && j <= end) {
        if (numbers[i] <= numbers[j]) {
            tmp[t++] = numbers[i++];
        } else {
            tmp[t++] = numbers[j++];
        }
    }
    while (i <= mid) {
        tmp[t++] = numbers[i++];
    }
    while (j <= end) {
        tmp[t++] = numbers[j++];
    }

    System.arraycopy(tmp, 0, numbers, start, t);
}
```

归并排序算法的平均时间复杂度：`O(N log N)`，最坏情况下的时间复杂度：`O(N log N)`，额外的空间复杂度：`O(N)`，稳定性：**稳定**。

## 快速排序

快速排序（Quick Sort）使用分治策略。

它的基本思想是：选择一个基准数，通过一趟排序，将要排序的数据分割成独立的两部分。其中一部分的所有数据都比基准数大，而另一部分的所有数据都比基准数小。然后，再按照此方法对两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数列都变为有序序列。

快速排序流程：

1. 从数列中选出一个基准值
1. 将所有比基准值小的数放在基准值前面，所有比基准值大的元素放在基准值后面（相同的数可以放到任一边）；在这个分区退出后，该基准值就处于数列的中间位置（正确位置）
1. 递归的对“基准值前的子数列”和“基准值后的子序列”进行快速排序

```java
public static void sort(int[] numbers) {
    sort(numbers, 0, numbers.length - 1);
}

private static void sort(int[] numbers, int left, int right) {
    if (left < right) {
        int i = left, j = right;
        int pivot = pivot(numbers, left, right);
        while (i < j) {
            // 从右向左找第一个小于 pivot 的数
            while (i < j && numbers[j] > pivot)
                j--;
            // 交换到 left 的位置
            if (i < j)
                numbers[i++] = numbers[j];
            // 从左往右找第一个大于 pivot 的数
            while (i < j && numbers[i] < pivot)
                i++;
            // 交换到 j 的位置
            if (i < j)
                numbers[j--] = numbers[i];
        }
        numbers[i] = pivot;
        sort(numbers, left, i - 1);
        sort(numbers, i + 1, right);
    }
}

// 获取头、中、尾的中位数
private static int pivot(int[] numbers, int start, int end) {
    int n1 = numbers[start], n2 = numbers[start / 2 + end / 2], n3 = numbers[end];
    return n1 < n2 ? (n2 < n3 ? n2 : (n1 < n3 ? n3 : n1)) : (n2 > n3 ? n2 : (n3 > n1 ? n1 : n3));
//	List<Integer> list = new ArrayList<>(Arrays.asList(numbers[start], numbers[start / 2 + end / 2], numbers[end]));
//	list.sort(Integer::compareTo);
//	return list.get(1);
}
```

快速排序算法的平均时间复杂度：`O(N log N)`，最坏情况下的时间复杂度：`O(N²)`，额外的空间复杂度：`O(log N)`，稳定性：**不稳定**。

## 桶排序

桶排序（Bucket Sort）的原理很简单，它是将数组分到有限数量的桶里去。

假设待排序数列中共有 N 个元素，并且已知数组中元素的范围[0, MAX)。创建容量为 MAX 的桶数组，并将桶数组元素初始化为 0，将容量为 MAX 的桶数组中的每一个元素都看作一个 “桶”。

在排序时，逐个遍历数列，用数列元素的值，作为桶数组的下标。当数列中元素被读取时，将桶的值加 1。

```java
private static final int MAX = 100;

public static void sort(int[] numbers) {
    int[] buckets = new int[MAX];
    Arrays.fill(buckets, 0);

    // 计数
    for (int i = 0, len = numbers.length; i < len; i++) {
        buckets[numbers[i]]++;
    }

    // 排序
    for (int i = 0, j = 0; i < MAX; i++) {
        while ((buckets[i]--) > 0) {
            numbers[j++] = i;
        }
    }
}
```

桶排序算法的平均时间复杂度是：O(MAX + N)

## 基数排序

基数排序（Radix Sort）是桶排序的扩展，它的基本思想是：将整数按位分割为不同的数字，然后按每个位数进行比较。

具体做法是：将所有待比较的值统一为同样的数位长度，数位短的前面补 0。然后，从最低位开始，依次进行依次排序，这样从最低位排序一直到最高位排序完成以后，数列就变成了一个有序序列。

```java
public static void sort(int[] numbers) {
    int max = max(numbers);
    // 使用队列来作为桶数组中的桶，桶数组的大小为 10，因为有十个数字
    List<Queue<Integer>> buckets = new ArrayList<>(10);
    for (int i = 0; i < 10; i++) {
        // 初始化队列
        buckets.add(new ArrayDeque<>());
    }

    for (int exp = 1; max / exp > 0; exp *= 10) {
        for (int number : numbers) {
            // 获得 number 的最低位，存入队列
            int mod = (number / exp) % 10;
            buckets.get(mod).add(number);
        }
        int j = 0;
        // 从队列中取出元素到 numbers 数组
        for (Queue<Integer> bucket : buckets) {
            while (!bucket.isEmpty()) {
                numbers[j++] = bucket.poll();
            }
        }
    }
}

private static int max(int[] numbers) {
    int max = numbers[0];
    for (int number : numbers) {
        if (number > max) {
            max = number;
        }
    }
    return max;
}
```

基数排序算法的平均时间复杂度：`O(P(N + B))`，最坏情况下的时间复杂度：`O(P(N + B))`，额外的空间复杂度：`O(N + B)`，稳定性：**稳定**。

## 散列

Hash 最重要的就是 **Hash函数** 和 **冲突解决**

### 数字关键词的散列函数

1. 直接定址法

取关键词的某个线性函数值为散列地址，即：

`h(key) = a * key + b (a, b 为常数)`

2. 除留余数法

`h(key) = key mod p (一般取 p 为素数)`

3. 数字分析法

分析数字关键字在各位上的变化情况，取比较随机的位数作为散列地址

例如，取 11 位手机号码 key 的后 4 位作为地址：

`h(key) = atoi(key + 7)`

4. 折叠法

把关键词分割为位数相同的几部分，然后叠加

例如：`56793542` => `542 + 793 + 056 = 1391` => `h(key) = 391`

5. 平方取中法

将关键词平方，然后取中间的某几位

例如：`56793542² = 3225506412905764` => `h(key) = 641`

### 字符关键词的散列函数

1. ASCII 码加和法

`h(key) = (∑key[i]) mid TableSize`

2. 前三字符移位法

`h(key) = (key[0]*27² + key[1]*27 + key[2]) mod TableSize`

3. 移位法

`h(key) = (∑(i=0, ... , n-1) key(n - i - 1) * 32^i) mod TableSize`

### 冲突处理

1. 开放定址法

若发生了第 i 次冲突，试探的下一个地址将增加 di, 基本公式是：

`hi(key) = (h(key) + di) mod TableSize`

di 决定了不同的解决方案：线性探测、平方探测、双散列

> 1. 线性探测：di = i
> 1. 平方探测：di = ±i²
> 1. 双散列：di = i * h2(key)


2. 分离链接法

将相应位置上冲突的所有关键词存储在同一个单链表中。

3. 再散列

如果表过大（即装填因子α太大），查找效率会下降。实际测试证明，装填因子一般取：
 
`0.5 <= α <= 0.85`

解决方法是 **再散列**：新建一个更大的表，将原来的表中的元素重新 hash 到新表。

## 单例模式

五种单例模式的实现与优缺点，更详细的说明在具体文件中。

### 1. 简单实现

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

特点：实现简单，非线程安全。

## 2. 线程安全的单例

```java
public class ConcurrentSingleton {
    private static ConcurrentSingleton instance = null;
    
    private ConcurrentSingleton() {}
    
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
```

特点：使用 **synchronized** 关键字确保线程安全。

## 3. 完全线程安全的单例模式

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

特点：使用 **volatile** 关键字阻止 JVM 的指令重排，确保不会因为不想要的优化而产生错误。

## 4. 静态内部类实现

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

特点：是线程安全的单例模式，但是无法阻止利用反射重复创建实例对象。

## 5. Enum实现

```java
public enum EnumSingleton {
    INSTANCE;
}
```

特点：利用 Enum 语法糖，不仅会禁止利用反射重复创建实例，还保证线程安全。唯一的缺点是并非是用懒加载。

## 删除链表结点

给定链表的头指针和一个结点指针，在 O（1）的时间删除该结点

思路：使用下一个结点的数据覆盖要删除的结点，然后删除下一个结点

```java
public void deleteNode(Node node) {
    assert node != null;
    assert node.next != null; // 不能是尾结点

    Node nextNode = node.next;
    node.data = nextNode.data;
    node.next = nextNode.next;
}
```

## 判断链表中是否有环

使用快慢指针：

1. 如果遇到 null，则退出，说明没有环
1. 如果**快指针遇到慢指针**或者**快指针跑到慢指针后面**，说明有环

```java
public boolean hasCircle(Node head) {
    Node fast = head;
    Node slow = head;

    while (true) {
        if (fast == null || fast.next == null) {
            // 如果链表中有空，即到尽头
            return false;
        } else {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast == slow || fast.next == slow) {
            // 如果快慢指针相遇或者快指针跑到慢指针后边，说明有环
            return true;
        }
    }
}
```

## 单链表转置

循环方式：

```java
public Node reverseByLoop(Node head) {
    if (head == null || head.next == null) {
        return head;
    }

    Node ret = null, next = null;
    while (head != null) {
        next = head.next;   // 保存下一个结点的位置
        head.next = ret;    // 现在的结点接到新链表的头部
        ret = head;         // 重置新链表的头部指针
        head = next;        // head 往后移动
    }

    return ret;
}
```

思路是：每次断开一个结点，接到新链表上。

递归方式：

```java
public Node reverseByRecursion(Node head) {
    if (head == null || head.next == null) {
        return head;
    }

    Node node = head.next;
    // 将 head 结点断开
    head.next = null;
    // 对剩下的结点递归调用反转
    Node reverse = reverseByRecursion(node);
    // 将 head 结点接到转置后链表的末尾
    node.next = head;
    // 返回转置后的链表
    return reverse;
}
```

思路是：每次断开头结点，对剩下的结点递归调用转置函数，然后再将头结点接到转置后的链表末尾。

## 中缀表达式转后缀表达式

实例：

`a + b * c + (d * e + f) * g` &nbsp;转换为&nbsp; `a b c * + d e * f + g * +`

转换的逻辑：

1. 遇到操作数，直接输出
1. 遇到 左括号，进栈
1. 遇到 右括号，将栈中元素弹出，直到遇到左括号为止。左括号不输出
1. 遇到其他操作符，从栈中弹出元素直到遇到更低优先级的元素（或栈为空），然后将操作符入栈
1. 左括号 直到遇到 右括号 的时候才弹出，遇到普通操作符不弹出
1. 读到输入的末尾，将栈中剩余的元素依次弹出

```java
/**
 * 入栈判断。
 * 1、栈顶是左括号，直接入栈
 * 2、输入是乘除，栈顶是加减，入栈
 * 3、其他情况，栈顶元素出栈
 */
private static boolean compare(String input, String top) {
    return "(".equals(top) || ("*".equals(input) || "/".equals(input)) && ("+".equals(top) || "-".equals(top));
}

public static void convert(String input) {
    String[] strings = input.split(" ");
    Stack<String> stack = new Stack<>();

    for (String string : strings) {
        if ("(".equals(string)) {
            // 遇到左括号，直接入栈
            stack.push(string);
        } else if (")".equals(string)) {
            // 遇到右括号，弹出元素直到弹出对应的左括号
            String top;
            while (!stack.isEmpty()) {
                top = stack.pop();
                if (top.equals("("))
                    // 弹出了左括号，停止循环
                    break;
                else
                    System.out.print(top + " ");
            }
        } else if ("+-*/".contains(string)) {
            // 普通操作符
            if (stack.isEmpty()) {
                // 栈为空时直接入栈
                stack.push(string);
            } else {
                String top = stack.peek();
                if (compare(string, top)) {
                    // 判断栈顶元素优先级比操作符低，直接入栈
                    stack.push(string);
                } else {
                    // 栈顶元素优先级比操作符高，依次弹出
                    while (!stack.isEmpty()) {
                        top = stack.peek();
                        if (!compare(string, top)) {
                            // 先取栈顶元素进行比较，再弹出的原因是避免 左括号（ 被误弹出
                            System.out.print(stack.pop() + " ");
                        } else {
                            break;
                        }
                    }
                    // 现在栈顶元素的优先级比操作符低，操作符入栈
                    stack.push(string);
                }
            }
        } else {
            // 数字，直接输出
            System.out.print(string + " ");
        }
    }

    // 输出栈中剩余元素
    while (!stack.isEmpty()) {
        System.out.print(stack.pop() + " ");
    }
}
```

## 后缀表达式求值

直接弹出元素计算，然后重新压入栈即可。其中需要注意的一点是左右操作数的顺序：左操作数先入栈，右操作数后入栈；右操作数先出栈，左操作数后出栈。

```java
public static int compute(String suffix) {
    String[] strings = suffix.split(" ");
    Stack<Integer> stack = new Stack<>();
    for (String string : strings) {
        if (string.matches("\\d+")) {
            stack.push(Integer.valueOf(string));
        } else {
            if (stack.isEmpty()) {
                return -1;
            }

            int num1 = stack.pop();
            int num2 = stack.pop();
            int result = 0;
            switch (string) {
                // 其中 num2 和 num1 的顺序不能乱。因为中缀表达式转后缀表达式的时候，左操作数（操作符左侧）先入栈，右操作数后入栈。所以 pop 的时候右操作数先出栈，左操作数后出栈
                case "+":
                    result = num2 + num1;
                    break;
                case "-":
                    result = num2 - num1;
                    break;
                case "*":
                    result = num2 * num1;
                    break;
                case "/":
                    result = num2 / num1;
                    break;
            }
            stack.push(result);
        }
    }

    if (stack.size() == 1) {
        return stack.pop();
    } else {
        return -1;
    }
}
```

## 协议

[MIT](LICENSE)
