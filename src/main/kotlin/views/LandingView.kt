package views

import javafx.geometry.Orientation
import javafx.scene.Parent
import javafx.scene.control.Button
import javafx.scene.layout.BorderPane
import tornadofx. *

class LandingView: View() {

    override val root = vbox {
        reloadViewsOnFocus()
        setPrefSize(600.00,400.00)

        listmenu(theme = "blue", orientation = Orientation.HORIZONTAL) {
            item("Member Management") {
                activeItem = this
                whenSelected{
                    replaceWith<MemberManagementView>(
                            ViewTransition.Slide(0.4.seconds, ViewTransition.Direction.LEFT),
                            true,
                            true,
                    )
                }
            }
            item("Raid Management") {
                activeItem = this
                whenSelected {
                    replaceWith<RaidManagementView>(
                            ViewTransition.Slide(0.4.seconds, ViewTransition.Direction.LEFT),
                            true,
                            true,
                    )
                }
            }
            item("Item DB") {
                activeItem = this
                whenSelected {
                    replaceWith<ItemAndPlyerView>(
                            ViewTransition.Slide(0.4.seconds, ViewTransition.Direction.LEFT),
                            true,
                            true,
                    )
                }
            }
        }
    }
}




