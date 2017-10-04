# 希尔排序
# 将数组按照一定间隔重复进行排序，间隔逐渐降低到 1。
import random


def shell_sort(a_list):
    length = len(a_list)
    gap = length // 2
    while gap >= 1:
        for j in range(gap, length):
            i = j
            while (i - gap) >= 0:
                if a_list[i] < a_list[i - gap]:
                    a_list[i], a_list[i - gap] = a_list[i - gap], a_list[i]
                    i -= gap
                else:
                    break
        gap //= 2
    return a_list


if __name__ == '__main__':
    l = [random.randint(0, 100) for _ in range(10)]
    print('要排序的数组：', l)
    print('排序后的数组：', shell_sort(l))
