package com.myproject.practice.sample_binds

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
import javax.inject.Inject

@AndroidEntryPoint
class BindsActivity : ComponentActivity() {

    /*
    * @Binds는 반드시 모듈 내의 abstract 메서드에 추가해야 한다.
    * @Binds 메서드는 반드시 파라미터 "1개"를 가져야 한다.
    * 파라미터 타입이 반환 타입의 서브타입이어야 한다.
    * Scope 및 Qulifier 어노테이션과 함께 사용할 수 있다.
    * */

    @Inject
    lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("BindsActivity", "엔진 타입 : ${car.engine}")

        setContent {
            HiltByCleanArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting3("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    HiltByCleanArchitectureTheme {
        Greeting3("Android")
    }
}