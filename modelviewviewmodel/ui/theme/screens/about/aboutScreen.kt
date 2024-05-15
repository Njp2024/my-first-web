package com.example.modelviewviewmodel.ui.theme.screens.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.modelviewviewmodel.R
import com.example.modelviewviewmodel.navigation.ROUTE_LOGIN
@Composable
fun background() {
    Box(modifier = Modifier.
    fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.about),
            contentDescription = "Background image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.height(600.dp))
    }
}

@Composable
fun AboutScreen(navController: NavHostController) {
    background()
    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()

        ){
            Text(text = "ABOUT SCREEN", color = Color.Red )


        }



        Spacer(modifier = Modifier.height(500.dp))
        Button(onClick = { navController.navigate(ROUTE_LOGIN)},colors = ButtonDefaults.buttonColors(Color.Red)) {
            Text(text ="To login Screen")
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AboutScreenPreview(){
    AboutScreen(rememberNavController())

}