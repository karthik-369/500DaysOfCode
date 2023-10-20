/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * type NestedInteger struct {
 * }
 *
 * // Return true if this NestedInteger holds a single integer, rather than a nested list.
 * func (this NestedInteger) IsInteger() bool {}
 *
 * // Return the single integer that this NestedInteger holds, if it holds a single integer
 * // The result is undefined if this NestedInteger holds a nested list
 * // So before calling this method, you should have a check
 * func (this NestedInteger) GetInteger() int {}
 *
 * // Set this NestedInteger to hold a single integer.
 * func (n *NestedInteger) SetInteger(value int) {}
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 * func (this *NestedInteger) Add(elem NestedInteger) {}
 *
 * // Return the nested list that this NestedInteger holds, if it holds a nested list
 * // The list length is zero if this NestedInteger holds a single integer
 * // You can access NestedInteger's List element directly if you want to modify it
 * func (this NestedInteger) GetList() []*NestedInteger {}
 */

 type NestedIterator struct {
    answer []int
    ind int
}

func Constructor(nestedList []*NestedInteger) *NestedIterator {
    return &NestedIterator {
        answer : addList(nestedList),
        ind : 0,
    }

}

func addList(nl []*NestedInteger) []int {
    temp := make([]int, 0)
    for _, v := range nl {
        if v .IsInteger() {
            temp = append(temp, v.GetInteger())
        } else {
            temp = append(temp, addList(v.GetList())...)
        }
    }
    return temp
}

func (this *NestedIterator) Next() int {
    temp := this.answer[this.ind]
    this.ind++
    return temp
}

func (this *NestedIterator) HasNext() bool {
    return this.ind <(len(this.answer))
}