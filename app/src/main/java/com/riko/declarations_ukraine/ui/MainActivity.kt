package com.riko.declarations_ukraine.ui

import android.os.Bundle
import android.view.MenuItem
import com.riko.declarations_ukraine.R
import com.riko.declarations_ukraine.ui.base.BaseActivity
import com.riko.declarations_ukraine.ui.search.SearchActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.view.inputmethod.EditorInfo
import android.widget.TextView



/**
 * Created by Roman on 10.07.2017
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        searchButton.setOnClickListener {
            if (search.text.isEmpty()) {
                showToast(R.string.empty_request)
            } else {
                SearchActivity.start(this, search.text.toString())
            }
        }

        search.setOnEditorActionListener(TextView.OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                searchButton.performClick()
                return@OnEditorActionListener true
            }
            false
        })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}