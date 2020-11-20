package com.example.retrofit

import com.google.gson.annotations.SerializedName


class Response {
    @SerializedName("response")
    private var response: Response? = null

    @SerializedName("code")
    private var code: String? = null

    @SerializedName("success")
    private var success = false

    @SerializedName("data")
    private var data: List<PostModel>? = null


    fun setResponse(response: Response?) {
        this.response = response
    }

    fun getResponse(): Response? {
        return response
    }

    fun setCode(code: String?) {
        this.code = code
    }

    fun getCode(): String? {
        return code
    }

    fun setSuccess(success: Boolean) {
        this.success = success
    }

    fun isSuccess(): Boolean {
        return success
    }

    fun setData(customers: List<PostModel?>) {
        this.data = data
    }

    fun getData(): List<PostModel?>? {
        return data
    }

}