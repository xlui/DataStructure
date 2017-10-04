# 冒泡排序
import random


def bubble_sort(old_list):
    for i in range(len(old_list) - 2, 0, -1):
        for j in range(i + 1):
            if old_list[j] > old_list[j + 1]:
                old_list[j], old_list[j + 1] = old_list[j + 1], old_list[j]
    return old_list


if __name__ == '__main__':
    l = [random.randint(0, 100) for _ in range(10)]
    print('要排序的数组：', l)
    print('排序后的数组：', bubble_sort(l))
