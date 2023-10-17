package ar.edu.unlam.mobile.scaffold.mobile2.data.mediastack.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ar.edu.unlam.mobile.scaffold.mobile2.data.mediastack.local.entity.NewEntity

@Database(entities = [NewEntity::class], version = 1)
abstract class NewDatabase : RoomDatabase() {
    abstract val dao: NewDao
}
