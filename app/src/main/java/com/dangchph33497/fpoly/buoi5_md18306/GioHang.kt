package com.dangchph33497.fpoly.buoi5_md18306

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class GioHang : ComponentActivity() {
    val Orange = Color(0xFFFa8500)
    val Pink = Color(0xFFec1387)
    val Turquoise = Color(0xFF00c2fd)
    val Teal = Color(0xFF18ebea)
    val Red = Color(0xFFfe734c)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            displayLayout()
        }
    }

    @Preview
    @Composable
    fun displayLayout(title: String = "Thanh Toán") {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(color = Color.Black)
                .padding(10.dp)
        ) {
            getTextTitle(title = "Thanh Toán")
            displayContentText()
            getRowItem(title = "PayPal", color = Orange, image = R.mipmap.paypal)
            getRowItem(title = "Visa", color = Color.White, image = R.mipmap.visa)
            getRowItem(title = "Momo", color = Pink, image = R.mipmap.momo)
            getRowItem(title = "Zalo Pay", color = Turquoise, image = R.mipmap.zalopay)
            getRowItem(title = "Thanh toán trực tiếp", color = Teal, image = R.mipmap.paypal)
            ButtonWithColor()
        }
    }

    @Composable
    fun displayContentText(){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(11.dp, 30.dp, 0.dp, 30.dp)
        ) {
            getTextContent(text = "Địa chỉ nhận hàng")
            displayTextRow()
            getTextContent(text = "Vui lòng chọn một trong những phương án sau")
        }
    }

    @Composable
    fun displayTextRow(){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(11.dp, 30.dp, 0.dp, 30.dp)
        ) {
            Image(painter = painterResource(id = R.mipmap.map) , contentDescription = "" , modifier = Modifier
                .width(100.dp)
                .padding(30.dp))
            getTextContent(text = "Tri | 222222 \n" + "22/333 đường Trung Mỹ Tây 1 \n" + "phường Tân Thới Nhất \n" + "quận 12,Thành phố Hồ Chí Minh")
        }
    }


    @Composable
    fun getRowItem(title: String, color: Color, image: Int) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(10.dp)
                .background(color = color, shape = RoundedCornerShape(10.dp))
                .height(60.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = image), contentDescription = "", modifier = Modifier
                    .padding(10.dp)
                    .width(70.dp)
            )
            Text(
                text = title,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(1f)
                    .padding(30.dp, 0.dp, 0.dp, 0.dp)
            )
            RadioButton(selected = false, onClick = { /*TODO*/ })

        }
    }

    @Composable
    fun ButtonWithColor() {
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
            Text(text = "Tiếp Theo", color = Color.White, textAlign = TextAlign.Center, fontSize = 21.sp)
        }

    }

    @Composable
    fun getTextContent(text : String){
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
                .padding(10.dp),

            )
    }


}



