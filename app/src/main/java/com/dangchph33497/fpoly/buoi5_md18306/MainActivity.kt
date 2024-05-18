package com.dangchph33497.fpoly.buoi5_md18306

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.compose.rememberNavController
import com.dangchph33497.fpoly.buoi5_md18306.ui.theme.Buoi5_MD18306Theme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Buoi5_MD18306Theme {
                MyBottomAppBar()
            }
        }
    }
}

@Composable
fun MyBottomAppBar() {
    val navigationController = rememberNavController()
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }
    BottomAppBar(containerColor = Color.DarkGray) {
        IconButton(
            onClick = {
                selected.value = Icons.Default.Home
                navigationController.navigate(Screens.Home.screen) {
                    popUpTo(0)
                }
            },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "trangChu",
                modifier = Modifier.size(26.dp),
                tint = if (selected.value == Icons.Default.Home) Color.White else Color.DarkGray
            )
        }

        IconButton(
            onClick = {
                selected.value = Icons.Default.DateRange
                navigationController.navigate(Screens.History.screen) {
                    popUpTo(1)
                }
            },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = "lichSu",
                modifier = Modifier.size(26.dp),
                tint = if (selected.value == Icons.Default.DateRange) Color.White else Color.DarkGray
            )
        }

        IconButton(
            onClick = {
                selected.value = Icons.Default.ShoppingCart
                navigationController.navigate(Screens.ShoppingCart.screen) {
                    popUpTo(3)
                }
            },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "gioHang",
                modifier = Modifier.size(26.dp),
                tint = if (selected.value == Icons.Default.ShoppingCart) Color.White else Color.DarkGray
            )
        }

        IconButton(
            onClick = {
                selected.value = Icons.Default.AccountCircle
                navigationController.navigate(Screens.Profile.screen) {
                    popUpTo(4)
                }
            },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "trangChu",
                modifier = Modifier.size(26.dp),
                tint = if (selected.value == Icons.Default.AccountCircle) Color.Yellow else Color.DarkGray
            )
        }
    }
}

