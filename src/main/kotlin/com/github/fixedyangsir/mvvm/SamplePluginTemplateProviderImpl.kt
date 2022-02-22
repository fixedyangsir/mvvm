package com.github.fixedyangsir.mvvm

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import com.github.fixedyangsir.mvvm.activity.mvvmActivityTemplate
import com.github.fixedyangsir.mvvm.adapter.adapterTemplate

/**
 * Created by yzy on 2022/2/21.
 */
class SamplePluginTemplateProviderImpl: WizardTemplateProvider() {
    override fun getTemplates(): List<Template> = listOf(
        mvvmActivityTemplate,
        adapterTemplate
    )
}