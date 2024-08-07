package com.lucas.audioplayer.screens

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import com.lucas.audioplayer.R

@Composable
fun AudioPlayer(context: Context) {

    var player = remember {
        mutableStateOf(MediaPlayer.create(context, R.raw.music))
    }

    Box(contentAlignment = Alignment.Center) {
        Row() {

            IconButton(
                onClick = {
                    if(player.value == null){
                        player.value = MediaPlayer.create(context, R.raw.music)
                    }
                    player.value.start()
                }
            ){
                Icon(
                    painter = painterResource(id = R.drawable.play),
                    contentDescription = ""
                )
            }

            IconButton(
                onClick = {
                    player.value.pause()
                }
            ){
                Icon(
                    painter = painterResource(id = R.drawable.pause),
                    contentDescription = ""
                )
            }

            IconButton(
                onClick = {
                    player.value.stop()
                    player.value.reset()
                    player.value.release()
                    player.value = null
                }
            ){
                Icon(
                    painter = painterResource(id = R.drawable.stop),
                    contentDescription = ""
                )
            }

        }
    }
}