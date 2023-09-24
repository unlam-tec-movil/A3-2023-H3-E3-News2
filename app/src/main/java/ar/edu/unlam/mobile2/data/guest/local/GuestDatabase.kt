package ar.edu.unlam.mobile2.data.guest.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ar.edu.unlam.mobile2.data.guest.local.entity.GuestEntity

@Database(entities = [GuestEntity::class], version = 1)
abstract class GuestDatabase: RoomDatabase() {
    abstract val dao: GuestDao
}