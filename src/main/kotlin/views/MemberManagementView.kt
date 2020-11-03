package views
import controllers.CharacterController
import javafx.beans.property.SimpleStringProperty
import models.CharacterModel
import sun.java2d.pipe.SpanShapeRenderer
import tornadofx.*

class MemberManagementView: View() {
    val model = ViewModel()
    val _name = model.bind {SimpleStringProperty()}
    val _race = model.bind {SimpleStringProperty()}
    val _classType = model.bind {SimpleStringProperty()}
    val characterController: CharacterController by inject()
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
                        characterController.addChar(_name.value  ,_race.value, _classType.value)
                    }
                    println("Character Created!")}
            }
            button("Delete Character"){
                action{
                    runAsyncWithProgress {
                        characterController.deleteChar(_name.value)
                    }
                    println("Character Deleted here")}
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
            column("Name", CharacterModel::name)
            column("Race", CharacterModel::race)
            column("Class", CharacterModel::classType)
        }
    }

}