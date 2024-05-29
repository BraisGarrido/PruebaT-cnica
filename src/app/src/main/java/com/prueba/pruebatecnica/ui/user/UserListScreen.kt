package com.prueba.pruebatecnica.ui.user

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.border
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.prueba.pruebatecnica.data.model.User
import com.prueba.pruebatecnica.viewmodel.UserViewModel

@Composable
fun UserListScreen(userViewModel: UserViewModel) {
    val users by userViewModel.users.collectAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(users) { user ->
            UserItem(user)
        }
    }
}

@Composable
fun UserItem(user: User) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { isExpanded = !isExpanded },
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "${user.first_name} ${user.last_name}",
                style = MaterialTheme.typography.h6.copy(fontSize = 20.sp)
            )

            if (isExpanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    AsyncImage(
                        model = user.avatar,
                        contentDescription = null,
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .border(2.dp, MaterialTheme.colors.primary, CircleShape)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "Email: ${user.email}",
                            style = MaterialTheme.typography.body1.copy(fontSize = 16.sp)
                        )
                        Text(
                            text = "ID: ${user.id}",
                            style = MaterialTheme.typography.body1.copy(fontSize = 16.sp)
                        )
                    }
                }
            }
        }
    }
}