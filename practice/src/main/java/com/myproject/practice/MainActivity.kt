package com.myproject.practice

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
import com.myproject.practice.sample_qulifier.Foo
import com.myproject.practice.sample_qulifier.User
import com.myproject.practice.sample_qulifier.UserQualifier
import com.myproject.practice.ui.theme.HiltByCleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
//    @Inject
//    lateinit var foo: Foo
//    @Inject
//    lateinit var bar: Bar
    lateinit var foo: Foo

    @UserQualifier(50, 180)
    @Inject
    lateinit var charles: User

    @UserQualifier(10, 120)
    @Inject
    lateinit var john: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("UserQualifier", "charles : ${charles.name}")
        Log.d("UserQualifier", "jhon : ${john.name}")

        //assert(this::foo.isInitialized)
        //assert(this::bar.isInitialized)
        //assert(foo.bar != null)

        setContent {
            HiltByCleanArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Hello Mamnbo")
                }
            }
        }
    }

    @Inject
    fun injectFoo(
        @Named("foo1") foo: Foo
    ){
        Log.d("FooID", "injectFoo : ${foo.id}")
        this.foo = foo
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HiltByCleanArchitectureTheme {
        Greeting("Android")
    }
}