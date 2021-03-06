# Offer
剑指 Offer 刷题

- [第一题：二维数组中的查找](./01/README.md)
- [第二题：替换空格](./02/README.md)
- [第三题：从尾到头打印链表](./03/README.md)

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
- 时间频度 - 忽略常数项

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

* T(n) = 2n + 20 和 T(n) = 2n 随着 n 变大，[ T(n) = 2n + 20 / T(n) = 2n ]数值比无限趋于 1，T(n) = 2n + 20 的 20 可以忽略不计
* T(n) = 3n + 10 和 T(n) = 3n 随着 n 变大，[ T(n) = 3n + 10 / T(n) = 3n ]数值比无限趋于 1，T(n) = 3n + 10 的 10 可以忽略不计

- 时间频度 - 忽略低次项

|  n  | T(n) = 2n ^ 2 + 3n + 10 | T(n) = 2n ^ 2 | T(n) = n ^ 2 + 5n + 20 | T(n) = n ^ 2 |
|-----|-------------------------|---------------|------------------------|--------------|
|   1 |                      15 |             2 |                     26 |            1 |
|   2 |                      24 |             8 |                     34 |            4 |
|   5 |                      75 |            50 |                     70 |           25 |
|   8 |                     162 |           128 |                    124 |           64 |
|  15 |                     505 |           450 |                    320 |          225 |
|  30 |                    1900 |          1800 |                   1070 |          900 |
| 100 |                   20310 |         20000 |                  10520 |        10000 |

* T(n) = 2n ^ 2 + 3n + 10 和 T(n) = 2n ^ 2 随着 n 变大，[ T(n) = 2n ^ 2 + 3n + 10 / T(n) = 2n ^ 2 ]数值比无限趋于 1，T(n) = 2n ^ 2 + 3n + 10 的 3n + 10 可以忽略
* T(n) = n ^ 2 + 5n + 20 和 T(n) = n ^ 2 随着 n 变大，[ T(n) = n ^ 2 + 5n + 20 / T(n) = n ^ 2 ]数值比无限趋于 1，T(n) = n ^ 2 + 5n + 20 的 5n + 20 可以忽略

- 时间频度 - 忽略系数

|  n  | T(n) = 3n ^ 2 + 2n | T(n) = 5n ^ 2 + 7n | T(n) = n ^ 3 + 5n | T(n) = 6n ^ 3 + 4n |
|-----|--------------------|--------------------|-------------------|--------------------|
|   1 |                  5 |                 12 |                 6 |                 10 |
|   2 |                 16 |                 34 |                18 |                 56 |
|   5 |                 85 |                160 |               150 |                770 |
|   8 |                208 |                376 |               552 |               3104 |
|  15 |                705 |               1230 |              3450 |              20310 |
|  30 |               2760 |               4710 |             27150 |             162120 |
| 100 |              30200 |              50700 |           1000500 |            6000400 |

* T(n) = 5n ^ 2 + 7n 和 T(n) = 3n ^ 2 + 2n，随着 n 变大，[ T(n) = 5n ^ 2 + 7n / T(n) = 3n ^ 2 + 2n ]数值比无限趋于 0，两个时间频度 T(n) 的系数 5 和 3 可以忽略
* T(n) = n ^ 3 + 5n 和 T(n) = 6n ^ 3 + 4n，随着 n 变大，[ T(n) = n ^ 3 + 5n / T(n) = 6n ^ 3 + 4n ]数值比无限趋于 0，两个时间频度 T(n) 的系数 1 和 6 可以忽略

- 时间复杂度

