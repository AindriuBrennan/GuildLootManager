package views

import javafx.collections.FXCollections
import tornadofx.*
import java.time.LocalDate

class RaidManagementView: View() {
    override val root = vbox {
        setPrefSize(600.00, 400.00)

        form{
            fieldset("Raid Management"){
                field("Select Raid") {
                    val raids = FXCollections.observableArrayList("Molten Core","Onyxias Lair","Blackwing Lair",
                    "Zul'Gurub", "Ruins of Ahn'Qiraj", "Temple of Ahn'Qiraj", "Naxxaramas")
                    combobox<String> {
                    items = raids
                }
                }

                field("Raid Date") {
                    datepicker{
                        value = LocalDate.now()
                    }
                }

                field("Select Character"){
                    val chars = FXCollections.observableArrayList("Aindriu", "TedCrilly","HotDotter","Cailleach")
                    combobox<String>{
                      items = chars
                   }
                }

                field("Item") {
                    val loot = FXCollections.observableArrayList("Staff of ShadowFlame", "Azuresong Mageblade","Arcanist Boots" )
                    combobox<String>{
                        items = loot
                    }
                }

                button("Submit") {
                    action {println("Character and item added to Raid")}
                }
                button("Main Menu") {
                    action {
                        replaceWith<LandingView>(
                                ViewTransition.Slide(0.4.seconds,ViewTransition.Direction.RIGHT),
                                true,
                                true
                        )
                    }
                }

            }
        }
    }
}