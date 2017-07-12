package com.riko.declarations_ukraine.data.api.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Roman on 11.07.2017
 */
data class DeclarationList(@SerializedName("items") val items: List<DeclarationItem>?,
                           @SerializedName("page") val pages: DeclarationPages)

data class DeclarationItem(@SerializedName("id") val id: String,
                       @SerializedName("firstname") val firstName: String,
                       @SerializedName("lastname") val lastName: String,
                       @SerializedName("placeOfWork") val placeOfWork: String,
                       @SerializedName("position") val position: String,
                       @SerializedName("linkPDF")  val linkPdf: String)

data class DeclarationPages(@SerializedName("batchSize") val batchSize: Int, // кількість елементів на сторінці (максимальне значення 50)
                            @SerializedName("totalItems") val totalItems: Int)

data class Error(@SerializedName("error") val code: Int,
                 @SerializedName("message") val message: String)