<<<<<<<< HEAD:app/src/main/java/ar/edu/unlam/mobile/scaffold/mobile2/data/weather/network/WeatherResponse.kt
package ar.edu.unlam.mobile.scaffold.mobile2.data.weather.network
========
package ar.edu.unlam.mobile2.weatherapi.data
>>>>>>>> develop:app/src/main/java/ar/edu/unlam/mobile/scaffold/mobile2/weatherapi/data/WeatherResponse.kt

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("current")
    val current: Current,
    @SerializedName("location")
    val location: Location,
    @SerializedName("request")
    val request: Request,
)
