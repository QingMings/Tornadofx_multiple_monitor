package com.iezview.view

import com.iezview.app.Styles
import com.sun.javafx.util.Utils
import javafx.geometry.Rectangle2D
import javafx.stage.Screen
import tornadofx.*

/**
 * 测试判断 程序在那个屏幕上
 */
class MainView : View("Hello TornadoFX") {
    var  monitorIndex by property(0);
    fun  monitorIndexProperty() =getProperty(MainView::monitorIndex)
    override val root = hbox {
        label("程序当前在第"){ addClass(Styles.heading)}
        label(monitorIndexProperty()) { addClass(Styles.heading)}
        label("个屏幕上") {   addClass(Styles.heading)}
    }
    override fun onDock() {
        //监听窗体拖动
        primaryStage.xProperty().onChange {
            monitorIndexProperty().set(currentMonitorIndex())
        }
        super.onDock()
    }

    /**
     * 显示屏幕下标
     */
    private fun currentMonitorIndex(): Int {
        return Screen.getScreens().indexOf(currentScreen());
    }

    /**
     * 计算程序在那个屏幕上
     */
    private fun currentScreen() = Utils.getScreenForRectangle(Rectangle2D(primaryStage.x,primaryStage.y, primaryStage.width,primaryStage.height))
}