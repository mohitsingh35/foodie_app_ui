package com.ncs.foodie.ui.theme

import android.text.Editable
import android.text.style.UnderlineSpan
import android.widget.EditText
import android.widget.ImageView.ScaleType
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ncs.foodie.R

@Composable
fun OrderScreen(){
    Column() {

        LazyColumn(){
            items(1){
                header()
                restraunts()
                Box( modifier = Modifier.fillMaxWidth(),contentAlignment = Alignment.Center,) {
                    Text(
                        text = "Categories",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )
                }
                Box() {
                    categoriesbg()
                    Box(Modifier.padding(top = 30.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)) {
                        categories(items = listOf(
                            CategoryDetails("Sweets",R.drawable.gulabjamun),
                            CategoryDetails("Main Course",R.drawable.maincourse),
                            CategoryDetails("Beverages",R.drawable.beverages),
                        ))
                    }
                }



            }
        }


    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun header(){
    var value by remember {
        mutableStateOf("")
    }
    Row(modifier = Modifier.padding(start = 10.dp, end = 10.dp,top=5.dp)) {
        Icon(
            painter = painterResource(R.drawable.location),
            contentDescription ="location",
            modifier = Modifier
                .size(35.dp),
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = "Noida", fontSize = 20.sp, fontWeight = FontWeight.Medium, color = Color.Black, modifier = Modifier.padding(top = 5.dp))
        Spacer(modifier = Modifier.width(30.dp))
        Box(modifier = Modifier
            .width(240.dp)
            .clip(RoundedCornerShape(40.dp))
            .border(3.dp, color = Color.Black, shape = RoundedCornerShape(40.dp))) {
            Row(modifier = Modifier.height(40.dp), verticalAlignment = Alignment.CenterVertically ) {

                Box(modifier = Modifier.padding(start = 20.dp)){
                    Box {
                        BasicTextField(
                            value = value,
                            maxLines = 1,
                            onValueChange = { value = it }
                        )
                        if (value.isEmpty()) {
                            Text(text = "Restaurants near you...")
                        }
                    }
                }
                if(value.isEmpty()){
                    Box(modifier = Modifier.padding(start = 20.dp)) {
                        Icon(
                            painter = painterResource(R.drawable.search),
                            contentDescription ="search",
                            modifier = Modifier
                                .size(25.dp),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun restraunts(){
    Box(Modifier.padding(top = 30.dp, start = 20.dp, bottom = 20.dp)) {
        Box(modifier = Modifier
            .clip(RoundedCornerShape(topStart = 40.dp, bottomStart = 40.dp))
            .background(primary)
            .fillMaxWidth(2f)
            .height(300.dp)
        ){
            LazyRow(){
                items(count = 1){
                    resbanner(items = listOf(
                        RestarauntDetails("Mehfil",R.drawable.mehfil),
                        RestarauntDetails("Wow Momo",R.drawable.momos),
                        RestarauntDetails("Haldiram's",R.drawable.zaika),
                    ))
                }
            }

        }
    }

}
@Composable
fun resbanner(items:List<RestarauntDetails>, modifier: androidx.compose.ui.Modifier=androidx.compose.ui.Modifier, intitalSelectedItem: Int=0){
    var clicked by remember {
        mutableStateOf(intitalSelectedItem)
    }
    Row(modifier = androidx.compose.ui.Modifier.fillMaxWidth()) {
        items.forEachIndexed { index, bannerContent ->
            resbannerItem(item = bannerContent,state=index==clicked) {
                clicked=index
            }
        }
    }

}

@Composable
fun resbannerItem(
    item: RestarauntDetails,
    state:Boolean=false,
    onItemClick:()-> Unit
){
    Box(modifier = Modifier.padding(start = 30.dp, top = 30.dp, bottom = 30.dp)) {
        Box(modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .width(200.dp)) {
            Image(painter = painterResource(id = item.image), contentDescription ="Image", modifier = Modifier
                .width(220.dp)
                .height(250.dp),contentScale=ContentScale.Crop )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            accent
                        )
                    )
                ))
            Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 25.dp)){
            Row() {
                    Icon(
                        painter = painterResource(R.drawable.location),
                        contentDescription ="buy",
                        modifier = androidx.compose.ui.Modifier
                            .size(25.dp)
                            .clickable { onItemClick() },
                        tint = Color.White
                    )
                Spacer(modifier = Modifier.width(5.dp))
                    Text(text = item.title, fontSize = 25.sp, color = Color.White, fontWeight = FontWeight.Medium)

                }

            }

        }
    }

}

@Composable
fun categoriesbg(){
    Box(Modifier.padding(top = 30.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)) {
        Box(modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .background(accent)
            .fillMaxWidth(2f)
            .height(460.dp)
        ){
//            LazyColumn(){
//                items(1){
//
//                }
//            }


        }
    }

}

@Composable
fun categories(items:List<CategoryDetails>, modifier: androidx.compose.ui.Modifier=androidx.compose.ui.Modifier, intitalSelectedItem: Int=0){
    var clicked by remember {
        mutableStateOf(intitalSelectedItem)
    }
    Column {
        items.forEachIndexed { index, suggested ->
            categoriesItem(item = suggested,state=index==clicked) {
                clicked=index
            }
        }
    }

}

@Composable
fun categoriesItem(
    item: CategoryDetails,
    state:Boolean=false,
    onItemClick:()-> Unit
){
    Row(modifier = androidx.compose.ui.Modifier.fillMaxSize()) {
        Image(painter = painterResource(id =item.image ) , contentDescription = "Image", modifier = androidx.compose.ui.Modifier.size(
            160.dp
        ) ,contentScale=ContentScale.Crop)
        Row() {
            Box(modifier = androidx.compose.ui.Modifier){
                Box(modifier = androidx.compose.ui.Modifier.padding(top = 30.dp, start = 25.dp)){
                    Image(painter = painterResource(R.drawable.rect ) , contentDescription = "Image", modifier = androidx.compose.ui.Modifier.size(
                        height = 100.dp, width = 200.dp
                    ) )
                }

                Column(modifier = androidx.compose.ui.Modifier
                    .fillMaxSize()
                    .padding(start = 50.dp, top = 50.dp)){
                    Text(text = item.title, modifier = androidx.compose.ui.Modifier, fontSize = 18.sp, fontFamily = fjalla, color = Color.White)
                    Text(text = "Order Now", modifier = androidx.compose.ui.Modifier,fontSize = 15.sp, color = Color.White, fontWeight = FontWeight.Light)
                }
                Box(modifier = androidx.compose.ui.Modifier.padding(start = 135.dp, top = 52.dp)){
                    Icon(
                        painter = painterResource(R.drawable.buycart),
                        contentDescription ="buy",
                        modifier = androidx.compose.ui.Modifier
                            .size(40.dp)
                            .clickable { onItemClick() },
                        tint = Color.White
                    )
                }

            }

        }

    }


}