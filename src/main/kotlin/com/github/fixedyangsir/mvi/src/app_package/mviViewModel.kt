package com.github.fixedyangsir.mvi.src.app_package

fun mviViewModel(
        packageName:String,
        activityClass:String
)="""
package ${packageName}.vm
import androidx.lifecycle.ViewModel
import com.yzy.lib_common.base.mvi.Container
import com.yzy.lib_common.base.mvi.UiEvent
import com.yzy.lib_common.base.mvi.UiState
import com.yzy.lib_common.base.mvi.extension.containers


class ${activityClass}VM : ViewModel() {
   
    private val _container by containers<${activityClass}UIState>(${activityClass}UIState.INIT)

    val container: Container<${activityClass}UIState, UiEvent> = _container


    fun dispatch(intent: ${activityClass}Intent) {


       


    }
   
} 
sealed class ${activityClass}UIState() : UiState {
    object INIT : ${activityClass}UIState()


   
}


sealed class ${activityClass}Intent() {

    
   

}
"""