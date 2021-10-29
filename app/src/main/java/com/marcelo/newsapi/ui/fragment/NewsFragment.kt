package com.marcelo.newsapi.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.marcelo.newsapi.R
import com.marcelo.newsapi.ui.adapter.NewsAdapter
import com.marcelo.newsapi.ui.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : Fragment(R.layout.main_fragment) {

    /*private val viewModel by viewModels<NewsViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {

                val newsApiDataSource = NewsRetrofitApiDataSource(this, WebApiAccess.serviceNews())
                //val newsApiDataSource = NewsFANApiDataSource()
                val newsRepository = NewsRepository(newsApiDataSource)

                return NewsViewModel(newsRepository) as T
            }
        }
    }*/

    private val viewModel: NewsViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.articlesEvent.observe(viewLifecycleOwner) { getNews ->
            with(recyclerArticles) {
                setHasFixedSize(true)
                adapter = NewsAdapter(getNews)
            }
        }

        viewModel.getNews()
    }

}
