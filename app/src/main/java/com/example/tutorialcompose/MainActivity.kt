package com.example.tutorialcompose

import android.annotation.SuppressLint
import android.content.ClipData
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.content.res.ResourcesCompat
import com.example.tutorialcompose.ui.theme.TutorialComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorialComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(

                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.error
                ) {
                    ScaffoldDemo()


                }

            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewWrite() {
    Write("Android")
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldDemo() {
    val materialBlue700= Color(0xFF1976D2)
    val materialRed = MaterialTheme.colors.error
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
    Scaffold(
        scaffoldState = scaffoldState,


        topBar =
        {
            TopAppBar(title = {Text("Items App")},backgroundColor = materialRed )
        },


        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton =
        {
            FloatingActionButton(onClick = {})
            {
            Text("X")
            }
        },


        drawerContent =
        {
            Text(text = "drawerContent")

        },


        content =
        {
            var item = " "
        ScrollBoxes(item)
        },


        bottomBar =
        {
            BottomAppBar(
                backgroundColor = materialBlue700,
                modifier = Modifier
                    .pointerInput(Unit) {
                    detectTapGestures(
                        onPress =
                        { /* Called when the gesture starts */

                        },
                        onDoubleTap =
                        { /* Called on Double Tap */

                        },
                        onLongPress =
                        { /* Called on Long Press */

                        },
                        onTap =
                        { /* Called on Tap */

                        }
                    )
                }
            )
            {
                Text("BottomAppBar")
            }
        }
    )
}


@Composable
fun ScrollBoxes(item: String) {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(state = rememberScrollState())
    ) {
        var i = item
        repeat(100) {
            Text("$i $it", modifier = Modifier.padding(2.dp))
            BorderStroke(Dp.Hairline, Color.Black)

        }
    }
}

@Composable
fun Write(TEXT: String){
    Text(text = TEXT)
}
/*
Spacer(modifier = Modifier.height(90.dp))
Row(
modifier  = Modifier
.height(9.dp)
.background(Color.Red),
horizontalArrangement =  Arrangement.Center,
verticalAlignment = Alignment.Top
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()

            .background(Color.Black)
            .absolutePadding(0.dp, 100.dp, 0.dp, 0.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Write(TEXT = "Change the world")
        Row(
            modifier  = Modifier
                .height(90.dp)
                .background(Color.Blue),
            horizontalArrangement =  Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Write(TEXT = "My final message")

        }

    }
}
*/
