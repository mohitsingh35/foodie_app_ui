package com.ncs.foodie.ui.theme

import android.text.Layout.Alignment
import android.view.RoundedCorner
import android.widget.AdapterView.OnItemClickListener
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ncs.foodie.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.nio.file.WatchEvent.Modifier

@Composable
fun HomeScreen(){
Column() {


    LazyColumn() {
        items(1){
            LazyRow(){
                items(1){
                    banner(items = listOf(
                        BannerContent("Rasgulle",69,R.drawable.gulabjamun),
                        BannerContent("Jalebi",69,R.drawable.jalebi),
                        BannerContent("Pav Bhaji",69,R.drawable.pavbhaji),
                    ))
                }
            }
            Box(modifier = androidx.compose.ui.Modifier.padding(start = 30.dp)){
                button()
            }
            suggested(items = listOf(
                SuggestedContent("Rasgulle",69,R.drawable.gulabjamun),
                SuggestedContent("Jalebi",69,R.drawable.jalebi),
                SuggestedContent("Pav Bhaji",69,R.drawable.pavbhaji),
            ))
        }

    }
}
}



@Composable
fun banner(items:List<BannerContent>, modifier: androidx.compose.ui.Modifier=androidx.compose.ui.Modifier, intitalSelectedItem: Int=0){
    var clicked by remember {
        mutableStateOf(intitalSelectedItem)
    }
    Row(modifier = androidx.compose.ui.Modifier.fillMaxWidth()) {
        items.forEachIndexed { index, bannerContent ->
            bannerItem(item = bannerContent,state=index==clicked) {
                clicked=index
            }
        }
    }

}


@Composable
fun bannerItem(
    item: BannerContent,
    state:Boolean=false,
    onItemClick:()-> Unit
){
    Row(modifier = androidx.compose.ui.Modifier.fillMaxSize()) {

        Box() {
            Box( modifier = androidx.compose.ui.Modifier
                .size(
                    280.dp
                )
                .clip(CircleShape)
                .background(primary)){
            }
            Column(modifier = androidx.compose.ui.Modifier
                .fillMaxSize()
                .padding(start = 55.dp, top = 40.dp)){
                Text(text = item.Title, modifier = androidx.compose.ui.Modifier, fontSize = 50.sp, fontFamily = fjalla, color = Color.White)
                Text(text = "for you", modifier = androidx.compose.ui.Modifier.padding(top = 10.dp),fontSize = 25.sp, color = Color.White, fontWeight = FontWeight.Light)
                Text(text = "₹"+ item.Price, modifier = androidx.compose.ui.Modifier.padding(top = 10.dp),fontSize = 35.sp, color = Color.White, fontWeight = FontWeight.Bold)
            }
            Box(modifier = androidx.compose.ui.Modifier.padding(top = 30.dp, start = 150.dp)){
                Image(painter = painterResource(id =item.Image ) , contentDescription = "Image", modifier = androidx.compose.ui.Modifier.size(
                    290.dp
                ),contentScale=ContentScale.Crop )
            }
            Box(modifier = androidx.compose.ui.Modifier.padding(top = 100.dp, start = 380.dp)){
                Icon(
                    painter = painterResource(R.drawable.next),
                    contentDescription ="next",
                    modifier = androidx.compose.ui.Modifier
                        .size(25.dp)
                        .clickable { onItemClick() },
                    tint = primary
                )
            }
        }
    }
}
@Composable
fun button(){
    Box(modifier = androidx.compose.ui.Modifier
        .clip(RoundedCornerShape(25.dp))
        .background(primary)
        , contentAlignment = androidx.compose.ui.Alignment.Center)
    {
        Text(text = "Buy", fontSize = 25.sp, color = Color.White, modifier = androidx.compose.ui.Modifier.padding(
            start = 25.dp,
            end = 25.dp,
            top = 5.dp,
            bottom = 5.dp
        ), fontWeight = FontWeight.Bold )
    }
        Text(text = "Fresh", fontSize = 35.sp, color = Color.Gray, modifier = androidx.compose.ui.Modifier.padding(
            start = 240.dp
        ), fontWeight = FontWeight.Bold, )
}
@Composable
fun suggested(items:List<SuggestedContent>, modifier: androidx.compose.ui.Modifier=androidx.compose.ui.Modifier, intitalSelectedItem: Int=0){
    var clicked by remember {
        mutableStateOf(intitalSelectedItem)
    }
    Column {
        items.forEachIndexed { index, suggested ->
            suggestedItem(item = suggested,state=index==clicked) {
                clicked=index
            }
        }
    }

}

@Composable
fun suggestedItem(
    item: SuggestedContent,
    state:Boolean=false,
    onItemClick:()-> Unit
){
    Row(modifier = androidx.compose.ui.Modifier.fillMaxWidth()) {
        Image(painter = painterResource(id =item.Image ) , contentDescription = "Image", modifier = androidx.compose.ui.Modifier.size(
            200.dp
        ) ,contentScale=ContentScale.Crop)
        Row() {
            Box(modifier = androidx.compose.ui.Modifier){
                Box(modifier = androidx.compose.ui.Modifier.padding(top = 30.dp,start=25.dp)){
                    Image(painter = painterResource(R.drawable.rect ) , contentDescription = "Image", modifier = androidx.compose.ui.Modifier.size(
                        height = 100.dp, width = 200.dp
                    ) )
                }

                Column(modifier = androidx.compose.ui.Modifier
                    .fillMaxSize()
                    .padding(start = 50.dp, top = 35.dp)){
                    Text(text = item.Title, modifier = androidx.compose.ui.Modifier, fontSize = 20.sp, fontFamily = fjalla, color = Color.White)
                    Text(text = "want some...?", modifier = androidx.compose.ui.Modifier,fontSize = 15.sp, color = Color.White, fontWeight = FontWeight.Light)
                    Text(text = "₹"+ item.Price, modifier = androidx.compose.ui.Modifier,fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold)
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
