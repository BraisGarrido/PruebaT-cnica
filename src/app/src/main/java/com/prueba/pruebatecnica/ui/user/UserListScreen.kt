package com.prueba.pruebatecnica.ui.user

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import androidx.compose.material.Text
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
    // State to keep track of whether the item is expanded or not
    var isExpanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable { isExpanded = !isExpanded }) {

        // Show name and last name
        Text(text = "${user.first_name} ${user.last_name}")

        // If expanded, show additional information
        if (isExpanded) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Email: ${user.email}")
            Text(text = "ID: ${user.id}")
            Image(
                painter = rememberImagePainter(user.avatar),
                contentDescription = null,
                modifier = Modifier.size(64.dp)
            )
        }
    }
}