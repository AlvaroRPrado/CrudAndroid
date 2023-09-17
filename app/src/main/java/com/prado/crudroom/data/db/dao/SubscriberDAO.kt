package com.prado.crudroom.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.prado.crudroom.data.db.entity.SubscriberEntity

@Dao
interface SubscriberDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(subscriber: SubscriberEntity): Long

    @Update
   fun update(subscriber: SubscriberEntity)

    @Query("DELETE FROM subscriber WHERE id = :id")
    fun delete(id: Long)


    @Query("DELETE FROM subscriber")
    fun deleteAll()

    @Query("SELECT * FROM subscriber")
    fun getAll(): LiveData<List<SubscriberEntity>>
}