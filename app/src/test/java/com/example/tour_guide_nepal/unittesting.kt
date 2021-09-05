package com.example.tour_guide_nepal


import com.example.tour_guide_nepal.ENTITY.User
import com.example.tour_guide_nepal.Repository.UserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class unittesting {

    private lateinit var userRepository: UserRepository
    //=======login testing======
    @Test
    fun checklogin() = runBlocking {
        userRepository = UserRepository()
        val response = userRepository.loginUser("roshni1234@gmail.com","123456780")
        val expectedResult = true
        val actualresult = response.success
        Assert.assertEquals(expectedResult,actualresult)
    }

    //register
    @Test
    fun registerCustomer() = runBlocking {
        val user = User(

            email= "roshni111@gmail.com",
            fullname = "kritijoshi0111",
            phone = "9809897653",
            password = "15678"


        )
        userRepository = UserRepository()
        val response = userRepository.registerUser(user)
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }

}
