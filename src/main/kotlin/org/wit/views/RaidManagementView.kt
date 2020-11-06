package org.wit.views


import javafx.collections.FXCollections
import tornadofx.*
import java.time.LocalDate
import org.wit.controllers.CharacterController
import org.wit.controllers.ItemsController
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import org.wit.models.Item

class RaidManagementView: View() {
    val characterController: CharacterController by inject()
    val charList = characterController.characters.findAll()
    val model = ViewModel()
    val _name = model.bind { SimpleStringProperty() }
    val _itemCollected = model.bind { SimpleObjectProperty<Item>() }
    val _dateCollected = model.bind {SimpleObjectProperty<LocalDate>()}
    val itemController: ItemsController by inject()
    val itemList = itemController.items.findAll()


    override val root = vbox {
        reloadViewsOnFocus()
        setPrefSize(600.00, 400.00)

        form{
            fieldset("Raid Management"){
                field("Raid Date") {
                    datepicker(_dateCollected){
                        value = LocalDate.now()

                    }
                }

                field("Select Character"){
                    val names  =  charList.map {it.name}
                    val chars = FXCollections.observableArrayList(names)
                    combobox(_name, chars)
                }

                /*
                 * make the ArrayList of created items available as to be selected here
                 * Bug from how the item names are bound with the view model, item name
                 * is not properly displayed.
                 *
                 */

                field("Item") {
                    val itemNames = itemList.map {it.name}
                    val loot = FXCollections.observableArrayList(itemNames)
                    combobox(_itemCollected, itemList)
                }

                /**
                 *  Add items to the character object and the character being updated to the item
                 */

                button("Submit") {
                    enableWhen(model.valid)
                    action{
                        runAsyncWithProgress {
                            characterController.updateChar(_name.value  ,_itemCollected.value, _dateCollected.value)
                            itemController.updateItem(_itemCollected.value, _name.value )

                        }
                        println("Character & Item Records Updated!")
                    }
                }

                /**
                 *
                 * Delete both character and item from each others tracking array
                 */

                button("Delete Item") {
                    action {
                        runAsyncWithProgress {
                            itemController.deletePlayerFromItem(_itemCollected.value, _name.value)
                            characterController.deleteItemFromPlayer(_name.value, _itemCollected.value, _dateCollected.value)
                        }
                        println("Item Record Deleted from Item & Character")
                    }
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