package org.basic.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kmpbasico.composeapp.generated.resources.Res
import kmpbasico.composeapp.generated.resources.compose_multiplatform

@Composable
fun App() {
    Navigator(
        screen = Mainscreen()
    )
}

class Mainscreen : Screen {
    @Composable
    override fun Content() {
        val navigator: Navigator = LocalNavigator.currentOrThrow
        var name: String by remember { mutableStateOf("") }
        var marcos: String by remember { mutableStateOf("") }
        Column(modifier = Modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .safeContentPadding()
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            TextField(
                value = name,
                onValueChange = {
                    name = it
                }


            )
            Spacer(modifier = Modifier.height(40.dp))

            AnimatedVisibility(name.isNotEmpty()){
                Text(
                    text = "Version Animada $name",
                    fontSize = 24.sp

                )
            }
            Spacer(modifier = Modifier.height(40.dp))

            TextField(
                value = marcos,
                onValueChange = {
                    marcos = it
                }


            )
            Spacer(modifier = Modifier.height(180.dp))

            AnimatedVisibility(marcos.isNotEmpty()){
                Text(
                    text = "Version Animada $marcos",
                    fontSize = 38.sp

                )
            }
            Spacer(modifier = Modifier.height(180.dp))

            Button(
                onClick = {
                    navigator.push(Secondscreen())
                    }
                ) {
                Text(
                    text = "Navegando"
                )

            }
        }
    }

}

class Secondscreen : Screen {
    @Composable
    override fun Content() {

        val navigator : Navigator = LocalNavigator.currentOrThrow
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                "Segunda Pantalla",
                fontSize = 20.sp,
                color = Color.Black
            )

            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            Button(
                onClick = {
                    navigator.pop()
                }
            ) {
                Text(
                    text = "Vamos para atrás"
                )
            }
        }

    }
}





