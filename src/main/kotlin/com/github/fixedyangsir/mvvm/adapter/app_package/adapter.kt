package com.github.fixedyangsir.mvvm.adapter.app_package

fun adapterKt(
    applicationPackage: String?,
    adapterClass: String,
    layoutName: String,
    packageName: String,
): String {
    val sb = StringBuffer()
    sb.append(
        """
package ${packageName}
"""
    )

    sb.append(
        """
import ${applicationPackage}.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
"""
    )
    sb.append("class ${adapterClass}Adapter: BaseQuickAdapter<${adapterClass},BaseViewHolder>(R.layout.${layoutName}) {\n")
    sb.append(
        """
   override fun convert(holder: BaseViewHolder, item: ${adapterClass}) {
   
   }
    """
    )

    sb.append("}")
    return sb.toString()
}
