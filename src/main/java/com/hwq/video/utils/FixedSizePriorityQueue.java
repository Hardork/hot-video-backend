package com.hwq.video.utils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 获取固定大小的优先队列
 * @param <T>
 */
public class FixedSizePriorityQueue<T> {
    private final PriorityQueue<T> queue;
    private final int maxSize;

    public FixedSizePriorityQueue(int maxSize, Comparator<T> comparator) {
        this.maxSize = maxSize;
        this.queue = new PriorityQueue<>(maxSize, comparator);
    }



    public void offer(T element) {
        if (queue.size() < maxSize) {
            // 如果队列还没满，直接添加
            queue.offer(element);
        } else {
            // 如果队列已满，比较新元素和队列中最小的元素
            // 如果新元素比最小的元素大，则替换最小的元素
            if (queue.comparator().compare(element, queue.peek()) > 0) {
                queue.poll(); // 移除最小的元素
                queue.offer(element); // 添加新元素
            }
        }
    }

    public PriorityQueue<T> getQueue() {
        return queue;
    }

    public List<T> getList() {
        return new ArrayList<>(queue);
    }

}
