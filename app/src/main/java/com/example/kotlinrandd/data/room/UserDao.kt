package com.example.kotlinrandd.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlinrandd.data.room.entities.CURRENT_USER_ID
import com.example.kotlinrandd.data.room.entities.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(user: User): Long

    //give back the data
    @Query("SELECT * FROM User Where uid = $CURRENT_USER_ID")

    fun getUser(): LiveData<User>
}