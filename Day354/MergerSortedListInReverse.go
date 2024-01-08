package main

import "fmt"

type Node struct {
    data int
    next *Node
}

func reverse(root *Node) *Node {
    var current, prev, next *Node
    current = root
    for current != nil {
        next = current.next
        current.next = prev
        prev = current
        current = next
    }
    return prev
}

func solve(root1, root2 *Node) *Node {
    if root1 == nil {
        return root2
    }
    if root1 != nil && root2 != nil {
        if root1.data < root2.data {
            root1.next = solve(root1.next, root2)
            return root1
        } else {
            root2.next = solve(root1, root2.next)
            return root2
        }
    }
    return root1
}

func mergeResult(node1, node2 *Node) *Node {
    temp := solve(node1, node2)
    return reverse(temp)
}

func printList(node *Node) {
    for node != nil {
        fmt.Print(node.data, " ")
        node = node.next
    }
    fmt.Println()
}

func main() {
    var t, N, M, value int
    fmt.Scan(&t)

    for t > 0 {
        fmt.Scan(&N, &M)
        var node1, node2, temp1, temp2 *Node

        for i := 0; i < N; i++ {
            fmt.Scan(&value)
            newNode := &Node{data: value}
            if node1 == nil {
                node1 = newNode
                temp1 = node1
            } else {
                temp1.next = newNode
                temp1 = temp1.next
            }
        }

        for i := 0; i < M; i++ {
            fmt.Scan(&value)
            newNode := &Node{data: value}
            if node2 == nil {
                node2 = newNode
                temp2 = node2
            } else {
                temp2.next = newNode
                temp2 = temp2.next
            }
        }

        result := mergeResult(node1, node2)
        printList(result)

        t--
    }
}
