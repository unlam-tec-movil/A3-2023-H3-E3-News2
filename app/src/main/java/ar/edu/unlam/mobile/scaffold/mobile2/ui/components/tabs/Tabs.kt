package ar.edu.unlam.mobile.scaffold.mobile2.ui.components.tabs

import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import ar.edu.unlam.mobile2.Tabs.repository.Tabs_item
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(tabs: List<Tabs_item>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                color = MaterialTheme.colorScheme.primary,
            )
        },
        backgroundColor = MaterialTheme.colorScheme.background,
    ) {
        tabs.forEachIndexed { index, tabsItem ->
            Tab(
<<<<<<<< HEAD:app/src/main/java/ar/edu/unlam/mobile/scaffold/mobile2/ui/components/tabs/Tabs.kt
                selected = pagerState.currentPage == index,
                onClick = { scope.launch { pagerState.animateScrollToPage(index) } },
                text = { Text(tabsItem.title, color = MaterialTheme.colorScheme.tertiary) },
            )

            /*
            LeadingIconTab(
                selected = pagerState.currentPage == index,
                onClick = { scope.launch { pagerState.animateScrollToPage(index) } },
                icon = {
                    Icon(
                        painter = painterResource(id = tabsItem.icon),
                        contentDescription = "",

                        )
                },
                text = { Text(tabsItem.title) })*/
        }
    }
}
========
                selected = pagerState.currentPage == index,
                onClick = { scope.launch { pagerState.animateScrollToPage(index) } },
                text = { Text(tabsItem.title, color = MaterialTheme.colorScheme.tertiary) },
            )
        }
    }
}
/*
           LeadingIconTab(
               selected = pagerState.currentPage == index,
               onClick = { scope.launch { pagerState.animateScrollToPage(index) } },
               icon = {
                   Icon(
                       painter = painterResource(id = tabsItem.icon),
                       contentDescription = "",

                       )
               },
               text = { Text(tabsItem.title) })*/
>>>>>>>> develop:app/src/main/java/ar/edu/unlam/mobile/scaffold/mobile2/Tabs/ui/Tabs.kt
