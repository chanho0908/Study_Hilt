package com.myproject.practice.sample_provider

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
import com.myproject.practice.ui.theme.HiltByCleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class ProviderActivity : ComponentActivity() {

    // Provider<T> : get 메서드를 호출할 때마다 새로운 인스턴스를 반환한다.
    // 만약 T 바인딩에 Scope가 지정되어 있다면 Provider<T>의 get() 메서드를 호출할 때
    // 동일한 인스턴스 T를 반환하고
    // Provider<T> 요청에 동일한 Provider<T> 인스턴스가 주입된다.
    // 하나의 Provider<T> 로 여러 T 인스턴스를 생성하고 싶을 때 사용한다.

    @Inject
    lateinit var sample: Provider<ProviderSample>

    @Inject
    lateinit var sample2: Provider<ProviderSample>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sample1 = sample.get()
        val sample2 = sample2.get()

        // 스코프를 지정하지 않을 경우 2개의 인스턴스를 만들기 때문에 false
        // @Singleton으로 스코프를 지정할 경우 같은 인스턴스를 주입한다.
        assert(sample1 === sample2)

        setContent {
            HiltByCleanArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    HiltByCleanArchitectureTheme {
        Greeting2("Android")
    }
}