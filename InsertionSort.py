# 插入排序，每次循环，循环元素左边部分数组始终是有序的
import random


def insertion_sort(old_list):
    for i in range(1, len(old_list)):
        key = old_list[i]
        j = i - 1
        while j >= 0 and old_list[j] >= key:
            old_list[j + 1] = old_list[j]
            j -= 1
        old_list[j + 1] = key
    return old_list


if __name__ == '__main__':
    l = [random.randint(0, 100) for _ in range(10)]
    print('要排序的数组：', l)
    print('排序后的数组：', insertion_sort(l))
