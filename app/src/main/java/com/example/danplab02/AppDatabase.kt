package com.example.danplab02

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        Estudiante::class,
        Curso::class,
        EstudianteCursoR::class
               ],
    version = 1
)

abstract class AppDatabase: RoomDatabase(){
    abstract val courseDao: CursoDao
    abstract val studentDao : EstudianteDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase?= null

        fun getInstance(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }

}