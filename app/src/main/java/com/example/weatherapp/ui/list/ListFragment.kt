package com.example.weatherapp.ui.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.databinding.ListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.list_fragment.*

@AndroidEntryPoint
class ListFragment : Fragment(), WeatherListAdapter.Listener {

    private lateinit var viewModel: ListViewModel
    private lateinit var binding: ListFragmentBinding
    private lateinit var adapter: WeatherListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        initEditText()
        initRecyclerView()
        viewModel.weather.observe(viewLifecycleOwner, { weather ->
            adapter.submitList(weather)
            recyclerView.smoothScrollToPosition(weather.size)
        })
    }

    private fun initRecyclerView() {
        adapter = WeatherListAdapter(this)
        (binding.recyclerView.layoutManager as LinearLayoutManager).apply {
            reverseLayout = true;
            stackFromEnd = true;
        }
        binding.recyclerView.adapter = adapter
    }

    private fun initEditText() {
        binding.searchEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                viewModel.getWeatherOf(binding.searchEditText.text.toString())
                binding.searchEditText.text?.clear()
                (requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(view?.windowToken, 0)
                true
            } else {
                false
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getLocalWeathers()
    }

    override fun onItemSelected(id: Int) {
        findNavController().navigate(
            ListFragmentDirections.actionListFragmentToDetailsFragment(
                weatherId = id
            )
        )
    }
}