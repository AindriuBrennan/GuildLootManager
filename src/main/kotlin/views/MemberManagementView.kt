package views
import controllers.characterController
import javafx.beans.property.SimpleStringProperty
import models.CharacterModel
import sun.java2d.pipe.SpanShapeRenderer
import tornadofx.*

class MemberManagementView: View() {
    val model = ViewModel()
    val _name = model.bind {SimpleStringProperty()}
    val _race = model.bind {SimpleStringProperty()}
    val _classType = model.bind {SimpleStringProperty()}
    val characterController: characterController by inject()
    val tableContent = characterController.characters.findAll()
    val data = tableContent.asObservable()
    override val root = vbox{
        setPrefSize(600.00,400.00)

        form {
            fieldset("Create Character") {
                field("Name") {
                    textfield(_name).required()
            }

                field("Race") {
                    textfield(_race).required()
                }

                field("Class") {
                   textfield(_classType).required()
                }
            }
            button("Add Character") {
                enableWhen(model.valid)
                action{
                    runAsyncWithProgress {
                        characterController.addChar(_name.toString(),_race.toString(),_classType.toString())
                    }
                    println("Character Created!")}
            }
            button("Delete Character"){
                action{ println("Character Deleted")}
            }
            button("Search Character"){
                //implement search functionality
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

        tableview(data) {
            readonlyColumn("Name", CharacterModel::name)
            readonlyColumn("Race", CharacterModel::race)
            readonlyColumn("Class", CharacterModel::classType)
        }
    }

}