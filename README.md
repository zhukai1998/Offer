# Offer
剑指 Offer 刷题

# 数据结构——时间复杂度和空间复杂度到底是什么
- 余愚钝，手抄博客[Coder编程](https://www.cnblogs.com/coder-programming/p/11093608.html)
- 前言
```
算法（Algorithm）是指用来操作数据、解决程序问题的一组方法。
对于同一个问题，使用不同的算法，也许最终得到的结果是一样的，但是在过程中消耗的资源和时间却会有很大的区别。
那么我们该如何去衡量不同算法之间的优劣呢？
主要还是从算法所占用的【时间】和【空间】两个维度去考量。
```
- 时间维度：是指执行当前算法所消耗的时间，通常用【时间复杂度】来描述
- 空间维度：是指执行当前算法需要占用多少内存空间，通常用【空间复杂度】来描述
```
评价一个算法的效率只要是看它的时间复杂度和空间复杂度情况。然而有时候时间和空间却又【鱼和熊掌】不可兼得，
那么需要取一个平衡点
```
- 算法的介绍
```
排序也称排序算法（Sort Algorithm），排序是将一组数据，依指定的顺序进行排列的过程。
排序分为
内部排序：将需要吃力的所有数据都架子啊到内部存储器（内存）中进行
外部排序：数据量过大，无法全部加载到内存中，需要借助外部存储进行排序
排序算法分为：
插入排序：直接插入排序、希尔插入排序
选择排序：简单选择排序、堆排序
交换排序：冒泡排序、快速排序
归并排序
基数排序
```
- 度量程序（算法）执行时间方法
```
事后统计的方法的问题：
    1、要想对设计的算法的运行性能进行评测，需要实际运行该程序；
    2、所得时间的统计量依赖于计算机的硬件、软件等环境因素
事前统计的方法：
    因事后统计方法更多地依赖于计算机的硬件、软件等环境因素，有时容易杨爱算法本身的优劣，因此人们常常采用事前分析估算的方法

在编写程序前，依据统计方法对算法进行估算。一个用高级语言编写的程序在计算机上运行所消耗的时间取决于下列因素：
    1、算法采用的策略、方法
    2、编译产生的代码质量
    3、问题的输入规模
    4、机器执行指令的速度
```
- 时间频度：一个算法花费的时间与算法中语句的额执行次数(n)成正比例，那个算法中语句执行次数(n)多，它花费的时间就多。一个算法中的语句执行次数成为语句频度或时间频度，记为T(n)。
- 计算 1 - 1000 所有整数的和，简单设计两种算法。
```Java
// TODO 第一个
int sum = 0;
int end = 1000;
// 使用 for 循环计算
for(int i = 1; i <= end; i ++)
	// 设执行次数为 n, 时间频度为：T(n) = n + 1
	sum += i;
System.out.println("使用 for 循环计算 1 - 1000 所有整数的和，其和为" + sum);

```
```Java
// TODO 第二个
int sum = 0;
int end = 1000;
// 直接计算, 设执行次数为 n, 时间频度为：T(n) = 1
sum = (1 + end) * end / 2;
System.out.println("直接计算 1 - 1000 所有整数的和，其和为" + sum);

```
- 显而易见，不同算法对同一问题得到同一结果所耗费的时间和空间相差巨大
- 时间频度

|  n  | T(n) = 2n + 20 | T(n) = 2n | T(n) = 3n + 10 | T(n) = 3n |
|-----|----------------|-----------|----------------|-----------|
|   1 |             22 |         2 |             13 |         3 |
|   2 |             24 |         4 |             16 |         6 |
|   5 |             30 |        10 |             25 |        15 |
|   8 |             36 |        16 |             34 |        24 |
|  15 |             50 |        30 |             55 |        45 |
|  30 |             80 |        60 |            100 |        90 |
| 100 |            220 |       200 |            310 |       300 |
| 300 |            620 |       600 |            910 |       900 |

1、T(n) = 2n + 20 和 T(n) = 2n 随着 n 变大，数值越来越接近，T(n) = 2n + 20 的 20 可以忽略不计
2、T(n) = 3n + 10 和 T(n) = 3n 随着 n 变大，数值越来越接近，T(n) = 3n + 10 的 10 可以忽略不计

| n | T(n) = 2n ^ 2 + 3n + 10 | T(n) = 2n ^ 2 | T(n) = n ^ 2 + 5n + 20 | T(n) = n ^ 2 |
|---|-------------------------|---------------|------------------------|--------------|
|   |                         |               |                        |              |