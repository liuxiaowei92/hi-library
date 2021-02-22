package com.lxw.hi.library.app

import android.app.Application
import com.google.gson.Gson
import com.lxw.hi.library.log.HiLogManager
import com.lxw.hi.library.log.config.HiLogConfig
import com.lxw.hi.library.log.printer.HiConsolePrinter

/**
 *@authour
 *@function
 *@date 2021/2/19
 */
class MApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        HiLogManager.init(object : HiLogConfig() {

            override fun injectJsonParser(): JsonParser {
                return JsonParser { src -> Gson().toJson(src) }
            }

            override fun getGlobalTag(): String {
                return "MApplication"
            }

            override fun enable(): Boolean {
                return true
            }
        },HiConsolePrinter())
    }
}