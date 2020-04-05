# 剑指Offer 第三题
```
输入一个链表，按链表从尾到头的顺序返回一个 ArrayList
```

- 解题思路
```
一种是 ArrayList 遍历接收，翻转
一种是 栈的特性先入后出，完成逆序
一种是 递归实现（本质还是 堆栈结构）
```

- 代码
```Java
/**
 * TODO
 * ArrayList 遍历接收，翻转
 * 运行时间：20 ms
 * 占用内存：9580 k
 */
public ArrayList<Integer> printListFromTailToHead1(ListNode listNode)
{
	ArrayList<Integer> list = new ArrayList<Integer>();

	while(null != listNode)
	{
		list.add(listNode.val);
		listNode = listNode.next;
	}
	// 使用 Collections 的 reverse 方法，直接将 list 反转
	Collections.reverse(list);
	return list;
}

/**
 * TODO
 * 栈的特性先入后出，完成逆序
 * 运行时间：15 ms
 * 占用内存：9340 k
 */
public ArrayList<Integer> printListFromTailToHead2(ListNode listNode)
{
	Stack<Integer> stack = new Stack<>();
	while(null != listNode)
	{
		stack.add(listNode.val);
		listNode = listNode.next;
	}

	ArrayList<Integer> result = new ArrayList<>(stack.size());
	while(! stack.empty())
	{
		result.add(stack.pop());
	}
	return result;
}

/**
 * TODO
 * 递归
 * 运行时间：19 ms
 * 占用内存：9288 k
 */
public ArrayList<Integer> printListFromTailToHead3(ListNode listNode)
{
	ArrayList<Integer> list = new ArrayList<Integer>();

	ListNode pNode = listNode;

	if(null != pNode)
	{
		if(null != pNode.next)
			list = printListFromTailToHead3(pNode.next);
		list.add(pNode.val);
	}

	return list;
}

class ListNode
{
	int val;
	ListNode next = null;

	ListNode(int val)
	{
		this.val = val;
	}
}
```

# 链表
- 链表：链表是有序的列表，其时间复杂度：O(n)
1[image](./单链表示意图.png)
- 特点：
1、链表是以节点的方式来存储，是链式存储
2、每个节点包含 data 域，next 域：指向下一个节点
3、链表的各个节点不一定是连续存储
4、链表分 带头节点的链表 和 没有头节点的链表

应用场景：排行榜动态排序
1、在添加英雄时，直接添加到链表的尾部
思路分析


