package com.myproject.practice.sample_custom_component

import dagger.BindsInstance
import dagger.hilt.DefineComponent
import java.time.LocalDateTime

@DefineComponent.Builder
interface DialogComponentBuilder {

    // 커스텀 컴포넌트 빌더 제약 조건
    // setter 메서드 : 파라미터 1개 반환 타입은 컴포넌트 빌더(선택)
    fun setLocalDateTime(@BindsInstance localDateTime: LocalDateTime): DialogComponentBuilder
    // build 메서드 : 파라미터 0개, 반환 타입은 컴포넌트(필수)
    fun build(): DialogComponent
}