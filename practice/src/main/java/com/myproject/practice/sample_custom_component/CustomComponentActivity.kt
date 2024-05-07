package com.myproject.practice.sample_custom_component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.myproject.practice.sample_custom_component.ui.theme.HiltByCleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * 1. 커스텀 컴포넌트 인터페이스 정의
 * 2. 커스텀 커포넌트 빌더 정의
 * 3. 커스텀 컴포넌트 EntryPoint 만들기
 * 4. 커스텀 컴포넌트 매니저 정의
 * 5. 커스텀 스코프 정의
 *
 * 커스텀 컴포넌트 단점
 * 커스텀 컴포넌트, 스코프 사용은 오버헤드가 추가된다.
 * 오브젝트 그래프가 복잡해진다.
 * 컴포넌트는 하나의 부모 컴포넌트만 가진다.
 * 커스텀 컴포넌트는 표준화를 위반한다.
 *
 * 커스텀 컴포넌트 사용시 주의사항
 * 컴포넌트의 생명주기가 명확해야 한다
 * 커스텀 컴포넌트의 사용처가 명확하고, 범용적이여야 한다
 * Hilt 컴포넌트 대신 Dagger 컴포넌트의 정의로 충분한지 고려해보자.
 * 커스텀 컴포넌트는 직접적이든 간적적이든 SingletonComponent의 하위에 위치해야 한다
 * 컴포넌트 계층 구조상, 표준 컴포넌트들 사이에 커스텀 컴포넌트를 위치시킬 순 없다
* */

@AndroidEntryPoint
class CustomComponentActivity : ComponentActivity() {

    @Inject
    lateinit var myDialog: MyDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myDialog.show()
    }
}

@Composable
fun Greeting8(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview8() {
    HiltByCleanArchitectureTheme {
        Greeting8("Android")
    }
}