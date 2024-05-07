package com.myproject.practice.sample_custom_component

import dagger.hilt.DefineComponent
import dagger.hilt.android.components.ActivityComponent


@DialogScoped
@DefineComponent(parent = ActivityComponent::class) // 확장할 Component 정의
interface DialogComponent {
}