package com.group.service.user

import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.dto.user.request.UserCreateRequest
import com.group.libraryapp.service.user.UserService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest @Autowired constructor (
    private val userRepository: UserRepository,
    private val userService: UserService,
) {
    @Test
    fun saveUserTest() {
        // given
        val request = UserCreateRequest("이현호", 20)

        // when
        userService.saveUser(request)

        // then
        val results = userRepository.findAll()

        assertThat(results).hasSize(1)
        assertThat(results[0].name).isEqualTo("이현호")
        assertThat(results[0].age).isEqualTo(20)
    }
}