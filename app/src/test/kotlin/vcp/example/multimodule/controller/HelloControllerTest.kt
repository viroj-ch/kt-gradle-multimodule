package vcp.example.multimodule.controller

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

internal class HelloControllerTest : FreeSpec() {
    init {
        "should return hello world" {
            // given
            val actual = HelloController().getHello()

            // when
            val expected = "Hello, World"

            // then
            actual shouldBe expected
        }
    }
}
