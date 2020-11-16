package cn.elmi.sample.junit5

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

/**
 * @version 1.0
 * @authur Arthur
 */
@Disabled("Disabled until bug #90 has been fixed")
class DisabledClassDemo {
    @Test
    fun testWillBeSkipped() {
    }
}