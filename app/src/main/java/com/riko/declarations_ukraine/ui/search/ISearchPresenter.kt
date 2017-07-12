package com.riko.declarations_ukraine.ui.search

/**
 * Created by Roman on 10.07.2017
 */
interface ISearchPresenter {
    fun search(query: String)
    fun downloadDeclaration(url: String)
}