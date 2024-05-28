package com.prueba.pruebatecnica.ui.user

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.prueba.pruebatecnica.data.model.User
import com.prueba.pruebatecnica.viewmodel.UserViewModel

@Composable
fun UserListScreen(userViewModel: UserViewModel) {
    val users = userViewModel.users.collectAsState()
    LazyColumn {
        items(users.value) { user ->
            UserItem(user)
        }
    }
}

@Composable
fun UserItem(user: User) {
    Text(text = "${user.first_name} ${user.last_name} - ${user.email}")
}