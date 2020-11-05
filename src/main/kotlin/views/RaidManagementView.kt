package views


import javafx.collections.FXCollections
import tornadofx.*
import java.time.LocalDate
import controllers.CharacterController
import controllers.ItemsController
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import models.Item

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

                field("Item") {
                    val itemNames = itemList.map {it.name}
                    val loot = FXCollections.observableArrayList(itemNames)
                    combobox(_itemCollected, itemList)
                }

                button("Submit") {
                    enableWhen(model.valid)
                    action{
                        runAsyncWithProgress {
                            characterController.updateChar(_name.value  ,_itemCollected.value, _dateCollected.value)
                            itemController.updateItem(_itemCollected.value, _name.value )

                        }
                        println("Character Item Record Updated!")
                    }
                }
                button("Delete Item") {
                    action {
                        runAsyncWithProgress {
                            itemController.deleteItemFromPlayer(_itemCollected.value, _name.value)
                        }
                        println("Character Record Deleted from Item")
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