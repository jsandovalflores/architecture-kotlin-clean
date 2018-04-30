/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.architecture.ui.viewmodel.mapper

import com.quebuu.core_lib.domain.repository.entity.UserEntity
import com.quebuu.core_lib.domain.repository.model.UserModel
import com.quebuu.architecture.ui.viewmodel.UserViewModel

object UserMapper {

    fun mapModelToViewModel(model: UserModel) : UserViewModel{
        return UserViewModel(model.idUser, model.name, model.lastName)
    }

    fun mapEntityToViewModel(entity : UserEntity) : UserViewModel{
        return UserViewModel(entity.idUser, entity.name, entity.lastName)
    }

}