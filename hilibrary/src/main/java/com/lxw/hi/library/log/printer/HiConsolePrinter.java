package com.lxw.hi.library.log.printer;

import android.util.Log;

import androidx.annotation.NonNull;

import com.lxw.hi.library.log.Interface.HiLogPrinter;
import com.lxw.hi.library.log.config.HiLogConfig;

import static com.lxw.hi.library.log.config.HiLogConfig.MAX_LEN;

/**
 * @authour
 * @function 控制台打印器
 * @date 2021/2/19
 */
public class HiConsolePrinter implements HiLogPrinter {
    @Override
    public void print(@NonNull HiLogConfig config, int level, String tag, @NonNull String printString) {
        int len = printString.length();//获取日志长度
        int countOfSub = len / MAX_LEN;
        if (countOfSub > 0) {
            int index = 0;
            for (int i = 0; i < countOfSub; i++) {
                Log.println(level, tag, printString.substring(index, index + MAX_LEN));
                index += MAX_LEN;
            }
            if (index != len) {
                Log.println(level, tag, printString.substring(index, len));
            }
        } else {
            Log.println(level, tag, printString);
        }
    }
}
