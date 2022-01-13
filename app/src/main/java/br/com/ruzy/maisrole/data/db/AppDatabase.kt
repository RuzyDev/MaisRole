package br.com.ruzy.maisrole.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.ruzy.maisrole.util.DATABASE_NAME
import br.com.ruzy.maisrole.data.dao.MaisRoleDao
import br.com.ruzy.maisrole.data.entity.MaisRole

@Database(entities = [MaisRole::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun MaisRoleDao(): MaisRoleDao

    private fun buildDatabase(context: Context) {
        Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
            .build()
    }

}