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

算法：

1. 最大子序列和
1. 二分查找
1. 辗转相除法
1. 排序
1. 散列

设计模式：

1. 单例模式

一些问题：

1. O(1) 时间内删除链表结点
1. 判断链表中是否有环
1. 单链表转置

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
1. 如果两个斜堆都非空，那么比较两个根节点，取较小堆的根节点为新的根结点。并将较小堆的根结点的右孩子和较大堆进行合并
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

Dijkstra 算法是典型的最短路径算法，用于计算一个节点到其他节点的最短路径。它的主要特点是以起始点为中心向外层层层扩展（广度优先算法思想），直到扩展到终点为止。

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

首先构造一个只含 n 个节点的森林，然后依权值大小从连通网中选择边加入森林中，并使森林不产生回路，直至森林变成一棵树为止。

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
