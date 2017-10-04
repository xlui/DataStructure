# 栈


class Stack(object):
    def __init__(self):
        self.stack = []

    def is_empty(self):
        return self.size() == 0

    def size(self):
        return len(self.stack)

    def push(self, item):
        self.stack.append(item)

    def pop(self):
        if self.is_empty():
            raise IndexError("Pop from empty stack")
        return self.stack.pop()

    def peek(self):
        return self.stack[-1]


class UseStack:
    @staticmethod
    def match(i, j):
        opens = '([{'
        closes = ')]}'
        return opens.index(i) == closes.index(j)

    def syntax_check(self, string):
        self.stack = Stack()
        passed = True
        for s in string:
            if s in '([{':
                self.stack.push(s)
            elif s in ')]}':
                if self.stack.is_empty():
                    passed = False
                    break
                else:
                    t = self.stack.pop()
                    if not UseStack.match(t, s):
                        passed = False
                        break
        if not self.stack.is_empty():
            passed = False
        return passed

    def decimal_to_binary(self, decimal):
        self.stack = Stack()
        current = decimal
        while current > 0:
            binary_digit = current % 2
            current //= 2
            self.stack.push(binary_digit)
        binary = ''
        while not self.stack.is_empty():
            binary += str(self.stack.pop())
        return binary

    def infix_to_postfix(self, infix):
        operator = {
            '*': 3,
            '/': 3,
            '+': 2,
            '-': 2,
            '(': 1,
        }
        self.stack = Stack()
        postfix = ''
        for i in infix:
            if i not in operator and i != ')':
                postfix += i
            elif i == '(':
                self.stack.push(i)
            elif i == ')':
                top = self.stack.pop()
                while top != '(':
                    postfix += top
                    top = self.stack.pop()
            else:
                while not self.stack.is_empty() and operator[i] <= operator[self.stack.peek()]:
                    postfix += self.stack.pop()
                self.stack.push(i)
        while not self.stack.is_empty():
            postfix += self.stack.pop()
        return postfix

    def postfix_exp(self, postfix):
        def math(operator, oper1, oper2):
            if operator == '+':
                return float(oper1) + float(oper2)
            if operator == '-':
                return float(oper1) - float(oper2)
            if operator == '*':
                return float(oper1) * float(oper2)
            if operator == '/':
                return float(oper1) // float(oper2)

        self.stack = Stack()
        for i in postfix:
            if i not in '+-*/':
                self.stack.push(i)
            else:
                oper1 = self.stack.pop()
                oper2 = self.stack.pop()
                result = math(i, oper2, oper1)
                self.stack.push(result)
        return self.stack.pop()


if __name__ == '__main__':
    t = UseStack()
    print('test {()]:', t.syntax_check('{()]'))
    print('test {()}:', t.syntax_check('{()}'))
    print('test decimal to binary: decimal_to_binary(10) =', t.decimal_to_binary(10))
    print('test decimal to binary: decimal_to_binary(13d) =', t.decimal_to_binary(13))
    print('test infix to postfix: infix_to_postfix("1+2*3-4") =', t.infix_to_postfix('1+2*3-4'))
    print('test postfix exp: postfix_exp("123*+4-") =', t.postfix_exp('123*+4-'))
