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
        sb.append("class ${activityClass}${typeName} : Base${typeName}<${activityClass}VM, ${typeName}${activityClass}Binding>() {")
    } else {
        sb.append("class ${activityClass}${typeName} : Base${typeName}<${activityClass}VM>() {\n")
    }
    sb.append(
        """
    override fun layoutId() = R.layout.${layoutName}
    
    override fun initView(savedInstanceState: Bundle?) {
      
    }
    
    override fun createObserver() {
      
    }
    
    override fun immersionBarEnabled(): Boolean {
        return false
    }
  
    """
    )
    if (!isActivity) {
        sb.append(
            """
                
    override fun lazyLoadData() {

    }
            
            """
        )
    }
    sb.append("}")
    return sb.toString()
}
