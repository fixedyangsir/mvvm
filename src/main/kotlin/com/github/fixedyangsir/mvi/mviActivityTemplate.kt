package com.github.fixedyangsir.mvi

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.github.fixedyangsir.mvi.mviActivityRecipe
import com.github.fixedyangsir.mvvm.activity.defaultPackageNameParameter
import java.io.File

val mviActivityTemplate
    get() = template {
        name = "AA-MVI 一键生成框架"
        description = "适用于MVI框架的Activity或fragment"
        minApi = MIN_API

        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

        var isActivity = booleanParameter {
            name = "是否是activity"
            default = true
            help = "勾选为activity，不勾选为fragment"
//            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
//            suggest = { "${activityToLayout(activityClass.value.toLowerCase())}" }
        }

        val activityClass = stringParameter {
            name = "类名"
            default = "Main"
            help = "只输入名字，不要包含Activity和fragment"
            constraints = listOf(Constraint.NONEMPTY)
        }

        var layoutName = stringParameter {
            name = "Layout Name"
            default = "activity_main"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = {
                if (isActivity.value) {
                    "${activityToLayout(activityClass.value)}"
                } else {
                    "${fragmentToLayout(activityClass.value)}"
                }
            }
        }

        val packageName = defaultPackageNameParameter


        var useDataBinding = booleanParameter {
            name = "是否使用DataBinding"
            default = true
            help = "ture使用dataBinding"
//            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
//            suggest = { "${activityToLayout(activityClass.value.toLowerCase())}" }
        }
        thumb { File("template_empty_activity.png") }
        widgets(
                CheckBoxWidget((isActivity)),
                TextFieldWidget(activityClass),
                TextFieldWidget(layoutName),
                PackageNameWidget(packageName)

        )
//        thumb { File("logo.png") }
        recipe = { data: TemplateData ->
            mviActivityRecipe(
                    data as ModuleTemplateData,
                    activityClass.value,
                    layoutName.value,
                    packageName.value,
                    useDataBinding.value,
                    isActivity.value)
        }
    }


