package org.mastercs.bigdata.scala_lang.algorithms

import scala.collection.mutable.ListBuffer

/**
 * Author: matemaster
 * Create: 2023-04-10 14:43
 */
object QuickSort extends App {

    def quickSortNonRecursive(arr: Array[Int]): List[Int] = {
        // 创建一个栈来存储子数组的起始和结束索引
        val stack = new ListBuffer[(Int, Int)]()
        // 将初始子数组索引推入栈中
        stack += ((0, arr.length - 1))

        // 循环直到栈为空
        while (stack.nonEmpty) {
            // 从栈中弹出顶部子数组索引
            val (start, end) = stack.remove(stack.length - 1)
            // 对子数组进行分区并获取枢轴索引
            val pivotIndex = partition(arr, start, end)
            // 如果枢轴左侧有元素，则将子数组索引推入栈中
            if (pivotIndex - 1 > start) {
                stack += ((start, pivotIndex - 1))
            }
            // 如果枢轴右侧有元素，则将子数组索引推入栈中
            if (pivotIndex + 1 < end) {
                stack += ((pivotIndex + 1, end))
            }
        }

        // 返回排序后的数组
        arr.toList
    }

    def partition(arr: Array[Int], start: Int, end: Int): Int = {
        // 选择最后一个元素作为枢轴
        val pivot = arr(end)
        // 将枢轴索引初始化为起始索引
        var pivotIndex = start
        // 循环遍历子数组从起始索引到结束索引
        for (i <- start until end) {
            // 如果当前元素小于或等于枢轴，则将其与枢轴索引处的元素交换
            if (arr(i) <= pivot) {
                val temp = arr(i)
                arr(i) = arr(pivotIndex)
                arr(pivotIndex) = temp
                pivotIndex += 1
            }
        }
        // 将枢轴与枢轴索引处的元素交换
        val temp = arr(end)
        arr(end) = arr(pivotIndex)
        arr(pivotIndex) = temp
        // 返回枢轴索引
        pivotIndex
    }

    // 测试函数
    val arr = Array(5, 2, 9, 1, 5, 6)
    println("未排序的数组: " + arr.mkString(", "))
    quickSortNonRecursive(arr)
    println("排序后的数组: " + arr.mkString(", "))

    //测试结果：
    //未排序的数组: 5, 2, 9, 1, 5, 6
    //排序后的数组: 1, 2, 5, 5, 6, 9

    // 用list实现快排非递归算法
}
