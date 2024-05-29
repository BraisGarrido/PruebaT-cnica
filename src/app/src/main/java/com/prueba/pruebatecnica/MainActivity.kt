package com.prueba.pruebatecnica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.prueba.pruebatecnica.data.network.RetrofitClient
import com.prueba.pruebatecnica.data.repository.UserRepository
import com.prueba.pruebatecnica.ui.theme.PruebaTecnicaTheme
import com.prueba.pruebatecnica.ui.user.UserListScreen
import com.prueba.pruebatecnica.viewmodel.UserViewModel
import com.prueba.pruebatecnica.viewmodel.UserViewModelFactory

class MainActivity : ComponentActivity() {

    private val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory(UserRepository(RetrofitClient.apiService))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp(userViewModel)
        }
    }
}

@Composable
fun MyApp(userViewModel: UserViewModel) {
    PruebaTecnicaTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            UserListScreen(userViewModel)
        }
    }
}