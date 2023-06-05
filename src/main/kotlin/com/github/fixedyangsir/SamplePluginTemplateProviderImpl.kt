package com.github.fixedyangsir

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import com.github.fixedyangsir.mvvm.activity.mvvmActivityTemplate
import com.github.fixedyangsir.mvvm.adapter.adapterTemplate
import com.github.fixedyangsir.mvi.mviActivityTemplate

/**
 * Created by yzy on 2022/2/21.
 */
class SamplePluginTemplateProviderImpl: WizardTemplateProvider() {
    override fun getTemplates(): List<Template> = listOf(
        mvvmActivityTemplate,
        adapterTemplate,
        mviActivityTemplate
    )
}