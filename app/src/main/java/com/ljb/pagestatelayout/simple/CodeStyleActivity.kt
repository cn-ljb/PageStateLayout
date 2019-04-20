package com.ljb.pagestatelayout.simple

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.ljb.page.PageStateLayout
import com.ljb.pagestatelayout.simple.utils.RxUtils
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_code_style.*
import java.util.concurrent.TimeUnit

class CodeStyleActivity : Activity() {

    private var mDemoDisposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_style)
        initView()
        initTask()
    }

    private fun initView() {
        page_layout.apply {
            setLoadView(R.layout.layout_page_loading)
            setEmptyView(R.layout.layout_page_empty)
            setErrorView(R.layout.layout_page_error)
            setContentView(R.layout.layout_page_content)
        }
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
            PageStateLayout.PageState.STATE_LOADING
        } else {
            when (num) {
                1 -> PageStateLayout.PageState.STATE_SUCCESS
                3 -> PageStateLayout.PageState.STATE_EMPTY
                5 -> PageStateLayout.PageState.STATE_ERROR
                else -> PageStateLayout.PageState.STATE_LOADING
            }
        }
        page_layout.setPage(pageState)
    }


    override fun onDestroy() {
        super.onDestroy()
        RxUtils.dispose(mDemoDisposable)
    }

}