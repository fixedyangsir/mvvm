package com.github.fixedyangsir.mvvm.activity.src.app_package

fun mvvmActivityKt(
    isActivity: Boolean,
    applicationPackage: String?,
    activityClass: String,
    layoutName: String,
    packageName: String,
    userDataBinding: Boolean,
): String {
    val sb = StringBuffer()
    sb.append(
        """
package ${packageName}
import android.os.Bundle
"""
    )
    val typeName = if (isActivity) "Activity" else "Fragment"
    sb.append(
        """
import ${applicationPackage}.R
"""
    )
    if (userDataBinding) {
        sb.append("import ${applicationPackage}.databinding.${typeName}${activityClass}Binding\n")
        sb.append("@AndroidEntryPoint\n")
        sb.append("class ${activityClass}${typeName} : Base${typeName}<${typeName}${activityClass}Binding>() {")
    } else {
        sb.append("class ${activityClass}${typeName} : Base${typeName}<${activityClass}VM>() {\n")
    }
    sb.append(
        """
    private val viewModel: ${activityClass}VM by viewModels()          
            
    override fun layoutId() = R.layout.${layoutName}
    
    override fun initView(savedInstanceState: Bundle?) {
      
    }
    
    override fun createObserver() {
      
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
