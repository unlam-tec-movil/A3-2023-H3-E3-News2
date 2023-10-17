package ar.edu.unlam.mobile.scaffold.mobile2.di

import android.app.Application
import androidx.room.Room
import ar.edu.unlam.mobile.scaffold.mobile2.data.guest.local.GuestDao
import ar.edu.unlam.mobile.scaffold.mobile2.data.guest.local.GuestDatabase
import ar.edu.unlam.mobile.scaffold.mobile2.data.guest.repository.GuestRepository
import ar.edu.unlam.mobile.scaffold.mobile2.data.mediastack.local.NewDao
import ar.edu.unlam.mobile.scaffold.mobile2.data.mediastack.local.NewDatabase
import ar.edu.unlam.mobile.scaffold.mobile2.data.mediastack.repository.GetNews
import ar.edu.unlam.mobile.scaffold.mobile2.data.mediastack.repository.MediastackApi
import ar.edu.unlam.mobile.scaffold.mobile2.data.mediastack.repository.NewRepository
import ar.edu.unlam.mobile.scaffold.mobile2.data.weather.repository.WeatherApiService
import ar.edu.unlam.mobile.scaffold.mobile2.data.weather.repository.WeatherStackRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // Mediastack Api
    @Provides
    @Singleton
    fun provideMediaStackApi(): MediastackApi {
        return Retrofit.Builder().baseUrl("http://api.mediastack.com/")
            .addConverterFactory(GsonConverterFactory.create()).client(OkHttpClient.Builder().build())
            .build().create(MediastackApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewDao(application: Application): NewDao {
        val db = Room.databaseBuilder(application, NewDatabase::class.java, "news_db").build()
        return db.dao
    }

    @Provides
    @Singleton
    fun provideMediastackRepository(api: MediastackApi, dao: NewDao): NewRepository {
        return NewRepository(api, dao)
    }

    @Provides
    @Singleton
    fun provideGetCharacters(repository: NewRepository): GetNews {
        return GetNews(repository)
    }

    // Weather Api

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApiService {
        return Retrofit.Builder()
            .baseUrl("http://api.weatherstack.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(api: WeatherApiService): WeatherStackRepository {
        return WeatherStackRepository(api)
    }

    // Guest
    @Provides
    @Singleton
    fun provideGuestDao(application: Application): GuestDao {
        val db = Room.databaseBuilder(application, GuestDatabase::class.java, "guest_db").build()
        return db.dao
    }

    @Provides
    @Singleton
    fun providesGuestRepository(dao: GuestDao): GuestRepository {
        return GuestRepository(dao)
    }
}
