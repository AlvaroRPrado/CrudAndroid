package com.prado.crudroom.ui.subscriberlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.prado.crudroom.R
import com.prado.crudroom.data.db.entity.SubscriberEntity
import com.prado.crudroom.databinding.FragmentSubscriberListBinding

class SubscriberListFragment : Fragment(R.layout.fragment_subscriber_list) {

    private lateinit var viewModel: SubscriberListViewModel
    private lateinit var binding: FragmentSubscriberListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSubscriberListBinding.bind(view)

        val subscriberListAdapter = SubscriberListAdapter(
            listOf(
                SubscriberEntity(1, "Alvaro", "alvaro@alvaro.com"),
                SubscriberEntity(2, "Diogo", "diogo@diogo.com")
            )
        )
        with(binding.recyclerSubscribers) {
            setHasFixedSize(true)
            adapter = subscriberListAdapter
        }

    }

}