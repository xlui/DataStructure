package question;

/**
 * 请实现一个函数，把字符串中的每个空格替换成 <code>%20</code>。例如输入
 * <code>We are happy.</code>，则输出 <code>We%20are%20happy.</code>。
 *
 * 如果我们直接替换空格，则每次替换都需要移动后面 n 个字符，因此对于有 n 个
 * 空格字符的字符串而言，时间复杂度为 O(n^2)。
 *
 * 如果确定原字符串空间足够容纳替换后的字符串，我们可以就地进行替换，从末尾
 * 开始替换。准备两个指针，p1 及 p2，p1 指向原字符串的末尾，p2 指向替换后
 * 的字符串末尾（可以先扫描一遍字符串计算出空格，从而得出替换后字符串长度），
 * 接下来我们向前移动 p1，逐个将它指向的字符复制到 p2 的位置。当遇到空格时，
 * p1 向前一格，p2 之前插入 <code>%20</code>，向前三格。
 */
public class ReplaceSpaces {
}
