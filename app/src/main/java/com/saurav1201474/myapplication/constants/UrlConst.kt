package com.saurav1201474.myapplication.constants

object UrlConst {
    private const val API_KEY = "NFOb2nTHipmzq9mKHrG8m0ZS5t9N82ZU"
    const val BASE_URL = "https://api.nytimes.com/svc/"
    const val ARTICLES_URL = "${BASE_URL}search/v2/articlesearch.json?api-key=$API_KEY"
    const val TOP_STORIES_URL = "${BASE_URL}topstories/v2/arts.json?api-key=$API_KEY"

}