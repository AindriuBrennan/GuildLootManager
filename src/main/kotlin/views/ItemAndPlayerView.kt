package views

import controllers.CharacterController
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class ItemAndPlyerView: View() {
    val model = ViewModel()
    val _name = model.bind { SimpleStringProperty() }
    val _race = model.bind { SimpleStringProperty() }
    val _classType = model.bind { SimpleStringProperty() }
    val characterController: CharacterController by inject()
    val tableContent =  characterController.characters.findOne(_name.value)

//    val data = tableContent.asObservable()


    override val root =vbox {
        setPrefSize(600.00,400.00)

            hbox{
                label("Item Name")
                textfield(_name)
                button("Search") {
                    action {
//                        val tableContent =  characterController.characters.findOne(_name.value)
//                        val data = tableContent.asObservable()
                    }
                }

                label("Player Name")
                textfield()
                button("Search")
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