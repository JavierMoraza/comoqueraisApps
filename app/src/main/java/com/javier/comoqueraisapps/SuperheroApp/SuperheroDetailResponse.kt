package com.javier.comoqueraisapps.SuperheroApp

import com.google.gson.annotations.SerializedName

data class SuperheroDetailResponse (
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: SuperheroPowerStatsResponse,
    @SerializedName("image") val image: SuperheroImageDetailResponse,
    @SerializedName("biography") val biography: SuperheroBiographyResponse

)

data class SuperheroPowerStatsResponse(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)

data class SuperheroBiographyResponse(
    @SerializedName("full-name") val fullName: String,
    @SerializedName("publisher") val publisher: String
)

data class SuperheroImageDetailResponse(@SerializedName("url") val url:String)