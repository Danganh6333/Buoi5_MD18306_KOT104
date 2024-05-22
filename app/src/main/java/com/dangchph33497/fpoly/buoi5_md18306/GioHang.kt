package com.dangchph33497.fpoly.buoi5_md18306

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt


@Composable
fun Main(){

    GioHang {

    }
}

@Composable
fun GioHang(innerPadding : PaddingValues = PaddingValues(), selectedMethod : ItemThanhToan? = null, onMethodSelected: (ItemThanhToan) -> Unit) {
    val listItemThanhToan : MutableList<ItemThanhToan> = mutableListOf()

    listItemThanhToan.add(ItemThanhToan(color = Color("#EB8B33".toColorInt()), R.mipmap.paypal, "Paypal"))

    listItemThanhToan.add(ItemThanhToan(color = Color("#D93485".toColorInt()), R.mipmap.momo, "Momo"))

    listItemThanhToan.add(ItemThanhToan(color = Color("#57BFF7".toColorInt()), R.mipmap.zalopay, "Zalo Pay"))

    listItemThanhToan.add(ItemThanhToan(color = Color("#EB8B33".toColorInt()), R.mipmap.paypal, "Paypal"))

    listItemThanhToan.add(ItemThanhToan(color = Color("#D93485".toColorInt()), R.mipmap.momo, "Momo"))

    listItemThanhToan.add(ItemThanhToan(color = Color("#57BFF7".toColorInt()), R.mipmap.zalopay, "Zalo Pay"))

    listItemThanhToan.add(ItemThanhToan(color = Color("#EB8B33".toColorInt()), R.mipmap.paypal, "Paypal"))

    listItemThanhToan.add(ItemThanhToan(color = Color("#D93485".toColorInt()), R.mipmap.momo, "Momo"))

    listItemThanhToan.add(ItemThanhToan(color = Color("#57BFF7".toColorInt()), R.mipmap.zalopay, "Zalo Pay"))

    listItemThanhToan.add(ItemThanhToan(color = Color("#EB8B33".toColorInt()), R.mipmap.paypal, "Paypal"))

    listItemThanhToan.add(ItemThanhToan(color = Color("#D93485".toColorInt()), R.mipmap.momo, "Momo"))

    listItemThanhToan.add(ItemThanhToan(color = Color("#57BFF7".toColorInt()), R.mipmap.zalopay, "Zalo Pay"))
    //endregion

    val context = LocalContext.current

    Box (Modifier.fillMaxSize()) {
        Column (
            Modifier
                .background(color = Color("#2A2727".toColorInt()))
                .fillMaxSize()
                .padding(
                    top = innerPadding.calculateTopPadding() + 10.dp,
                    start = 24.dp,
                    bottom = 24.dp,
                    end = 24.dp
                )){
            getTextTitle(title = "Giỏ Hàng")
            displayContentText()

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
//            GetTextTitle("Trang chu")

                items (listItemThanhToan) {
                        itemThanhToan ->
                    GetRowItem(itemThanhToan.color, itemThanhToan.idRes, itemThanhToan.title, selectedMethod == itemThanhToan, onSelected = {onMethodSelected(itemThanhToan)})

                }

            }
        }

        Button(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(40.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color("#ED7B57".toColorInt())),
            onClick = {
                Toast.makeText(context, selectedMethod?.title ?: "Chua chon phuong thuc thanh toan", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "Thanh Toan", color = Color.White)
        }
    }

}
data class ItemThanhToan (var color: Color, var idRes: Int, var title: String)
@Composable
fun displayContentText() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(11.dp, 30.dp, 0.dp, 30.dp)
    ) {
        displayTextRow()
    }
}

private class ItemModel (var color: Color, var idRes: Int, var title: String)

@Composable
fun displayTextRow() {
    Column (
        modifier = Modifier.fillMaxWidth()
    ) {
        getTextContent(text = "Địa chỉ nhận hàng")
        Row (
            Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)){
            Image(Icons.Default.LocationOn,
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.Red),)
            Column {
                getTextContent(text = "Tri | 222222")
                getTextContent(text = "22/153 Tan Thoi Tay")
                getTextContent(text = "quan 12")
                getTextContent(text = "TP HCM")
            }
        }

        getTextContent(text = "Chọn phương thức thanh toán")
    }
}


@Composable
private fun GetRowItem(color: Color, idRes: Int = R.mipmap.momo, title: String = "Paypal", selected : Boolean, onSelected: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = color, shape = RoundedCornerShape(12.dp))
            .height(70.dp)
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Image(
            painter = painterResource(id = idRes), contentDescription = "",
            modifier = Modifier.size(60.dp)
        )

        Text(
            text = title,
            modifier = Modifier
                .weight(1f)
                .padding(10.dp, 0.dp, 0.dp, 0.dp),
            color = Color.White,
            fontSize = 20.sp
        )

        RadioButton(selected = selected, onClick = {
            onSelected()
        })
    }
}

@Composable
fun ButtonWithColor() {
    val Red = Color(0xFFfe734c)
    Button(
        onClick = { /*TODO*/
        }, colors = ButtonDefaults.buttonColors(
            containerColor = Red
        ), shape = RoundedCornerShape(7.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp, 10.dp)
            .height(50.dp)
    ) {
        Text(
            text = "Tiếp Theo",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 21.sp
        )
    }
}

@Composable
fun getTextContent(text: String) {
    Text(text = text, color = Color.White, fontSize = 15.sp, textAlign = TextAlign.Left)
}

@Composable
fun getTextTitle(title: String) {
    Text(
        text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 10.dp),

        )
}






