package br.com.ruzy.maisrole.data.repository

import br.com.ruzy.maisrole.data.dao.MaisRoleDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MaisRoleRepository @Inject constructor(val maisRoleDao: MaisRoleDao) {

    fun getAll() = maisRoleDao.getAll()

}



