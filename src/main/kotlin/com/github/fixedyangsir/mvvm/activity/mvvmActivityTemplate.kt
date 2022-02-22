package com.github.fixedyangsir.mvvm.activity

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import java.io.File

val mvvmActivityTemplate
    get() = template {
        name = "AA-MVVM 一键生成框架"
        description = "适用于MVVM框架的Activity或fragment"
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
                    "${activityToLayout(activityClass.value.toLowerCase())}"
                } else {
                    "${fragmentToLayout(activityClass.value.toLowerCase())}"
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
                PackageNameWidget(packageName),
                CheckBoxWidget((useDataBinding))
        )
//        thumb { File("logo.png") }
        recipe = { data: TemplateData ->
            mvvmActivityRecipe(
                    data as ModuleTemplateData,
                    activityClass.value,
                    layoutName.value,
                    packageName.value,
                    useDataBinding.value,
                    isActivity.value)
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