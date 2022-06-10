package com.silvacomp.bottomsheet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.silvacomp.bottomsheet.ui.theme.BottomSheetTheme
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomSheetTheme {
                val sheetSheet = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
                val scaffoldState = rememberBottomSheetScaffoldState(
                    bottomSheetState = sheetSheet
                )
                val scope = rememberCoroutineScope()
                BottomSheetScaffold(sheetContent = {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)){
                        Text(text = "Bottom Sheet", fontSize = 60.sp)
                    }
                },
                    sheetBackgroundColor = Color.Green,
                    scaffoldState = scaffoldState
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center) {
                        Button(onClick = {
                            scope.launch {
                                if(sheetSheet.isCollapsed){
                                    sheetSheet.expand()
                                }else{
                                    sheetSheet.collapse()
                                }
                            }
                        }) {
                            Text(text = "Toogle Sheet")
                        }
                    }
                }
            }
        }
    }
}
