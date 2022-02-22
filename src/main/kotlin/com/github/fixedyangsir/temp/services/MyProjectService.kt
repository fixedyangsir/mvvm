package com.github.fixedyangsir.temp.services

import com.intellij.openapi.project.Project
import com.github.fixedyangsir.temp.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
