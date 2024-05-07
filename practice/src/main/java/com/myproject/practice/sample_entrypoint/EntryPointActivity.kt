package com.myproject.practice.sample_entrypoint

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
import com.myproject.practice.sample_entrypoint.ui.theme.HiltByCleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Entry Point
 * Hilt 의존성 주입이 어려운 코드에서 바인딩된 의존성을 참조하는 방법
 *
 * 사용 예시
 * Hilt를 사용하지 않는 라이브러리에서 의존성 주입이 어려울 때
 * Hilt가 지원하지 않는 안드로이드 컴포넌트에 의존성 주입이 어려울 때
 * Dynamic Feature Module에 의존성 주입이 필요할 때
 *
 * */
@AndroidEntryPoint
class EntryPointActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val manager = EntryManager()
        manager.getEntry(this.applicationContext)


        setContent {
            HiltByCleanArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting7("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting7(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview7() {
    HiltByCleanArchitectureTheme {
        Greeting7("Android")
    }
}