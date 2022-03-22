package com.github.fixedyangsir.mvvm.adapter

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import java.io.File

val adapterTemplate
    get() = template {
        name = "AA-快速生成Adapter"
        description = "适用于BaseRecyclerViewAdapterHelper框架"
        minApi = MIN_API

        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )


        val adapterClass = stringParameter {
            name = "类名"
            default = "Main"
            help = "只输入名字，不要包含Adapter"
            constraints = listOf(Constraint.NONEMPTY)
        }

        var layoutName = stringParameter {
            name = "Layout Name"
            default = "list_item_user"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = {
                "list_item_" + activityToLayout(adapterClass.value).replace("activity_","")
            }
        }

        val packageName = defaultPackageNameParameter

        thumb { File("template_empty_activity.png") }
        widgets(
            TextFieldWidget(adapterClass),
            TextFieldWidget(layoutName),
            PackageNameWidget(packageName)
        )
//        thumb { File("logo.png") }
        recipe = { data: TemplateData ->
            adapterRecipe(
                data as ModuleTemplateData,
                adapterClass.value,
                layoutName.value,
                packageName.value,
            )
        }
    }


val defaultPackageNameParameter
    get() = stringParameter {
        name = "Package name"
        visible = { !isNewModule }
        default = "com.easy.app"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }