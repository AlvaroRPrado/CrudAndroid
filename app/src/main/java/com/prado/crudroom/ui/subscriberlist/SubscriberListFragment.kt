package com.prado.crudroom.ui.subscriberlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.prado.crudroom.R
import com.prado.crudroom.data.db.AppDatabase
import com.prado.crudroom.databinding.FragmentSubscriberListBinding
import com.prado.crudroom.extension.navigateWithAnimations
import com.prado.crudroom.repository.DatabaseDataSource
import com.prado.crudroom.repository.SubscriberRepository

class SubscriberListFragment : Fragment(R.layout.fragment_subscriber_list) {

    private lateinit var binding: FragmentSubscriberListBinding
    private val viewModel: SubscriberListViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val subscriberDao = AppDatabase.getInstance(requireContext()).subscriberDAO
                val repository: SubscriberRepository = DatabaseDataSource(subscriberDao)
                return SubscriberListViewModel(repository) as T
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSubscriberListBinding.bind(view)

        observeViewModelEvents()
        configureViewListeners()

    }

    private fun observeViewModelEvents() {

        viewModel.allSubscribersEvent.observe(viewLifecycleOwner){allSubscibers->
            val subscriberListAdapter = SubscriberListAdapter(allSubscibers).apply {
                onItemClick = { subscriber ->
                    val directions = SubscriberListFragmentDirections
                        .actionSubscriberListFragmentToSubscriberFragment(subscriber)

                    findNavController().navigateWithAnimations(directions)
                }
            }

            with(binding.recyclerSubscribers){
                setHasFixedSize(true)
                adapter = subscriberListAdapter
            }

        }






    }

    override fun onResume() {
        super.onResume()
        viewModel.getSubscribers()
    }
    private fun configureViewListeners() {
        binding.fabAddSubscriber.setOnClickListener {
            findNavController().navigate(R.id.action_subscriberListFragment_to_subscriberFragment)
        }
    }

}