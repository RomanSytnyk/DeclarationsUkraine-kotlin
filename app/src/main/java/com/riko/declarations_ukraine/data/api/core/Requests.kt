package com.riko.declarations_ukraine.data.api.core

import com.riko.declarations_ukraine.data.api.NazkApi
import com.riko.declarations_ukraine.data.api.model.DeclarationList
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import okhttp3.ResponseBody

/**
 * Created by Roman on 10.07.2017
 */
interface Requests {
    @GET(NazkApi.REQUEST_SEARCH_DECLARATION)
    fun searchDeclaration(@Query("q") query: String): Observable<Response<DeclarationList>>

    @GET
    fun downloadDeclaration(@Url fileUrl: String): Observable<Response<ResponseBody>>
}