package com.github.fixedyangsir.mvvm.activity.src.app_package

fun mvvmViewModel(
        packageName:String,
        activityClass:String
)="""
package ${packageName}.vm
@HiltViewModel
class ${activityClass}VM @Inject constructor(): ViewModel() {
   
}    
"""