* 算法中的基本操作语句的重复执行次数是问题规模 n 的某个函数，记为 T(n)，若有某个辅助函数 f(n)，使得当 n 趋近于无穷大时，[ T(n) / f(n) ]的极限值为不等于 0 的常数，则称 f(n) 是 T(n) 的同数量级函数。记作 T(n) = O(f(n))，称 O(f(n)) 为算法的渐进时间复杂度，简称时间复杂度
* T(n) 不同，但时间复杂度可能相同。如：T(n) = n ^ 2 + 7n + 6 与 T(n) = 3n ^ 2 + 2n + 2 它们的 T(n) 不同，但时间复杂度相同，都为 O(n ^ 2)
* 计算时间复杂度的方法

```
[ T(n) = n ^ 2 + 7n + 6 ] 和 [ T(n) = n ^ 2 + 7n + 1 ] 时间复杂度比较
* 用常数 1 代替运行时间中的所有加法常数 [ T(n) = n ^ 2 + 7n + 6 ] => [ T(n) = n ^ 2 + 7n + 1 ]
* 修改后的运行次数函数中，只保留最高阶项 [ T(n) = n ^ 2 ] => [ T(n) = n ^ 2 ]
* 去除最高阶项的系数 [ T(n) = n ^ 2 ] => [ T(n) = n ^ 2 ] => [ O(n ^ 2) ] 
```

- 常见的时间复杂度

* 常数阶 O(1)
* 对数阶 O(log2 n)
* 线性阶 O(n)
* 线性对数阶 O(n log2 n)
* 平方阶 O(n ^ 2)
* 立方阶 O(n ^ 3)
* k 次方阶 O(n ^ k)
* 指数阶 O(2 ^ n)
```
* 常见的算法时间复杂度由小到大依次为：O(1) < O(log2n) < O(n) < O(nlog2n) < O(n ^ 2) < O(n ^ 3) < O(n ^ k) < O(2 ^ n)，
随着问题规模 n 的不断增大，上述时间复杂度不断增大，算法的执行效果越低
* 尽可能避免使用指数阶的算法
```

- 常数阶 O(1)
```Java
// 无论代码执行了多少行，只要是没有循环等复杂结构，那这个代码的时间复杂度就都是 O(1)
int temp;
int i = 2;
int j = 3;

temp = i;
i = j;
j = temp;

System.out.println("Hello World! " + (i + j));
// 上述代码在执行的时候，它消耗的时候并不随着某个变量的增长而增长，那么无论这类代码有多长，即使有几万几十万行，都可以用 O(1) 来表示它的时间复杂度
```

- 对数阶 O(log2 n)
```Java
int n = 1000;

int i = 1;

while (i <= n)
{
	i = i * 2;
}

System.out.println("Hello World! " + i);
/**
 * 在 while 循环里面，每次都将 i 乘以 2，如此循环，i 的值就无限趋近于 n。
 * 假设循环 x 次之后，i 就大于 n 了，此时这个循环就退出了。
 * 假设 2 的 x 次方等于 n，那么 x = log2 n 也就是说当循环 log2 n 次以后，这个代码就结束了。
 * 因此这个代码的时间复杂度：O(log2 n)。
 * O(log2 n)的这个 2 时间上根据代码变化的，若 i = i * 3，则是 O(log3 n)
 *
 */
```

- 线性阶 O(n)
```Java
int j = 0;

for(int i = 1; i <= n; i ++)
	j ++;

System.out.println("Hello World! " + j);
// for 循环里的代码会执行 n 遍，因此它消耗的时间是随着 n 的变化而变化的，因此这类代码都可以用 O(n) 来表示它的时间复杂度
```

- 线性对数阶 O(n log n)
```Java
int j = 0;

for(int i = 1; i <= n; i ++)
{
	j = 1;
	while(j < n)
	{
		j = j * 2;
	}	
}

System.out.println("Hello World! " + j);
// 线性对数阶 O(n log n) ：将时间复杂度为 O(log n) 的代码循环 n 遍，那么它的时间复杂度就是 n * O(log n),也就是 O(n log n)
```

