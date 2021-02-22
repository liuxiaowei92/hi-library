package com.lxw.hi.library.app.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lxw.hi.library.app.R
import com.lxw.hi.library.log.HiLog
import com.lxw.hi.library.log.HiLogManager
import com.lxw.hi.library.log.HiLogType
import com.lxw.hi.library.log.config.HiLogConfig
import com.lxw.hi.library.log.printer.HiViewPrinter

class HiLogDemoActivity : AppCompatActivity() {
    var viewPrinter: HiViewPrinter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hi_log_demo)
        viewPrinter= HiViewPrinter(this)

        findViewById<View>(R.id.btn_log).setOnClickListener {
            printlog()
        }

        viewPrinter!!.viewProvider.showFloatingView();
        HiLogManager.getInstance().addPrinter(viewPrinter)
    }

    private fun printlog() {

        //自定义Log配置
        HiLog.log(object : HiLogConfig() {
            override fun includeTread(): Boolean {
                return true
            }

            override fun stackTraceDepth(): Int {
                return 0
            }
        }, HiLogType.E, "----", "5566")
        HiLog.a("9900")
    }
}