package views

import javafx.geometry.Orientation
import javafx.scene.Parent
import javafx.scene.control.Button
import javafx.scene.layout.BorderPane
import tornadofx. *

class Landing: View() {
    override val root = vbox {
        setPrefSize(600.00,400.00)

        listmenu(theme = "blue", orientation = Orientation.HORIZONTAL) {
            item("Member Management") {
                activeItem = this
                whenSelected{}
            }
            item("Raid Management") {
                activeItem = this
                whenSelected {  }
            }
            item("Item DB")
        }
    }
//        setPrefSize(600.00,400.00)
//
//        button("Guild Member Management")
//        button("Raid Management")
//        label("Item Drops Database")
//        textfield {  }
//        button("Search")
//
//    }

}




