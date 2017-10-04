# 选择排序
# 首先找出序列中的最大元素，与最后一个元素交换位置，然后找出次大元素，与倒数第二个元素交换位置，依次类推
import random


def selection_sort(old_list):
    for i in range(len(old_list) - 1, 0, -1):
        position_of_max = 0
        for j in range(1, i + 1):
            if old_list[j] >= old_list[position_of_max]:
                position_of_max = j
        old_list[position_of_max], old_list[i] = old_list[i], old_list[position_of_max]
    return old_list


if __name__ == '__main__':
    l = [random.randint(0, 100) for _ in range(10)]
    print('要排序的数组：', l)
    print('排序后的数组：', selection_sort(l))
