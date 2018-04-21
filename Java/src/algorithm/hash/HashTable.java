package algorithm.hash;

/**
 * Hash 最重要的就是 Hash函数 和 冲突解决
 *
 * <div>
 * <p>
 *     <strong>数字关键词散列函数</strong>
 *
 * 1、直接定址法
 *
 * 取关键词的某个线性函数值为散列地址，即 h(key) = a * key + b (a, b 为常数)
 *
 * 2、除留余数法
 *
 * h(key) = key mod p (一般取 p 为素数)
 *
 * 3、数字分析法
 *
 * 分析数字关键字在各位上的变化情况，取比较随机的位数作为散列地址
 *
 * 例如，取 11 位手机号码 key 的后 4 位作为地址
 *
 * 4、折叠法
 *
 * 把关键词分割为位数相同的几部分，然后叠加
 *
 * 5、平方取中法
 *
 * 将关键词平方，然后取中间的某几位
 * </p>
 *
 * <p>
 *     <strong>字符关键词的散列函数</strong>
 *
 *     1、ASCII 码加和法
 *
 *     h(key) = (∑key[i]) mid TableSize
 *
 *     2、前三字符移位法
 *
 *     h(key) = (key[0]*27² + key[1]*27 + key[2]) mod TableSize
 *
 *     4、移位法
 *
 *     h(key) = (∑(i=0, ... , n-1) key(n - i - 1) * 32^i) mod TableSize
 * </p>
 * </div>
 *
 * <div>
 *     冲突处理
 *
 *     <p>
 *          <strong>开放定址法</strong>
 *
 *          若发生了第 i 次冲突，试探的下一个地址将增加 di, 基本公式是：
 *          <code>hi(key) = (h(key) + di) mod TableSize</code>
 *
 *          di 决定了不同的解决方案：线性探测、平方探测、双散列
 *
 *          <p>线性探测：di = i</p>
 *          <p>平方探测：di = ±i²</p>
 *          <p>双散列：di = i * h2(key)</p>
 *     </p>
 *
 *     <p>
 *          <strong>分离链接法</strong>
 *
 *          将相应位置上冲突的所有关键词存储在同一个单链表中。
 *     </p>
 *
 *     <p>
 *         如果表过大（即装填因子α太大），查找效率会下降。实际测试证明，装填因子一般取：
 *         0.5 <= α <= 0.85
 *
 *         解决方法是<strong>再散列</strong>：
 *         新建一个更大的表，将原来的表中的元素重新 hash 到新表
 *     </p>
 * </div>
 */
public class HashTable {
	int hash(String key, int tableSize) {
		int h = 0, index = 0;
		while (index != key.length())
			h = (h << 5) + key.charAt(index++);
		return h % tableSize;
	}
}
