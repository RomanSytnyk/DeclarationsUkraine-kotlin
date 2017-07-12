package com.riko.declarations_ukraine.data

import com.riko.declarations_ukraine.App
import com.riko.declarations_ukraine.data.api.NazkApi
import com.riko.declarations_ukraine.data.api.model.DeclarationList
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Roman on 10.07.2017
 */
class DataManager : IDataManager {
    @Inject
    lateinit var nazkApi: NazkApi

    init {
        App.dataManagerComponent.inject(this)
    }

    override fun search(query: String): Observable<Response<DeclarationList>> {
        return nazkApi.search(query)
    }

    override fun downloadDeclaration(url: String): Observable<Response<ResponseBody>> {
        return nazkApi.downloadDeclaration(url)
    }
}