package cn.elmi.sample.junit5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @version 1.0
 * @authur Arthur
 */
public class ConditionsDemo {

    @Test
    @EnabledOnOs(OS.MAC)
    void onlyOnMacOs() {

    }

    @TestOnMac
    void testOnMac() {

    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void OnLinuxOrMac() {

    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void notOnWindows() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void onlyOnJava8() {

    }

    @Test
    @EnabledOnJre({JRE.JAVA_9, JRE.JAVA_10})
    void onJava9Or10() {

    }

    @Test
    @DisabledOnJre(JRE.JAVA_9)
    void notOnJava9() {

    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void onlyOn64BitArchitectures() {

    }

    @Test
    @EnabledIfSystemProperty(named = "ci-server", matches = "true")
    void notOnCiServer() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
    void onlyOnStagingServer() {

    }

    @Test
    @DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
    void ontOnDeveloperWorkstation() {

    }

    @Test // static javascript expression
    @EnabledIf("2 * 3 == 6")
    void willBeExecuted() {

    }

    @RepeatedTest(10)
    @DisabledIf("Math.random() < 0.314159")
    void mightNotBeExecuted() {

    }

    @Test
    @DisabledIf("/32/.test(systemProperty.get('os.arch'))")
    void disabledOn32BitArchitectures() {
        assertFalse(System.getProperty("os.arch").contains("32"));
    }

    @Test
    @EnabledIf("'CI' == systemEnvironment.get('ENV')")
    void onlyOnCiServer() {
        assertTrue("CI".equals(System.getenv("ENV")));
    }


    @Test
    @EnabledIf({
            "load('nashorn:mozilla_compat.js')",
            "importPackage(java.time)",
            "",
            "var today = LocalDate.now()",
            "var tomorrow = today.plusDays(1)",
            "tomorrow.isAfter(today)"
    })
    void theDayAfterTomorrow() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        assertTrue(tomorrow.isAfter(today));
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Test
    @EnabledOnOs(OS.MAC)
    @interface TestOnMac {

    }

}
