package com.myproject.practice.sample_qulifier

import javax.inject.Inject

// 컴파일 타임에 의존성 바인딩
//class Foo @Inject constructor(val bar: Bar){
//}
class Foo constructor(val id: String){
}