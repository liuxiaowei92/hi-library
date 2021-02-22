package com.lxw.hi.library.log.Interface;

/**
 * @authour
 * @function 日志消息格式化接口
 * @date 2021/2/19
 */
public interface HiLogFormatter<T> {
    String format(T data);
}
