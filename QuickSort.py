# 快速排序
import random


class QuickSort:
    def quick_sort1(self, a_list):
        less, pivot_list, more = [], [], []
        if len(a_list) <= 1:
            return a_list
        else:
            pivot = a_list[0]
            for i in a_list:
                if i < pivot:
                    less.append(i)
                elif i > pivot:
                    more.append(i)
                else:
                    pivot_list.append(i)

            less = self.quick_sort1(less)
            more = self.quick_sort1(more)

            return less + pivot_list + more
        # 示例
        # l = [42, 84, 67, 6, 12, 85, 27, 93, 41, 12]
        # pivot = 42
        # less = [6, 12, 27, 41, 12]
        # more = [84, 67, 85, 93]
        # pivot_list = [42]
        # return quick_sort1(less) + [42] + quick_sort1(more)
        # = return [6, 12, 12, 27, 41] + quick_sort1(more)

        # quick_sort1(less) == quick_sort1([6, 12, 27, 41, 12])
        # pivot = 6
        # less = []
        # more = [12, 27, 41, 12]
        # pivot_list = [6]
        # return [] + [6] + quick_sort1(more)
        # = return [6] + [12, 12, 27, 41]
        # = return [6, 12, 12, 27, 41]

        # quick_sort1(more) == quick_sort1([12, 27, 41, 12])
        # pivot = 12
        # less = []
        # more = [27, 41]
        # pivot_list = [12, 12]
        # return [] + [12, 12] + quick_sort1(more)
        # = return [] + [12, 12] + [27] + [41]
        # = return [12, 12, 27, 41]

    def quick_sort2(self, a_list):
        return (self.quick_sort2([y for y in a_list[1:] if y < a_list[0]]) +
                a_list[:1] +
                [y for y in a_list[1:] if y == a_list[0]] +
                self.quick_sort2([y for y in a_list[1:] if y > a_list[0]])) \
            if len(a_list) > 1 else a_list

    def quick_sort3(self, a_list):
        if len(a_list) < 1:
            return a_list
        else:
            pivot = a_list[0]
            less = [x for x in a_list if x < pivot]
            more = [x for x in a_list[1:] if x >= pivot]
            return self.quick_sort3(less) + [pivot] + self.quick_sort3(more)

    def quick_sort4(self, a_list):
        if len(a_list) < 1:
            return a_list
        else:
            pivot = random.choice(a_list)
            return self.quick_sort4([elem for elem in a_list if elem < pivot]) + \
                   a_list.count(pivot) * [pivot] + \
                   self.quick_sort4([elem for elem in a_list if elem > pivot])

    def quick_sort5(self, a_list):
        qs = lambda list_: ((len(list_) <= 1 and [list_]) or \
                           [qs([x for x in list_[1:] if x < list_[0]]) +
                            [list_[0]] +
                            qs([x for x in list_[1:] if x >= list_[0]])])[0]
        return qs(a_list)


if __name__ == '__main__':
    l = [random.randint(0, 100) for _ in range(10)]
    t = QuickSort()
    print('要排序的数组：', l)
    print('排序后的数组：', t.quick_sort5(l))
