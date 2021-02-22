package com.lxw.hi.library.log.config;

import com.lxw.hi.library.log.Interface.HiLogPrinter;
import com.lxw.hi.library.log.formatter.HiStackTraceFromatter;
import com.lxw.hi.library.log.formatter.HiThreadFromatter;

/**
 * @authour
 * @function 配置类
 * @date 2021/2/19
 */
public abstract class HiLogConfig {
    public static int MAX_LEN = 512;
    public static HiThreadFromatter HI_THREAD_FROMATTER = new HiThreadFromatter();
    public static HiStackTraceFromatter HI_STACK_TRACE_FROMATTER = new HiStackTraceFromatter();

    public JsonParser injectJsonParser() {
        return null;
    }

    //全局tag
    public String getGlobalTag() {
        return "HiLog";
    }

    //是否启用log
    public boolean enable() {
        return true;
    }

    /**
     * 日志是否包含线程信息
     *
     * @return
     */
    public boolean includeTread() {
        return false;
    }

    /**
     * 获取堆栈信息的深度
     *
     * @return 堆栈信息深度
     */
    public int stackTraceDepth() {
        return 5;
    }

    //用户注册打印器
    public HiLogPrinter[] printers() {
        return null;
    }

    public interface JsonParser {
        String toJson(Object src);
    }
}
