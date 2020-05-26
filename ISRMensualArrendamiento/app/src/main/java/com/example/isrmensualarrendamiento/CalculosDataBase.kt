package com.example.isrmensualarrendamiento

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(CalculosRealizados::class), version = 1, exportSchema = false)
abstract class CalculosDataBase: RoomDatabase()
{
    abstract fun calculosDao(): CalculosDao

    companion object{
        @Volatile
        private var INSTANCE: CalculosDataBase? = null

        fun getDataBase(context: Context): CalculosDataBase
        {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this)
            {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CalculosDataBase::class.java,
                    "alumno_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}