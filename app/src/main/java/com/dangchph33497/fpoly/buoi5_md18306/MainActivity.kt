package com.dangchph33497.fpoly.buoi5_md18306

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dangchph33497.fpoly.buoi5_md18306.ui.theme.Buoi5_MD18306Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Buoi5_MD18306Theme {
                MyBottomAppBar()
            }
        }
    }
}

@Preview
@Composable
fun MyBottomAppBar() {
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }
    Scaffold(bottomBar = {
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
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "trangChu",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Home) Color.Yellow else Color.White
                    )
                    Text(
                        text = "Trang Chủ",
                        fontSize = 12.sp,
                        color = if (selected.value == Icons.Default.Home) Color.Yellow else Color.White
                    )
                }
            }
            IconButton(
                onClick = {
                    selected.value = Icons.Default.DateRange
                    navigationController.navigate(Screens.History.screen) {
                        popUpTo(0)
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "lichSu",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.DateRange) Color.Yellow else Color.White
                    )
                    Text(
                        text = "Lịch Sử",
                        fontSize = 12.sp,
                        color = if (selected.value == Icons.Default.DateRange) Color.Yellow else Color.White
                    )
                }
            }

            IconButton(
                onClick = {
                    selected.value = Icons.Default.ShoppingCart
                    navigationController.navigate(Screens.ShoppingCart.screen) {
                        popUpTo(0)
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "gioHang",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.ShoppingCart) Color.Yellow else Color.White
                    )
                    Text(
                        text = "Giỏ Hàng",
                        fontSize = 12.sp,
                        color = if (selected.value == Icons.Default.ShoppingCart) Color.Yellow else Color.White
                    )
                }
            }

            IconButton(
                onClick = {
                    selected.value = Icons.Default.AccountCircle
                    navigationController.navigate(Screens.Profile.screen) {
                        popUpTo(0)
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "hoSo",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.AccountCircle) Color.Yellow else Color.White
                    )
                    Text(
                        text = "Hồ Sơ",
                        fontSize = 12.sp,
                        color = if (selected.value == Icons.Default.AccountCircle) Color.Yellow else Color.White
                    )
                }
            }
        }
    }) { paddingValues ->
        NavHost(
            navController = navigationController, startDestination = Screens.Home.screen,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screens.Home.screen) { TrangChu() }
            composable(Screens.History.screen) { LichSu() }
            composable(Screens.ShoppingCart.screen) { Main() }
            composable(Screens.Profile.screen) { HoSo() }
        }

    }

}

