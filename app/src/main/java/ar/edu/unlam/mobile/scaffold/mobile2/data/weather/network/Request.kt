<<<<<<<< HEAD:app/src/main/java/ar/edu/unlam/mobile/scaffold/mobile2/data/weather/network/Request.kt
package ar.edu.unlam.mobile.scaffold.mobile2.data.weather.network
========
package ar.edu.unlam.mobile2.weatherapi.data
>>>>>>>> develop:app/src/main/java/ar/edu/unlam/mobile/scaffold/mobile2/weatherapi/data/Request.kt

import com.google.gson.annotations.SerializedName

data class Request(
    @SerializedName("language")
    val language: String,
    @SerializedName("query")
    val query: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("unit")
    val unit: String,
)
