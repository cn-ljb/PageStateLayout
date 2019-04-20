package com.ljb.pagestatelayout.simple

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.ljb.page.PageState
import com.ljb.page.PageStateLayout
import com.ljb.pagestatelayout.simple.utils.RxUtils
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_custom_style.*
import java.util.concurrent.TimeUnit

/**
 * Author:Ljb
 * Time:2018/9/2
 * There is a lot of misery in life
 **/
class CustomStyleActivity : Activity() {

    private var mDemoDisposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_style)
        initTask()
    }

    private fun initTask() {
        mDemoDisposable = Observable
                .interval(0, 3000, TimeUnit.MILLISECONDS)
                .map { it % 6 }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { changePage(it.toInt()) }
    }

    private fun changePage(num: Int) {
        Log.i("pageState", "num = $num")
        val pageState = if (num % 2 == 0) {
            PageState.STATE_LOADING
        } else {
            when (num) {
                1 -> PageState.STATE_SUCCESS
                3 -> PageState.STATE_EMPTY
                5 -> PageState.STATE_ERROR
                else -> PageState.STATE_LOADING
            }
        }
        page_layout.setPage(pageState)
    }


    override fun onDestroy() {
        super.onDestroy()
        RxUtils.dispose(mDemoDisposable)
    }
}