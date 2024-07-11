package bhuwan

data class TimesWireModal (
    val status: String? = null,
    val copyright: String? = null,
    val num_Results: Long? = null,
    val results: List<Result>? = null
)

data class Result (
    val slug_Name: String? = null,
    val section: String? = null,
    val subsection: String? = null,
    val title: String? = null,
    val abstract: String? = null,
    val uri: String? = null,
    val url: String? = null,
    val byline: String? = null,
    val item_Type: ItemType? = null,
    val source: Source? = null,
    val updated_Date: String? = null,
    val created_Date: String? = null,
    val published_Date: String? = null,
    val first_Published_Date: String? = null,
    val material_Type_Facet: String? = null,
    val kicker: Kicker? = null,
    val subheadline: String? = null,
    val des_Facet: List<String>? = null,
    val org_Facet: List<String>? = null,
    val per_Facet: List<String>? = null,
    val geo_Facet: List<String>? = null,
    val related_Urls: List<Any?>? = null,
    val multimedia: List<Multimedia>? = null
)

enum class ItemType {
    Article,
    Interactive
}

enum class Kicker {
    Empty,
    EnsayoInvitado,
    NicholasKristof,
    WordplayTheCrosswordColumn
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
    MediumThreeByTwo210,
    MediumThreeByTwo440,
    Normal,
    StandardThumbnail
}

enum class Subtype {
    Photo
}

enum class Type {
    Image
}

enum class Source {
    NewYorkTimes
}
