package com.github.fixedyangsir.mvvm.adapter

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.github.fixedyangsir.mvvm.activity.res.layout.mvvmActivityXml
import com.github.fixedyangsir.mvvm.adapter.app_package.adapterKt




fun RecipeExecutor.adapterRecipe(
    moduleData: ModuleTemplateData,
    adapterClass: String,
    layoutName: String,
    packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension

    val adapter= adapterKt(
        projectData.applicationPackage,
        adapterClass,
        layoutName,
        packageName
    )
    // 保存adapter
    save(adapter, srcOut.resolve("${adapterClass}Adapter.${ktOrJavaExt}"))
    // 保存xml
    save(mvvmActivityXml(false), resOut.resolve("layout/${layoutName}.xml"))

}