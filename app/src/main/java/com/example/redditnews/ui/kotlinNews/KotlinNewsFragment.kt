package com.example.redditnews.ui.kotlinNews

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.redditnews.Constants.DATA_OF_ARTICLE
import com.example.redditnews.Constants.TITLE_OF_ARTICLE
import com.example.redditnews.R
import com.example.redditnews.adapters.NewsRecyclerAdapter
import com.example.redditnews.databinding.FragmentKotlinNewsBinding
import com.example.redditnews.pojo.Data
import com.example.redditnews.ui.articleDetails.ArticleDetailsFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [KotlinNewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class KotlinNewsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    private lateinit var binding : FragmentKotlinNewsBinding
    private val viewModel : KotlinNewsViewModel by lazy { ViewModelProvider(this)[KotlinNewsViewModel::class.java] }
    private val newsRecyclerAdapter : NewsRecyclerAdapter by lazy { NewsRecyclerAdapter() }
    private var job : Job ?= null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.Kotlin_News) //Change Title Of Action Bar
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_kotlin_news, container, false) //Initialize binding
        binding.lifecycleOwner = this   //Set lifecycleOwner
        binding.viewModel = viewModel   //Set Variable Of ViewModel (DataBinding)

        setOnClickOnRecyclerItem()      //Set On Click On Any Item Of Recycler


        return binding.root
    }

    private fun setOnClickOnRecyclerItem() {
        newsRecyclerAdapter.setOnItemClickListener(object : NewsRecyclerAdapter.OnClickOnItem{
            override fun onClick1(data: Data) {
                //Pass Data Of Article To ArticleDetailsFragment
                val args = Bundle()
                args.putParcelable(DATA_OF_ARTICLE, data)
                args.putString(TITLE_OF_ARTICLE,data.title)
                val articleDetailsFragment = ArticleDetailsFragment()
                articleDetailsFragment.arguments = args
                activity!!.supportFragmentManager.beginTransaction().replace(R.id.flFragment, articleDetailsFragment).addToBackStack(null).commit()
            }
        })
    }

    override fun onResume() {
        super.onResume()
        render()      //Render States
    }

    override fun onPause() {
        job?.cancel() //Cancel Job
        super.onPause()

    }

    private fun render() {
      job = lifecycleScope.launchWhenStarted {
          viewModel.states.collect{
              when(it){
                is KotlinNewsViewStates.Success ->{
                    it.listOfItems?.let { list ->
                        newsRecyclerAdapter.setList(list)                               //Set List To Adapter
                        binding.recyclerKotlinNewsFragment.adapter = newsRecyclerAdapter//Set Adapter To Recycler
                    }
                }
                is KotlinNewsViewStates.Error -> {
                    Log.d(TAG, "renderError: ${it.error}")
                    Toast.makeText(context,getString(R.string.No_Internet_Connection),Toast.LENGTH_SHORT).show()
                    viewModel.getNewsFromDataBase() //Get News From Room DataBase
                }
                else -> {}
              }

          }
       }
    }

    companion object {
        private const val TAG = "KotlinNewsFragment"
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment KotlinNewsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            KotlinNewsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}