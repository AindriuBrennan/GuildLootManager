import controllers.CharacterController
import models.CharacterModel
import models.Item
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.util.ArrayList

class CharTests {
    private val characterController = CharacterController()
    private val charName: String = "Lenny"
    private val charRace: String = "Gnome"
    private val charClassType: String = "Mage"
    private val itemsCollected: ArrayList<Item> = ArrayList()
    private val dateCollected: ArrayList<LocalDate>? = ArrayList()


    /**
     * Test creating a character
     */

    @Test
    fun testUserCreate() {
        characterController.addChar(charName,charRace,charClassType)
        val getUser = characterController.characters.findOne(charName)
            assertTrue(charName== getUser!!.name)

    }
}