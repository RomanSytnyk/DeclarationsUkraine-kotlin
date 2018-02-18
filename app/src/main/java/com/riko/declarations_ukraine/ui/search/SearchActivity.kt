package com.riko.declarations_ukraine.ui.search

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.arellomobile.mvp.presenter.InjectPresenter
import com.riko.declarations_ukraine.R
import com.riko.declarations_ukraine.data.api.model.DeclarationList
import com.riko.declarations_ukraine.ui.base.BaseActivity
import com.riko.declarations_ukraine.ui.search.adapter.IDeclarationClick
import com.riko.declarations_ukraine.ui.search.adapter.SearchAdapter
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : BaseActivity(), ISearchView, IDeclarationClick {
    @InjectPresenter lateinit var presenter: SearchPresenter

    companion object {
        private const val INTENT_SEARCH_QUERY = "search_query"

        fun start(context: Context, request: String) {
            val intent = Intent(context, SearchActivity::class.java)
            intent.putExtra(INTENT_SEARCH_QUERY, request)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val query = intent.getStringExtra(INTENT_SEARCH_QUERY)
        if(query.isEmpty()) finish()

        title = query
        presenter.search(query)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }

    override fun showSearchResult(list: DeclarationList?) {
        if(list == null) {
            showErrorToast()
            return
        }

        declarations.layoutManager = LinearLayoutManager(this)
        declarations.adapter = SearchAdapter(list, this)
    }

    override fun onDeclarationClicked(url: String) {
        presenter.downloadDeclaration(url)
    }

    override fun openDeclarationPdfInBrowser(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }

    override fun showErrorToast() {
        showToast(R.string.error)
    }

    override fun showNotFoundToast() {
        showToast(R.string.not_found)
    }
}
