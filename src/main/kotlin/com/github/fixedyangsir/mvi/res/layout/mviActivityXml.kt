package com.github.fixedyangsir.mvi.res.layout

fun mviActivityXml(userDataBinding: Boolean) =
        if (userDataBinding) {
            """
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>

    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        >

      


    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>"""
        } else {
            """
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
        >

      


    </androidx.constraintlayout.widget.ConstraintLayout>
"""
        }