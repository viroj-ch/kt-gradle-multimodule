package vcp.example.multimodule.controller

import io.kotest.core.spec.style.FreeSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class HelloControllerTest(@Autowired val mockMvc: MockMvc) : FreeSpec() {
    init {
        "should return hello world" {
            mockMvc.get("/hello")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { string("Hello, World") }
                }
        }
    }
}
