package com.github.fixedyangsir.mvi.src.app_package

fun mviActivityKt(
    isActivity: Boolean,
    applicationPackage: String?,
    activityClass: String,
    layoutName: String,
    packageName: String,
    ): String {
    val sb = StringBuffer()
    sb.append(
        """
package ${packageName}
import android.os.Bundle
import androidx.activity.viewModels
import com.yzy.lib_common.base.mvi.LoadingEvent
import com.yzy.lib_common.base.mvi.ToastEvent
import com.yzy.lib_common.base.mvi.extension.collectSingleEvent
import com.yzy.lib_common.base.mvi.extension.collectState
import com.yzy.module_base.base.BaseActivity
import com.yzy.module_base.utils.ToastUtils.showToast
"""
    )
    val typeName = if (isActivity) "Activity" else "Fragment"
    sb.append(
        """
import ${applicationPackage}.R
"""
    )
    sb.append("import ${applicationPackage}.databinding.${typeName}${activityClass}Binding\n")
    sb.append("class ${activityClass}${typeName} : Base${typeName}<${typeName}${activityClass}Binding>(){")
    sb.append(
        """
    private val viewModel: ${activityClass}VM by viewModels()       
            
    override fun layoutId() = R.layout.${layoutName}
    
    override fun initView(savedInstanceState: Bundle?) {
      
    }
    
    override fun createObserver() {
       viewModel.container.uiStateFlow.collectState(this) {
        
        }

       viewModel.container.singleEventFlow.collectSingleEvent(this) {
            when (it) {
                is ToastEvent -> {
                    showToast(it.message)
                }

                is LoadingEvent -> {
                    if (it.isShow) showLoading() else dismissLoading()
                }
            }
        }
    }
  
    """
    )
    if (!isActivity) {
        sb.append(
            """
                
    override fun lazyLoadData() {

    }
    
    override fun immersionBarEnabled(): Boolean {
        return false
    }
            
            """
        )
    }
    sb.append("}")
    return sb.toString()
}