- 平方阶 O(n ^ 2)
```Java
int x = 0;

for(int i = 1; i <= n; i ++)
{
	for(int j = 1; j <= n; j ++)
	{
		x = j;
		j ++;
	}
}

System.out.println("Hello World! " + x);
// 平方阶 O(n ^ 2)：如果把 O(n) 的代码再嵌套循环一遍，它的时间复杂度就是 O(n ^ 2)
// 如果将其中一层循环 n 改成 m，那它的时间复杂度就编程 O(mn)
```

- 立方阶 O(n ^ 3)
```
立方阶 O(n ^ 3) 相当于三层 n 循环
```

- K 次方阶 O(n ^ k)
```
K 次方阶 相当于 K 层 n 循环
```

- 平均时间复杂度：所有可能的输入实例均以等概率出现的情况的算法运行时间
- 最坏情况下的时间复杂度称为最坏时间复杂度。
```
一般讨论的时间复杂度均是最坏情况下的时间复杂度。
这么做的原因是：最坏情况下的时间复杂度是算法在任何输入实例上运行时间的界限，
这就保证了算法运行时间不会比最坏情况更长
```
- 平均时间复杂度和最坏时间复杂度是否一致。和算法有关

|   算法种类   |   最好情况  |   平均情况  |   最坏情况  | 空间复杂度 | 稳定性 |
|--------------|-------------|-------------|-------------|------------|--------|
| 直接插入排序 | O(n)        | O(n ^ 2)    | O(n ^ 2)    | O(1)       | 稳定   |
| 希尔排序     |             |             |             | O(1)       | 不稳定 |
| 直接选择排序 | O(n ^ 2)    | O(n ^ 2)    | O(n ^ 2)    | O(1)       | 不稳定 |
| 堆排序       | O(n log2 n) | O(n log2 n) | O(n log2 n) | O(1)       | 不稳定 |
| 冒泡排序     | O(n)        | O(n ^ 2)    | O(n ^ 2)    | O(1)       | 稳定   |
| 快速排序     | O(nlog2 n)  | O(log2 n)   | O(n ^ 2)    | O(nlog2 n) | 不稳定 |
| 归并排序     | O(nlog2 n)  | O(nlog2 n)  | O(log2 n)   | O(n)       | 稳定   |
| 基数排序     | O(d(n + r)) | O(d(n + r)) | O(d(n + r)) | O(r)       | 稳定       |

- 空间复杂度：通过计算算法所需的存储空间实现，算法的空间复杂度的计算公式：S(n) = O(f(n))，其中 n 为 问题的规模，f(n) 为语句关于 n 所占存储空间的函数。
```
1、一个算法的空间复杂度（Space Complexity）定义为该算法所耗费的存储空间，它也是问题规模 n 的函数
2、空间复杂度是对一个算法在运行过程中临时占用存储空间大小的量度。
有的算法需要占用的临时工作单元数与解决问题的规模 n 有关，它随着 n 的增大而增大，当 n 较大时，将占用较多的存储单元。
例如快速排序和归并排序算法，基数排序就属于这种情况
3、在做算法分析上，主要讨论的是时间复杂度。从用户使用体验上看，更看重的程序执行的速度，一些缓存产品（redis，memcache）和算法（基数排序）本质就是用空间换时间
```

- 举例
```
eg: 如何判断某年是不是闰年
方法一：写一个算法，每给一个年份，就可以通过该算法计算得到是否闰年的结果
方法二：先建立一个所有年份的数组，然后把所有的年份按下标的数字对应，如果是闰年，则此数组元素的值是 1，
如果不是元素的值则为 o，这样所谓的判断某一年是否为闰年就变成查找这个数组某一个元素的值的问题

第一种方法相比第二种方法来说很明显非常节省空间，但每一次查询都需要经过一系列的计算才能知道是否为闰年
第二种方法虽然需要在内存中存储所有年份的数组，但是每次查询只需要一次索引判断即可。

这就是空间和时间互换的例子，到底哪一种方法好，其实还是要看具体用在什么地方。
```