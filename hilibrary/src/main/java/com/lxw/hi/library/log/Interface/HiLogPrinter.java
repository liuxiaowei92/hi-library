package com.lxw.hi.library.log.Interface;

import androidx.annotation.NonNull;

import com.lxw.hi.library.log.config.HiLogConfig;

/**
 * @authour
 * @function 日志打印接口
 * @date 2021/2/19
 */
public interface HiLogPrinter {
    void print(@NonNull HiLogConfig config,int level,String tag,@NonNull String printString);
}
