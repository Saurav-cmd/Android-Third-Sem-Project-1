package com.saurav1201474.myapplication.models

data class TopstoriesModal (
    val status: String? = null,
    val copyright: String? = null,
    val section: String? = null,
    val last_Updated: String? = null,
    val num_Results: Long? = null,
    val results: List<Result>? = null
)

data class Result (
    val section: String? = null,
    val subsection: String? = null,
    val title: String? = null,
    val abstract: String? = null,
    val url: String? = null,
    val uri: String? = null,
    val byline: String? = null,
    val item_Type: ItemType? = null,
    val updated_Date: String? = null,
    val created_Date: String? = null,
    val published_Date: String? = null,
    val material_Type_Facet: String? = null,
    val kicker: String? = null,
    val des_Facet: List<String>? = null,
    val org_Facet: List<String>? = null,
    val per_Facet: List<String>? = null,
    val geo_Facet: List<String>? = null,
    val multimedia: List<Multimedia>? = null,
    val short_URL: String? = null
)

enum class ItemType {
    Article,
    Interactive,
    Promo
}

data class Multimedia (
    val url: String? = null,
    val format: Format? = null,
    val height: Long? = null,
    val width: Long? = null,
    val type: Type? = null,
    val subtype: Subtype? = null,
    val caption: String? = null,
    val copyright: String? = null
)

enum class Format {
    LargeThumbnail,
    SuperJumbo,
    ThreeByTwoSmallAt2X
}

enum class Subtype {
    Photo
}

enum class Type {
    Image
}
