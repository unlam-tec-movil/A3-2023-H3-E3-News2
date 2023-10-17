<<<<<<<< HEAD:app/src/main/java/ar/edu/unlam/mobile/scaffold/mobile2/data/weather/network/Location.kt
package ar.edu.unlam.mobile.scaffold.mobile2.data.weather.network
========
package ar.edu.unlam.mobile2.weatherapi.data
>>>>>>>> develop:app/src/main/java/ar/edu/unlam/mobile/scaffold/mobile2/weatherapi/data/Location.kt

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("country")
    val country: String,
    @SerializedName("lat")
    val lat: String,
    @SerializedName("localtime")
    val localtime: String,
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Int,
    @SerializedName("lon")
    val lon: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("timezone_id")
    val timezoneId: String,
    @SerializedName("utc_offset")
    val utcOffset: String,
)
