package com.example.redditnews.ui.articleDetails

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.redditnews.Constants.TITLE_OF_ARTICLE
import com.example.redditnews.R
import com.example.redditnews.databinding.FragmentArticleDetailsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ArticleDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArticleDetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var titleOfArticle : String?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            titleOfArticle = it.getString(TITLE_OF_ARTICLE)
            (activity as AppCompatActivity).supportActionBar?.title = titleOfArticle //Change Title Of Action Bar
        }
    }
    private lateinit var binding : FragmentArticleDetailsBinding
    private val viewModel : ArticleDetailsViewModel by lazy { ViewModelProvider(this)[ArticleDetailsViewModel::class.java] }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_article_details, container, false) //Initialize binding
        binding.lifecycleOwner = this   //Set lifecycleOwner
        binding.viewModel = viewModel   //Set Variable Of ViewModel (DataBinding)
        binding.articleBodyArticleDetails.movementMethod = ScrollingMovementMethod() //Set Movement Method To TextView
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ArticleDetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ArticleDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}