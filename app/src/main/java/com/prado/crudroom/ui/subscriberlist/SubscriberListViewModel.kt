package com.prado.crudroom.ui.subscriberlist

import androidx.lifecycle.ViewModel
import com.prado.crudroom.repository.SubscriberRepository

class SubscriberListViewModel(
    private val repository: SubscriberRepository
) : ViewModel() {
    val allSubscribersEvent = repository.getAllSubscribers()
}