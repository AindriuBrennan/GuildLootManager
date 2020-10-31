package views

import tornadofx.*

class ItemAndPlyerView: View() {
    override val root =vbox {
        setPrefSize(600.00,400.00)

            hbox{
                label("Item Name")
                textfield()
                button("Search")
                label("Player Name")
                textfield()
                button("Search")
            }
//            hbox{
//
//            }

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