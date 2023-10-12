package ar.edu.unlam.mobile2.Tabs.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import ar.edu.unlam.mobile2.Tabs.repository.TabsItem

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun Tabs_content(tabs: List<TabsItem>, pagerState: PagerState) {
    HorizontalPager(state = pagerState, count = tabs.size) { page ->
        tabs[page].screen()
    }
}
