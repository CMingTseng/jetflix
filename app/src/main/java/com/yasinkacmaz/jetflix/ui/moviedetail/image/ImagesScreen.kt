package com.yasinkacmaz.jetflix.ui.images

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.transform.BlurTransformation
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.imageloading.ImageLoadState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.yasinkacmaz.jetflix.R
import com.yasinkacmaz.jetflix.ui.moviedetail.image.Image

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImagesScreen(images: List<Image>) {
    if (images.isNotEmpty()) {
        val pagerState = rememberPagerState(pageCount = images.size)
        HorizontalPager(state = pagerState) { page ->
            Image(images[page])
        }
    }
}

@Composable
private fun Image(image: Image) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        BlurImage(image)
        Card(
            Modifier
                .padding(12.dp)
                .shadow(16.dp, RoundedCornerShape(12.dp))
                .animateContentSize()
        ) {
            Box {
                Poster(image)
                VoteCount(image.voteCount)
            }
        }
    }
}

@Composable
private fun BlurImage(image: Image) {
    val context = LocalContext.current
    val blurTransformation = remember { BlurTransformation(context = context, radius = 12f, sampling = 4f) }
    Image(
        painter = rememberCoilPainter(
            request = image.url,
            requestBuilder = { transformations(blurTransformation) },
        ),
        contentDescription = stringResource(id = R.string.poster_content_description),
        contentScale = ContentScale.FillHeight,
        modifier = Modifier
            .fillMaxSize()
            .alpha(alpha = 0.80f)
    )
}

@Composable
private fun BoxScope.Poster(image: Image) {
    val painter = rememberCoilPainter(request = image.url)
    if (painter.loadState is ImageLoadState.Loading) {
        CircularProgressIndicator(
            Modifier
                .size(240.dp)
                .padding(16.dp)
        )
    } else {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.Companion
                .align(Alignment.Center)
                .fillMaxWidth()
                .wrapContentHeight()
        )
    }
}

@Composable
private fun BoxScope.VoteCount(voteCount: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentSize()
            .align(Alignment.BottomStart)
            .background(
                color = MaterialTheme.colors.surface.copy(alpha = 0.35f),
                shape = RoundedCornerShape(bottomStart = 12.dp, topEnd = 12.dp)
            )
            .padding(4.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Favorite,
            tint = MaterialTheme.colors.primary,
            contentDescription = stringResource(id = R.string.likes_content_description),
            modifier = Modifier.padding(end = 4.dp)
        )
        Text(text = voteCount.toString(), style = MaterialTheme.typography.body2)
    }
}
