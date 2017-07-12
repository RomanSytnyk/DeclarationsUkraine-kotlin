package com.riko.declarations_ukraine.data.api

import com.riko.declarations_ukraine.data.api.core.Requests
import com.riko.declarations_ukraine.data.api.model.DeclarationList
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response

/**
 * Created by Roman on 10.07.2017
 */
class NazkApi(private val requests: Requests) : INazkApi {
    companion object {
        const val REQUEST_SEARCH_DECLARATION = "/v1/declaration/"
    }

    override fun search(query: String): Observable<Response<DeclarationList>> {
        return requests.searchDeclaration(query)
    }

    override fun downloadDeclaration(url: String): Observable<Response<ResponseBody>> {
        return requests.downloadDeclaration(url)
    }
}