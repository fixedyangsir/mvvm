package com.github.fixedyangsir.mvi

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.github.fixedyangsir.mvi.res.layout.mviActivityXml
import com.github.fixedyangsir.mvi.src.app_package.mviActivityKt
import com.github.fixedyangsir.mvi.src.app_package.mviViewModel





fun RecipeExecutor.mviActivityRecipe(
        moduleData: ModuleTemplateData,
        activityClass: String,
        layoutName: String,
        packageName: String,
        userDataBinding: Boolean,
        isActivity: Boolean
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = "kt"
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

    val mviActivity = mviActivityKt(isActivity,projectData.applicationPackage, activityClass, layoutName, packageName)
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


        save(mviActivity, srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
    }else{
        save(mviActivity, srcOut.resolve("${activityClass}Fragment.${ktOrJavaExt}"))
    }
    // 保存xml
    save(mviActivityXml(userDataBinding), resOut.resolve("layout/${layoutName}.xml"))
    // 保存viewmodel
    save(mviViewModel(packageName, activityClass), srcOut.resolve("vm/${activityClass}VM.${ktOrJavaExt}"))
}