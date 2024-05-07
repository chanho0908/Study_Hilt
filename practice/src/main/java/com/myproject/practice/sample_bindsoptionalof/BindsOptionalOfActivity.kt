package com.myproject.practice.sample_bindsoptionalof

import android.os.Bundle
import android.util.Log
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
import java.util.Optional
import javax.inject.Inject

@AndroidEntryPoint
class BindsOptionalOfActivity : ComponentActivity() {

    /*
    * @BindsOptionalOf는 반드시 모듈 내의 abstract 메서드에 추가해야 한다.
    * void 타입을 반환해선 안되며 반드시 반환 타입이 있어야 한다.
    * 또한 파라미터를 가질 수 없다.
    *
    * 생성자 바인딩된 의존성은 항상 present 상태이므로 이 경우 해당 의존성은
    * 옵셔널 바인딩이 불가능하다.
    *
    * Optional<Provider<T>>,Optional<Lazy<T>>, Optional<Provider<Lazy<T>>> 형태로 주입 가능
    * */

    @Inject
    lateinit var sample: Optional<OptionalSample>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("BindsOptionalOfActivity", sample.isPresent.toString())

        setContent {
            HiltByCleanArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting4("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting4(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    HiltByCleanArchitectureTheme {
        Greeting4("Android")
    }
}