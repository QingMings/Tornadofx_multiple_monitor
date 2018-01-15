package com.iezview.app

import com.iezview.view.MainView
import javafx.stage.Stage
import tornadofx.App

class MyApp: App(MainView::class, Styles::class){
    override fun start(stage: Stage) {
        super.start(stage)
    }
}