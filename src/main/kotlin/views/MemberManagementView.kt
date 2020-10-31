package views
import tornadofx.*

class MemberManagementView: View() {
    override val root = vbox{
        setPrefSize(600.00,400.00)

        form {
            fieldset("Create Character") {
                field("Name") {
                    textfield()
            }

                field("Race") {
                    textfield()
                }

                field("Class") {
                   textfield()
                }
            }
            button("Add Character") {
                action{ println("Character Created!")}
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
    }

}