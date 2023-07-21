package com.ncs.foodie.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ncs.foodie.R

@Composable
fun actionBar(
    items:List<ActionBarContent>,
    modifier: androidx.compose.ui.Modifier=androidx.compose.ui.Modifier,
    selectedColor: Color = primary,
    intitalSelectedItem:Int=2,
    navController: NavController,
    onItemClick: (ActionBarContent) -> Unit
){
    val backStackEntry=navController.currentBackStackEntryAsState()
    var state by remember { mutableStateOf(intitalSelectedItem) }
    Row (
        modifier = Modifier
            .padding(top = 30.dp, start = 30.dp, end = 30.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){

        items.forEach{item ->
            val state=item.route==backStackEntry.value?.destination?.route
            ActionBarItem(item = item, state = state, onItemClick = {onItemClick(item)})
        }

    }
}
@Composable
fun ActionBarItem(
    item: ActionBarContent,
    state:Boolean=false,
    selectedColor: Color = primary,
    onItemClick:()-> Unit
){
    Row() {
        Icon(
            painter = painterResource(item.iconId),
            contentDescription ="item",
            modifier = Modifier
                .size(33.dp)
                .clickable { onItemClick() },
            tint = if (state) selectedColor else Color.Black,
        )

    }

}
@Composable
fun headerImage(){
    Box(modifier = Modifier
        .fillMaxWidth()
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription ="Logo", modifier = Modifier.size(
            250.dp
        ) )
        Image(painter = painterResource(id = R.drawable.logoheader), contentDescription ="Logo", modifier = Modifier
            .size(
                250.dp
            )
            .padding(top = 120.dp, start = 30.dp) )
    }
}