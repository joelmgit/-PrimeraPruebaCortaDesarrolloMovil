package com.apppruebaa.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.apppruebaa.model.Capitulo

@Database(entities = [Capitulo::class],version=1, exportSchema = false)
abstract class CapituloDatabase : RoomDatabase() {
    abstract fun capituloDao() : CapituloDao
    companion object {
        @Volatile
        private var INSTANCE: CapituloDatabase? = null
        fun getDatabase(context: android.content.Context) : CapituloDatabase {
            val temp = INSTANCE
            if (temp != null) {
                return temp
            }
            synchronized(this) {
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    CapituloDatabase::class.java,
                    "capitulo_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}