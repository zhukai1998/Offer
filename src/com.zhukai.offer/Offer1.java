package com.zhukai.offer;
/**
 * 在一个二维数组中（每一个一维数组的长度相同），每一行都按照从左往右递增的顺序排序，
 * 每一列都按照从上往下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * TODO
 * 设该整数为 x，二维数组为 y
 * 二维数组 y 中是否包含该整数 x，那就把二维数组 y 的数一个一个拿出来做比较，如果相等，则包含，如果不想等，则拿二维数组 y 中的下一个元素继续比较。
 * 但如果二维数组 y 中不包含整数 x，
 * 假设我们随机抽取一个元素跟整数 x 比较，若是相等，则包含，若是不等呢？再随机抽取一个元素？
 * 但如果二维数组 y 中不包含整数 x，
 * 由题可知，每个一维数组的最后一个元素最大，第一个元素最小，且二维数组 y 的第一个一维数组的每一个元素是各一维数组中相同位置元素中最小的，二维数组 y 的最后一个一维数组的每一个元素是各一维数组中相同位置元素中最大的
 * 所以，先拿二维数组 y 的第一个一维数组的最后一个元素跟整数 x 比较，若相同，则包含。
 * 若不等，分为：
 * 整数 x 大于二维数组 y 的第一个一维数组的最后一个元素
 * 整数 x 小于二维数组 y 的第一个一维数组的最后一个元素
 * 若是大于，则继续比较二维数组 y 的第二个一维数组的最后一个元素
 * 若是小于，则继续比较二维数组 y 的第一个一维数组的（该一维数组长度 - 1） 个元素
 */
public class Offer1
{
    public static void main(String[] args)
    {
        int [][] a = new int[][]{{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}, {4, 5, 6, 7}};
        new Offer1().find(3, a);
    }
    /**
     * 二维数组参考
     * {1, 2, 3, 4},
     * {2, 3, 4, 5},
     * {3, 4, 5, 6},
     * {4, 5, 6, 7}
     * @param target
     * @param array
     * @return
     */
    public boolean find(int target, int [][] array)
    {
        // 二维数组的长度，也就是一共有几行
        int rowArrayLength = array.length;
        // 一维数组的长度，也就是一共有几列
        int colArrayLength = array[0].length;
        // 二维数组的元素位置，也就是第几行
        int rowPosition = 0;
        // 一维数组元素位置，也就是第几列。因为数组下标从 0 开始，所以一维数组的最后一个元素的下标 = 一维数组长度 - 1
        int colPosition = colArrayLength - 1;
        // 在数组越界的异常的范围内循环拿一维数组中最大的元素，跟整数比较
        while(rowPosition <= rowArrayLength - 1 && colPosition >= 0)
        {
            // 相等，则包含
            if(target == array[rowPosition][colPosition])
                return true;
                // 小于，则继续比较第 （一维数组长度 - 1）个元素，这里更改该一维数组第几个元素，也就是第几列的值，进入下一次循环中比较
            else if(target < array[rowPosition][colPosition])
                colPosition --;
                // 大于，则继续比较二维数组下一个一维数组的最大元素，这里更改该二维数组的第几个元素，也就是第几行的值，进入下一次循环中比较
            else
                rowPosition ++;
        }
        return false;
    }
}
