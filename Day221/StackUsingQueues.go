package main

import "container/list"

type MyStack struct {
	queue1 *list.List
	queue2 *list.List
	top    int
}

func Constructor() MyStack {
	return MyStack{
		queue1: list.New(),
		queue2: list.New(),
		top:    -1,
	}
}

func (stack *MyStack) Push(x int) {
	stack.queue1.PushBack(x)
	stack.top = x
}

func (stack *MyStack) Pop() int {
	to := -1
	if !stack.Empty() {
		for stack.queue1.Len() != 1 {
			elem := stack.queue1.Front()
			stack.queue1.Remove(elem)
			stack.queue2.PushBack(elem.Value)
		}
		toElem := stack.queue1.Front()
		stack.queue1.Remove(toElem)
		to = toElem.Value.(int)
		for stack.queue2.Len() != 0 {
			topElem := stack.queue2.Front()
			stack.queue2.Remove(topElem)
			stack.top = topElem.Value.(int)
			stack.queue1.PushBack(stack.top)
		}
	}
	return to
}

func (stack *MyStack) Top() int {
	return stack.top
}

func (stack *MyStack) Empty() bool {
	return stack.queue1.Len() == 0
}

func main() {
	stack := Constructor()
	stack.Push(1)
	stack.Push(2)
	fmt.Println(stack.Top()) // Output: 2
	fmt.Println(stack.Pop()) // Output: 2
	fmt.Println(stack.Empty()) // Output: false
}
