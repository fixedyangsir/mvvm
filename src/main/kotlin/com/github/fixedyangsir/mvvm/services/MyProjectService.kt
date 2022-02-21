package com.github.fixedyangsir.mvvm.services

import com.intellij.openapi.project.Project
import com.github.fixedyangsir.mvvm.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
