package app

import tornadofx. *
import views.Landing

class MyApp : App(Landing::class)

fun main(args: Array<String>) {
    launch<MyApp>(args)
}