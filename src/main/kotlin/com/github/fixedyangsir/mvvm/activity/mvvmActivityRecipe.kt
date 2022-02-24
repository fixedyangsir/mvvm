package com.github.fixedyangsir.mvvm.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.github.fixedyangsir.mvvm.activity.res.layout.mvvmActivityXml
import com.github.fixedyangsir.mvvm.activity.src.app_package.mvvmActivityKt
import com.github.fixedyangsir.mvvm.activity.src.app_package.mvvmViewModel




fun RecipeExecutor.mvvmActivityRecipe(
        moduleData: ModuleTemplateData,
        activityClass: String,
        layoutName: String,
        packageName: String,
        userDataBinding: Boolean,
        isActivity: Boolean
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
//    generateManifest(
//            moduleData = moduleData,
//            activityClass = "${activityClass}Activity",
//            activityTitle = activityClass,
//            packageName = packageName,
//            isLauncher = false,
//            hasNoActionBar = false,
//            generateActivityTitle = true,
//            requireTheme = false,
//            useMaterial2 = false
//    )

    val mvvmActivity = mvvmActivityKt(isActivity,projectData.applicationPackage, activityClass, layoutName, packageName,userDataBinding)
    // 保存Activity
    if (isActivity) {

       /* generateManifest(
            moduleData = moduleData,
            activityClass = "${activityClass}Activity",
            packageName = packageName,
            isLauncher = false,
            hasNoActionBar = false,
            generateActivityTitle = false,
            )*/


        save(mvvmActivity, srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
    }else{
        save(mvvmActivity, srcOut.resolve("${activityClass}Fragment.${ktOrJavaExt}"))
    }
    // 保存xml
    save(mvvmActivityXml(userDataBinding), resOut.resolve("layout/${layoutName}.xml"))
    // 保存viewmodel
    save(mvvmViewModel(packageName, activityClass), srcOut.resolve("vm/${activityClass}VM.${ktOrJavaExt}"))
}