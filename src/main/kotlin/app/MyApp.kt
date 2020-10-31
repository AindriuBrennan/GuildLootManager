package app

import tornadofx. *
import views.LandingView

class MyApp : App(LandingView::class)

fun main(args: Array<String>) {
    launch<MyApp>(args)
}