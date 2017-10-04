# 计数排序
# 思路前半部分与桶排序一样。
# 假设n个输入元素中每一个都是介于0到k之间的整数，此处k为某个整数。
# 创建大小为 k+1 ，默认值为 0 的数组 bucket，对于输入数组中的每个出现的元素，
# 在 bucket 数组中以元素的值为索引，以元素出现次数为值进行记录（与桶排序相同）。
# 然后通过遍历 bucket 数组，将每个元素的值更新为 小于其的个数（bucket[i] += bucket[i - 1]）
# 最后以 输入数组中某个元素（i）的出现次数（bucket[i]）为索引（bucket[i]-1）向返回数组（sorted_list）中插入 输入数组该元素的值（i）
# ps：为避免有重复元素导致插入在同一个位置，每次循环 bucket[i] 即元素出现次数减 1
import random


def counting_sort(old_list, max_number):
    length = len(old_list)
    sorted_list = [0 for _ in range(length)]
    bucket = [0 for _ in range(max_number + 1)]
    for i in old_list:
        bucket[i] += 1
    for i in range(1, len(bucket)):
        bucket[i] += bucket[i - 1]
    for i in old_list:
        sorted_list[bucket[i] - 1] = i
        bucket[i] -= 1
    return sorted_list


if __name__ == '__main__':
    l = [random.randint(0, 100) for i in range(10)]
    print('要排序的数组：\t', l)
    sorted_l = counting_sort(l, 100)
    print('排序过的数组：\t', sorted_l)
