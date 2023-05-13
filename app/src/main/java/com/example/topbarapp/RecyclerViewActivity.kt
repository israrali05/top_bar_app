package com.example.topbarapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.topbarapp.utiles.DataSource
import com.example.topbarapp.utiles.DumpyData

class RecyclerViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colorScheme.background) {
                RecyclerView(data = DumpyData())
            }
        }
    }

    @Composable
    fun EachRow(user: DataSource) {
        Card(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(CornerSize(10.dp)),

            ) {
            Row(modifier = Modifier.padding(5.dp)) {
                Image(
                    painterResource(id = R.drawable.profile),
                    "image",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(8.dp)
                        .align(Alignment.CenterVertically)
                        .clip(RoundedCornerShape(CornerSize(10.dp)))
                )
                Text(text = user.description, modifier = Modifier.padding(8.dp))
            }
        }
    }
    @Composable

    fun RecyclerView(data: List<DataSource>){
        LazyColumn{
            items(data){
                user -> EachRow(user)
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview(
    ) {
        RecyclerView(data = DumpyData())
    }

}
