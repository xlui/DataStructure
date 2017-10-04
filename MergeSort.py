# 合并排序
# 将数组递归拆分成子数组进行排序，然后合并
import random


def merge_sort(a_list):
    if len(a_list) > 1:
        mid = len(a_list) // 2
        left = a_list[:mid]
        right = a_list[mid:]
        merge_sort(left)
        merge_sort(right)
        i, j, k = 0, 0, 0
        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                a_list[k] = left[i]
                i += 1
            else:
                a_list[k] = right[j]
                j += 1
            k += 1
        while i < len(left):
            a_list[k] = left[i]
            k += 1
            i += 1
        while j < len(right):
            a_list[k] = right[j]
            k += 1
            j += 1
    return a_list


if __name__ == '__main__':
    l = [random.randint(0, 100) for _ in range(10)]
    print('要排序的数组：', l)
    print('排序后的数组：', merge_sort(l))
