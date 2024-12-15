package com.example.expensetracker



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension


@Composable
fun HomeScreen() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .fillMaxWidth()) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (nameRow, list, card, topBar) = createRefs()
            Image(painter = painterResource(id = R.drawable.background),
                contentDescription = null,
                modifier = Modifier.constrainAs(topBar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, start = 16.dp, end = 16.dp)
                    .constrainAs(nameRow) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)

                    }) {
                Column {
                    Text(
                        text = "Good Afternoon",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White )
                    Text(
                        text = "Emily",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                        )
                    }
                Image(
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = null
                )
            }
            CardItem(modifier = Modifier
                .constrainAs(card) {
                    top.linkTo(nameRow.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
            TransactionList(modifier = Modifier.fillMaxWidth().constrainAs(list) {
                top.linkTo(card.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                height = Dimension.fillToConstraints
            })
        }
    }
}


@Composable
fun CardItem(modifier: Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.LightGray)
            .padding(16.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth().weight(1f))
        Column {
            Text(text = "Total Balance", fontSize = 16.sp, color = Color.Black)
            Text(
                text = "$ 2,534",
                fontSize = 16.sp,
                color = Color.Black
            )
        }

        Image(
            painter = painterResource(id = R.drawable.menu),
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(8.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.fillMaxWidth().weight(1f))
            Column {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.arrowup),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(text = "Income", fontSize = 16.sp, color = Color.Black)
                }
                Text(text = "$ 545", fontSize = 16.sp, color = Color.Black)
            }
            Spacer(modifier = Modifier.size(8.dp))
            Column(modifier = Modifier) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.arrowdown),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(text = "Expense", fontSize = 16.sp, color = Color.Black)
                }
                Text(text = "$ 201", fontSize = 16.sp, color = Color.Black)
            }
        }
    }
}


@Composable
fun TransactionList(modifier: Modifier) {
    Column(modifier = modifier.padding(horizontal = 18.dp)) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Recent Transactions", fontSize = 30.sp)
            Text(modifier = Modifier.align(CenterEnd),
                text = "See All",
                fontSize = 18.sp,
                color = Color.Black
            )
        }
        TransactionItem(
            title = "Shopping",
            amount = "- $78.00",
            icon = R.drawable.spent,
            date = "Today",
            color = Color.Red
        )
        TransactionItem(
            title = "Paycheck",
            amount = "+ $500.00",
            icon = R.drawable.income,
            date = "Today",
            color = Color.Green

        )
    }
}
@Composable
fun TransactionItem(title: String, amount: String, icon: Int, date: String, color: Color){
    Box(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Row {
            Image(
                painter = painterResource(id = icon), contentDescription = null,
                modifier = Modifier.size(42.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Column {
                Text(text = title, fontSize = 18.sp)
                Text(text = date, fontSize = 14.sp)
            }
        }
        Text(
            text = amount,
            fontSize = 18.sp,
            modifier = Modifier.align(CenterEnd),
            color = color
        )
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}
