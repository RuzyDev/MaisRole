package br.com.ruzy.maisrole.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import br.com.ruzy.maisrole.data.entity.MaisRole
import kotlinx.coroutines.flow.Flow

@Dao
interface MaisRoleDao {
//
    @Query("SELECT * FROM `maisrole`")
    fun getAll(): Flow<List<MaisRole>>
//
//    @Query("DELETE FROM `maisrole`")
//    suspend fun deleteAll()
//
//    @Insert
//    suspend fun insertAll(list: List<MaisRoleDao>)
//
//    @Transaction
//    suspend fun updateData(list: List<MaisRoleDao>) {
//        deleteAll()
//        insertAll(list)
//    }

}

