package org.wit.views

import org.wit.controllers.CharacterController
import org.wit.controllers.ItemsController
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.SelectionMode
import org.wit.models.CharacterModel
import org.wit.models.Item
import tornadofx.*

/**
 *
 * A view for seeing players and items at the same time, originally
 * I wanted this to be a tableview with expandable rows but TornadoFX did
 * not want to work with me.
 *
 */

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
        reloadViewsOnFocus()
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
        /**
         *
         * ListView of items, not displaying item names due to how the item objects
         * are interacting with the view model
         */
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