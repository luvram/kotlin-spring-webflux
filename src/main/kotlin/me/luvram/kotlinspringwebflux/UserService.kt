package me.luvram.kotlinspringwebflux

import com.fasterxml.jackson.databind.ObjectMapper
import org.redisson.api.RedissonClient
import org.redisson.codec.TypedJsonJacksonCodec
import org.springframework.stereotype.Service
import java.security.InvalidParameterException
import java.util.UUID

@Service
class UserService(
    private val redissonClient: RedissonClient,
    private val objectMapper: ObjectMapper,
) {
    suspend fun save(userRequest: UserRequest) {
        if (userRequest.age < 0) {
            throw InvalidParameterException()
        }

        val map =
            redissonClient.getMap<String, User>("user", TypedJsonJacksonCodec(String::class.java, User::class.java, objectMapper))

        val user = User(
            UUID.randomUUID().toString(),
            userRequest.name,
            userRequest.age
        )

        map[user.id] = user
    }
}
