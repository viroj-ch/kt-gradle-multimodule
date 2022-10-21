package vcp.example.multimodule

import io.kotest.core.spec.style.FreeSpec

internal class MultiModuleApplicationKtTest : FreeSpec() {
    init {
        "should in crease code coverage" {
            main(arrayOf(""))
        }
    }
}
