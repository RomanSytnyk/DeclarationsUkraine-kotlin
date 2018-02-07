package com.riko.declarations_ukraine.data.api

import com.riko.declarations_ukraine.data.api.model.DeclarationList
import kotlinx.coroutines.experimental.Deferred
import okhttp3.ResponseBody
import retrofit2.Response

/**
 * Created by Roman on 11.07.2017
 */
interface INazkApi {
    fun search(query: String): Deferred<Response<DeclarationList>>
    fun downloadDeclaration(url: String): Deferred<Response<ResponseBody>>
}