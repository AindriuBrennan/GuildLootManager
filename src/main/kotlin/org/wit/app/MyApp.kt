package org.wit.app

import tornadofx. *
import org.wit.views.LandingView

class MyApp : App(LandingView::class)

fun main(args: Array<String>) {
    launch<MyApp>(args)
}