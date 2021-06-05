package com.raudonikis.data_domain.user

import com.raudonikis.network.user.UserResponse

/**
 * Mapper for [User]
 */
object UserMapper {

    /**
     * From [UserResponse] to [User]
     */
    fun fromUserResponse(from: UserResponse): User {
        return User(
            uuid = from.uuid,
            image = from.image,
            firstName = from.firstName,
            lastName = from.lastName,
            address = from.address,
            phone = from.phone,
        )
    }
}