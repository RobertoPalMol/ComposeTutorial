package com.example.composetutorial


import android.content.res.Configuration
import android.os.Bundle
import android.provider.Telephony.Sms.Conversations
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items


data class Message(val author: String, val body: String)

@Composable
fun Conversation(messages: List<Message>){
    LazyColumn{
        items(messages){ message ->
            MessageCard(message)
        }
    }
}
@Preview
@Composable
fun PreviewConversation(){
    ComposeTutorialTheme {
        Conversation(SampleData.conversationSample)
    }
}
@Preview(name = "Ligth Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun MessageCard(msg: Message) {
    Row (modifier = Modifier.padding(all = 8.dp)){
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
            )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondaryContainer,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
    super.onCreate(savedInstanceState)
    setContent{
        ComposeTutorialTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                MessageCard(Message("Android", "Jetpack Compose"))
            }
        }

        }
    }
}
@Preview
@Composable
fun PreviewMessageCard() {
    ComposeTutorialTheme {
        Surface{
            MessageCard(msg = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!"))

        }
    }

}