package views

import controllers.CharacterController
import controllers.ItemsController
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.SelectionMode
import models.CharacterModel
import models.Item
import tornadofx.*

class ItemAndPlyerView: View() {
    val model = ViewModel()
    val _name = model.bind { SimpleStringProperty() }
    val _race = model.bind { SimpleStringProperty() }
    val _classType = model.bind { SimpleStringProperty() }
    val characterController: CharacterController by inject()
    val characterContent =  characterController.characters.findAll()
    val charData = characterContent.asObservable()
    val itemController: ItemsController by inject()
    val itemContent = itemController.items.findAll()
    val itemData = itemContent.asObservable()




    override val root =vbox {
        setPrefSize(600.00,400.00)

            hbox{
                tableview(charData) {
                    column("Name", CharacterModel::name)
                    column("Race", CharacterModel::race)
                    column("Class", CharacterModel::classType)
                    column("Date Collected", CharacterModel::dateCollected)
                    column("Items Received", CharacterModel::itemsCollected)
                }
            }

            listview(itemData) {
                selectionModel.selectionMode = SelectionMode.MULTIPLE
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