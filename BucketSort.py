# 桶排序
# 如果一个数组 A，包含 N 个整数，值从 1 到 M，那么我们可以得到一种非常快的排序，桶排序。
# 留置一个数组，里面有 M 个桶，初始化为 0
# 然后遍历数组 A，读入 Ai 时，S[Ai]增一。
# 所有输入被读入后，扫描数组 S 得出排好的表
# 该算法时间花费 O(M+N)，空间上不能原地排序

import random


class BucketSort(object):
    def _max(self, old_list):
        _max = old_list[0]
        for i in old_list:
            if i > _max:
                _max = i
        return _max

    def _min(self, old_list):
        _min = old_list[0]
        for i in old_list:
            if i < _min:
                _min = i
        return _min

    def sort(self, old_list):
        # 节约空间的桶排序
        _max = self._max(old_list)
        _min = self._min(old_list)

        s = [0 for i in range(_min, _max + 1)]
        # 创建的 s 数组大小是 max-min+1 ，相较于原始的排序方法节省了 min-1 的空间
        # 这种方式创建的 s 数组，在存入元素时要以 元素的值-min 作为索引
        for i in old_list:
            s[i - _min] += 1

        current = _min
        # 同时，在向原始数组中存入数据时也要以值的方式存入
        index = 0
        for i in s:
            while i > 0:
                old_list[index] = current
                index += 1
                i -= 1
            current += 1

    def bucket_sort(self, old_list):
        # 原始桶排序的实现
        # 这种做法创建的 s 数组可能会过大，导致其中 9 成元素未使用，所以使用上一个函数的实现来节约空间
        _max = self._max(old_list)
        s = [0 for i in range(_max + 1)]
        # 创建一个 max+1 大小的数组用于记录原始数组中元素出现的次数
        for i in old_list:
            s[i] += 1
        index = 0
        for i in range(len(s)):
            # 以索引遍历数组，当某个索引对应的值非 0 时，向原始数组写入新元素（本次的索引）
            # 同时原始数组的索引自增
            tmp = s[i]
            while tmp > 0:
                old_list[index] = i
                index += 1
                tmp -= 1

    def __call__(self, old_list):
        self.bucket_sort(old_list)
        return old_list


if __name__ == '__main__':
    l = [random.randint(0, 100) for i in range(10)]
    print('要被桶排序列表为：\t', l)
    BucketSort()(l)
    print('排序后的列表为：\t', l)
