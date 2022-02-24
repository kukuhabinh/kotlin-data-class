package com.learning.ultils

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class FileUtilsTest {
    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun `read somefile DOT json SHOULD BE return "abc1, def"`() {
        FileUtils.readAndTrim("somefile.json") shouldBe "abc1, def"
    }
}