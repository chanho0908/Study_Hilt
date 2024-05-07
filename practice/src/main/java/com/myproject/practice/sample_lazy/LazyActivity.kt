package com.myproject.practice.sample_lazy

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
import dagger.Lazy
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SampleActivity : ComponentActivity(){

    /*
        Lazy(T)의 get() 메서드를 호출할 떄 T를 반환한다. get() 호출 시점에 T가 인스턴스화 된다.
        Lazy(T)의 get() 호출 이후 다시 get() 을 호출하면 캐시된(동일한) T 인스턴스를 얻는다.
        T 바인딩에 Scope가 지정되어 있다면, 각 Lazy(T) 요청에 대해
        동일한 Lazy<T> 인스턴스가 주입된다.
        특정 시점에 바인딩 인스턴스화 할 때 사용하면 좋다.
        인스턴스 생성에 비용이 큰 경우 사용하면 좋다.
     */

    @Inject
    lateinit var sample: Lazy<LazySample>

    @Inject
    lateinit var sample2: Lazy<LazySample>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        assert(this::sample.isInitialized)
        assert(sample.get() != null)

        //assert(sample !== sample2) 종료
        assert(sample === sample2)
        setContent {
            HiltByCleanArchitectureTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Farewell(name = " Hello ")
                }
            }
        }
    }
}

@Composable
fun Farewell(name: String, modifier: Modifier = Modifier){
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun FarewellPreview() {
    HiltByCleanArchitectureTheme {
        Farewell("Android")
    }
}
