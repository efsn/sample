package cn.elmi.sample.junit5

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.*
import org.springframework.test.context.junit.jupiter.DisabledIf
import org.springframework.test.context.junit.jupiter.EnabledIf
import java.time.LocalDate

/**
 * @version 1.0
 * @authur Arthur
 */
class ConditionsDemo {
    @Test
    @EnabledOnOs(OS.MAC)
    fun onlyOnMacOs() {
    }

    @TestOnMac
    fun testOnMac() {
    }

    @Test
    @EnabledOnOs(OS.LINUX, OS.MAC)
    fun OnLinuxOrMac() {
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    fun notOnWindows() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    fun onlyOnJava8() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_9, JRE.JAVA_10)
    fun onJava9Or10() {
    }

    @Test
    @DisabledOnJre(JRE.JAVA_9)
    fun notOnJava9() {
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    fun onlyOn64BitArchitectures() {
    }

    @Test
    @EnabledIfSystemProperty(named = "ci-server", matches = "true")
    fun notOnCiServer() {
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
    fun onlyOnStagingServer() {
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
    fun ontOnDeveloperWorkstation() {
    }

    @Test // static javascript expression
    @EnabledIf("2 * 3 == 6")
    fun willBeExecuted() {
    }

    @RepeatedTest(10)
    @DisabledIf("Math.random() < 0.314159")
    fun mightNotBeExecuted() {
    }

    @Test
    @DisabledIf("/32/.test(systemProperty.get('os.arch'))")
    fun disabledOn32BitArchitectures() {
        Assertions.assertFalse(System.getProperty("os.arch").contains("32"))
    }

    @Test
    @EnabledIf("'CI' == systemEnvironment.get('ENV')")
    fun onlyOnCiServer() {
        Assertions.assertTrue("CI" == System.getenv("ENV"))
    }

    @Test
//    @EnabledIf(["load('nashorn:mozilla_compat.js')", "importPackage(java.time)", "", "var today = LocalDate.now()", "var tomorrow = today.plusDays(1)", "tomorrow.isAfter(today)"])
    fun theDayAfterTomorrow() {
        val today = LocalDate.now()
        val tomorrow = today.plusDays(1)
        Assertions.assertTrue(tomorrow.isAfter(today))
    }

    @Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    @Test
    @EnabledOnOs(
        OS.MAC
    )
    internal annotation class TestOnMac
}