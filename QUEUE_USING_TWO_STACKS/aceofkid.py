# Enter your code here. Read input from STDIN. Print output to STDOUT
class Queue(object):
    def __init__(self):
        self.data_full = []

    def push(self, data):
        self.data_full.append(data)

    def pop(self):
        pop_data = self.data_full[0]
        self.data_full.remove(pop_data)
        return pop_data

    def print_head(self):
        print(self.data_full[0])

def queue_test():
    test_queue = Queue()
    queue_ops = {'1':test_queue.push, '2':test_queue.pop, '3':test_queue.print_head}
    query_num = int(input())
    for _ in range(query_num):
        line = input()
        if '1' in line:
            query_type, value= line.strip().split(' ')
            queue_ops[query_type](value) 
        else:
            query_type = line
            queue_ops[query_type]()

if __name__ == "__main__":
    queue_test()
