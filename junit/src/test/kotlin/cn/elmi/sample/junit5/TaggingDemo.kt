package cn.elmi.sample.junit5

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

/**
 * @version 1.0
 * @authur Arthur
 */
@Tag("fast")
//@Tag("model")
class TaggingDemo {
    @Test
    @Tag("Taxes")
    fun testTaxCalculation() {
    }
}