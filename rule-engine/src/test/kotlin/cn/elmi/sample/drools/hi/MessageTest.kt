package cn.elmi.sample.drools.hi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.kie.api.KieServices
import org.kie.api.runtime.KieSession
import org.slf4j.LoggerFactory

class MessageTest {
    private val ksName = "HiKs"

    private lateinit var kSession: KieSession

    @BeforeEach
    fun setup() {
        val kServices = KieServices.Factory.get()
        val kContainer = kServices.kieClasspathContainer
        // val hiKb = kContainer.getKieBase("HiKb")
        // kSession = hiKb.newKieSession()
        kSession = kContainer.newKieSession(ksName)

        val log = LoggerFactory.getLogger(ksName)
        // kSession.setGlobal("logger", log)
    }

    @Test
    fun `should say by`() {
        val message = Message("hi", MessageStatus.HI)
        kSession.insert(message)
        kSession.fireAllRules()

        assertEquals(MessageStatus.BYE, message.status)
    }
}