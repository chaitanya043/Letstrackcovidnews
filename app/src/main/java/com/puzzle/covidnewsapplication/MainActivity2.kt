package com.puzzle.covidnewsapplication

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest

class MainActivity2 : AppCompatActivity() {

    private lateinit var mAdaptor: NewsListAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val recyclerView: RecyclerView = findViewById(R.id.recyclerview2)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchData()
        mAdaptor = NewsListAdaptor(this)
        recyclerView.adapter = mAdaptor

    }

    fun fetchData(){
        val url = "https://saurav.tech/NewsAPI/top-headlines/category/health/in.json"
        val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET,url,null,
                Response.Listener {
                    val newsJsonArray = it.getJSONArray("articles")
                    val newsArray = ArrayList<News>()
                    for(i in 0 until newsJsonArray.length()){
                        val newsJsonObject = newsJsonArray.getJSONObject(i)
                        val news = News(
                                newsJsonObject.getString("title"),
                                newsJsonObject.getString("author"),
                                newsJsonObject.getString("url"),
                                newsJsonObject.getString("urlToImage")
                        )
                        newsArray.add(news)
                    }
                    mAdaptor.updateNews(newsArray)
                },
                Response.ErrorListener {

                }
        )
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }



    override fun ItemClick(items: News) {
        val builder = CustomTabsIntent.Builder();
        val customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(items.url));
    }


}


}
}