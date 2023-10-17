package ar.edu.unlam.mobile2.data.mediastack.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ar.edu.unlam.mobile2.data.mediastack.local.entity.NewEntity

@Dao
interface NewDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNew(newEntity: NewEntity)

    @Query("SELECT * FROM NewEntity")
    suspend fun getNews(): List<NewEntity>
}
