package com.myproject.practice.sample_custom_component

import dagger.hilt.DefineComponent
import dagger.hilt.android.components.ActivityComponent

@DialogScoped
@DefineComponent(parent = ActivityComponent::class)
interface DialogComponent {
}