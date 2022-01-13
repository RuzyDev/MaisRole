package br.com.arcom.telemetria.di

import br.com.ruzy.maisrole.data.dao.MaisRoleDao
import br.com.ruzy.maisrole.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun provideAppDao(appDatabase: AppDatabase): MaisRoleDao {
        return appDatabase.MaisRoleDao()
    }

}