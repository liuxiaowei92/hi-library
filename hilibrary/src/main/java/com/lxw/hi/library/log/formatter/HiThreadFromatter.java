package com.lxw.hi.library.log.formatter;

import com.lxw.hi.library.log.Interface.HiLogFormatter;

/**
 * @authour
 * @function 线程格式化器
 * @date 2021/2/19
 */
public class HiThreadFromatter implements HiLogFormatter<Thread> {
    @Override
    public String format(Thread data) {
        return "Thread:" + data.getName();
    }
}
