package com.ljb.pagestatelayout.simple

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_def_style.setOnClickListener { goDefStylePage() }
        btn_custom_style.setOnClickListener { goCustomStylePage() }
        btn_code_style.setOnClickListener { goCodeStylePage() }
    }

    private fun goCodeStylePage() {
        startActivity(Intent(this, CodeStyleActivity::class.java))
    }

    private fun goCustomStylePage() {
        startActivity(Intent(this, CustomStyleActivity::class.java))
    }

    private fun goDefStylePage() {
        startActivity(Intent(this, DefStyleActivity::class.java))
    }
}
