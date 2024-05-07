package com.myproject.practice.sample_binds


/**
 *  @Binds, @Provides 함께 사용시 주의해야 할 내용
 *
 *  @Provides 메소드를 접근하고 사용하기 위해선 반드시 인스턴스화 가능한 객체가 있어야 하기 때문에
 *  인스턴스화 가능한 콘트리드 클래스 내에서 선언해야 한다.
 *
 *  하지만 @Binds는 abstract class는 구현되지 않은 상태의 Class이기 때문에 인스턴스를 생성할 수 없다.
 *
 *  그렇기 때문에 @Provides 와 @Binds는 각각 독립된 모듈에서 만드는게 좋으나
 *  꼭 같이 존재해야 한다면 companion object{ } 를 사용해야한다.
 *

    @Module
    @InstallIn(SingletonComponent::class)
    abstract class MyModule {

        companion object{
            @Provides
            fun provideFoo(): Foo {return Foo("abc")}
        }

        @Binds
        abstract fun bindsEngine(engine: GasolineEngine): Engine
    }

*/