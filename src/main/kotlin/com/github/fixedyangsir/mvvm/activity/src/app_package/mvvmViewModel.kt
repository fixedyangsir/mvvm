package com.github.fixedyangsir.mvvm.activity.src.app_package

fun mvvmViewModel(
        packageName:String,
        activityClass:String
)="""
package ${packageName}.vm
import com.yzy.mvvmlib.base.viewmodel.BaseViewModel
class ${activityClass}VM : BaseViewModel() {
   
}    
"""