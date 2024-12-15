package com.example.expensetracker

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun AddExpense() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (nameRow, list, card, topBar) = createRefs()
            Image(painter = painterResource(id = R.drawable.background),
                contentDescription = null,
                modifier = Modifier.constrainAs(topBar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })

            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 20.dp, end = 20.dp)
                .constrainAs(nameRow) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
                Text(
                    text = "Add Expense",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(18.dp).align(Alignment.Center)
                )
                Image(
                    painter = painterResource(id = R.drawable.menu2), contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
            DataForm(modifier = Modifier.padding(top = 60.dp).constrainAs(card) {
                top.linkTo(nameRow.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        }
    }
}


@Composable
fun DataForm(modifier: Modifier){

    Column(modifier = modifier
        .padding(16.dp)
        .fillMaxWidth()
        .shadow(20.dp)
        .clip(RoundedCornerShape(18.dp))
        .background(Color.LightGray)
        .padding(16.dp)
        .height(400.dp)
    ) {
        Text(text = "Name", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(value = "" , onValueChange = {},modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Amount", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(value = "" , onValueChange = {},modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Date", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(value = "" , onValueChange = {},modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = {  },
            modifier = Modifier
                .clip(RoundedCornerShape(2.dp))
                .fillMaxWidth()) {
            Text(
                text = "Add Expense",
                fontSize = 14.sp,
                color = Color.White,
            )
            }
        }
    }



@Composable
@Preview(showBackground = true)
fun AddExpensePreview(){
    AddExpense()
}