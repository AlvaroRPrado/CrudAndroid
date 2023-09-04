package com.prado.crudroom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.prado.crudroom.ui.subscriber.SubscriberViewModel

class SubscriberFragment : Fragment() {

    class SubscriberFragment : Fragment() {

        private lateinit var viewModel: SubscriberViewModel

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.fragment_subscriber, container, false)
        }
    }

}