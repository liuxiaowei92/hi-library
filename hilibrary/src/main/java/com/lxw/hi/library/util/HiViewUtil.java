package com.lxw.hi.library.util;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @authour
 * @function
 * @date 2021/2/20
 */
public class HiViewUtil {

    /**
     * 获取指定类型的子View
     *
     * @param group ViewGroup
     * @param cls   如：RecyclerView.class
     * @param <T>
     * @return 指定类型的view
     */
    public static <T> T findTypeVIew(@NonNull ViewGroup group, Class<T> cls) {
        if (group == null) {
            return null;
        }
        //双端队列 两端都可以进出
        Deque<View> deque = new ArrayDeque<>();
        deque.add(group);
        while (!deque.isEmpty()) {
            View node = deque.removeFirst();
            if (cls.isInstance(node)) {
                return cls.cast(node);
            } else if (node instanceof ViewGroup) {
                ViewGroup container = (ViewGroup) node;
                for (int i = 0, count = container.getChildCount(); i < count; i++) {
                    deque.add(container.getChildAt(i));
                }
            }
        }
        return null;
    }

} 
