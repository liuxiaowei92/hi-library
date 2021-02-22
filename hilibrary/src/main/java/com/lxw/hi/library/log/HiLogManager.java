package com.lxw.hi.library.log;

import androidx.annotation.NonNull;

import com.lxw.hi.library.log.Interface.HiLogPrinter;
import com.lxw.hi.library.log.config.HiLogConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @authour
 * @function
 * @date 2021/2/19
 */
public class HiLogManager {
    private HiLogConfig config;
    private static HiLogManager instance;
    //用来保存打印器
    private List<HiLogPrinter> printers = new ArrayList<>();

    private HiLogManager(HiLogConfig config, HiLogPrinter[] printers) {
        this.config = config;
        this.printers.addAll(Arrays.asList(printers));
    }

    public static HiLogManager getInstance() {
        return instance;
    }

    public static void init(@NonNull HiLogConfig config, HiLogPrinter... printers) {
        instance = new HiLogManager(config, printers);
    }

    public HiLogConfig getConfig() {
        return config;
    }

    public List<HiLogPrinter> getPrinters() {
        return printers;
    }

    public void addPrinter(HiLogPrinter printer) {
        printers.add(printer);
    }

    public void removePrinter(HiLogPrinter printer) {
        if (printers != null) {
            printers.remove(printer);
        }
    }
}
