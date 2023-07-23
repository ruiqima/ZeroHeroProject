package com.example.demoproject.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoproject.model.CardContentItem
import com.example.demoproject.model.UserInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.io.File
import java.util.Random


class EventsViewModel : ViewModel() {

    private var _isInMainUI = MutableLiveData<Boolean>(false)
    val isInMainUI: LiveData<Boolean>
        get() = _isInMainUI
    var singleSelectedChipLabel: String by mutableStateOf("")
        private set

    private val _showBottomBarState = MutableStateFlow(false)
    val showBottomBarState: StateFlow<Boolean> get() = _showBottomBarState

    var userName: String by mutableStateOf("")
        private set

    var password: String by mutableStateOf("")
        private set

    var eventTitle: String by mutableStateOf("")
        private set

    var eventContent: String by mutableStateOf("")
        private set

    var selectedListSize: Int by mutableIntStateOf(0)
        private set

    var multiSelectedChipLabelList = MutableLiveData<List<String>>(emptyList())
        private set

    val user = UserInfo(
        name = "Ruiqi Ma",
        team = "StoryMaps",
        avatarImageName = "avatar.png",
        backgroundImageName = "img2.png"
    )

    private val recommendationCardContentList: List<CardContentItem> = listOf(
        CardContentItem(
            title = "Nature Lovers Picnic",
            content = "Embrace Green Picnics!",
            imageName = "img3.png"
        ),
        CardContentItem(
            title = "Composting Workshop",
            content = "Turn Waste into Gold!",
            imageName = "img9.jpg"
        ), CardContentItem(
            title = "Biking instead of Driving",
            content = "Join for a mountain biking",
            imageName = "img7.jpeg"
        ), CardContentItem(
            title = "ZeroHeroes Clean-Up Day",
            content = "be a waste-free warrior",
            imageName = "img6.jpeg"
        ), CardContentItem(
            title = "Eco-Friendly Expo",
            content = "Discover Sustainable Solutions",
            imageName = "img5.jpeg"
        ), CardContentItem(
            title = "Green Living Fair",
            content = "Recycle, Reuse, Reduce!",
            imageName = "img4.jpeg"
        ), CardContentItem(
            title = "Eco-Chic Fashion Show",
            content = "Strut the Eco-Chic Way",
            imageName = "img8.png"
        )
    )

    var cardContentList = MutableLiveData(recommendationCardContentList)
        private set

    val cardContentListSize = MutableLiveData(cardContentList.value!!.size)

    val activityTypes = listOf(
        "Nature Noshing",
        "Waste Warriors",
        "Upcycle Palooza",
        "Compost Champions",
        "Canopy Crusaders",
        "Marvelous Market",
        "Stream Safari",
        "Move Mitigation",
        "Litter Quest",
        "Beach Beautification"
    )

    val availableImageList = listOf(
        "img3.png",
        "img4.jpeg",
        "img5.jpeg",
        "img6.jpeg",
        "img7.jpeg",
        "img8.png",
        "img9.jpg",
        "img10.jpg",
        "img11.jpg"
    )

    fun fileNameToPath(context: Context, fileName: String): String {
        return File(context.filesDir, fileName).absolutePath
    }

    fun updateSingleSelectedChipLabel(label: String) {
        singleSelectedChipLabel = label
    }

    fun addToMultiSelectedChipLabelList(label: String) {
        val currentList = multiSelectedChipLabelList.value!!.toMutableList()
        currentList.add(label)
        multiSelectedChipLabelList.value = currentList
        selectedListSize += 1
    }

    fun removeFromMultiSelectedChipLabelList(label: String) {
        val currentList = multiSelectedChipLabelList.value!!.toMutableList()
        currentList.remove(label)
        multiSelectedChipLabelList.value = currentList
        selectedListSize -= 1
    }

    fun isContainingLabel(label: String): Boolean {
        return multiSelectedChipLabelList.value!!.contains(label)
    }

    fun updateIsInMainUI(value: Boolean) {
        _isInMainUI.value = value
    }

    fun updateUserName(name: String) {
        userName = name
    }

    fun updatePassword(text: String) {
        password = text
    }

    fun updateEventTitle(name: String) {
        eventTitle = name
    }

    fun updateEventContent(text: String) {
        eventContent = text
    }

    fun chooseRandomImageFromList(): String {
        val random = Random()
        return availableImageList[random.nextInt(availableImageList.size)]
    }

    fun addToCardContentList(item: CardContentItem) {
        val previousList = cardContentList.value!!.toList()
        val mutableList = previousList.toMutableList()
        mutableList.add(0, item)
        cardContentList.value = mutableList
        cardContentListSize.value = cardContentListSize.value?.plus(1)
    }


}