package com.dangchph33497.fpoly.buoi5_md18306

sealed class Screens(val screen : String) {
    data object Home : Screens("trangChu")
    data object History : Screens("lichSu")
    data object ShoppingCart : Screens("gioHang")
    data object Profile : Screens("hoSo")

}