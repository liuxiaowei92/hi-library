package com.lxw.hi.library.log.mo;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @authour
 * @function log信息实体类
 * @date 2021/2/19
 */
public class HiLogMo {
    private static SimpleDateFormat sdf =
            new SimpleDateFormat("yy_MM_dd HH:mm:ss", Locale.CHINA);
    public long timeMillis;
    public int level;
    public String tag;
    public String log;

    public HiLogMo(long timeMillis, int level, String tag, String log) {
        this.timeMillis = timeMillis;
        this.level = level;
        this.tag = tag;
        this.log = log;
    }

    public String flattenedLog() {
        return getFlattened() + "\n" + log;
    }

    public String getFlattened() {
        return format(timeMillis) + "|" + level + "|" + tag + "|:";
    }

    private String format(long timeMillis) {
        return sdf.format(timeMillis);
    }
}
