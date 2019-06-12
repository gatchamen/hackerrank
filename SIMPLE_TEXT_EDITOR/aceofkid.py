class SimpleTextEditior(object):
    def __init__(self):
        self.text = ""
        self.undo_stack = []
        self.editing_cmd = {"1": self.append_w, 
                            "2": self.delete_k,
                            "3": self.print_k,
                            "4": self.ndo}

    def append_w(self, str_w):
        self.undo_stack.append(self.text)
        self.text += str_w

    def delete_k(self, last_k):
        self.undo_stack.append(self.text)
        self.text = self.text[:-int(last_k)]

    def print_k(self, k):
        print(self.text[int(k)-1])

    def undo(self):
        self.text = self.undo_stack.pop()

    def run(self):
        operation_num = int(input().strip())
        for _ in range(operation_num):
            cmd = input().strip().split()
            if len(cmd) == 2:
                self.editing_cmd[cmd[0]](cmd[1])
            else:
                self.editing_cmd[cmd[0]]()

if __name__ == '__main__':
    app = SimpleTextEditior()
    app.run()
