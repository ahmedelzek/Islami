package com.example.islami

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentSephaBinding

class SephaFragment : Fragment() {

    private lateinit var binding: FragmentSephaBinding
    private var texts = arrayListOf(
        ConstantValues.firstZikr,
        ConstantValues.secondZikr,
        ConstantValues.thirdZikr,
        ConstantValues.fourthZikr
    )
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSephaBinding.inflate(inflater, container, false)
        onClick()
        return binding.root
    }

    private fun changeZikrAndNumOfZikr() {
        counter++
        if (counter % 33 == 0) {
            val index = (counter / 33) % texts.size
            binding.sephaZikrTextView.text = texts[index]
        }
        val zikrCounter = counter.toString()
        binding.sephaCounterTextView.text = zikrCounter
    }

    private fun rotateImage() {
        binding.sephaBodyImage.rotation += 90f
    }

    private fun onClick() {
        binding.sephaZikrTextView.text = texts[0]
        binding.sephaBodyImage.setOnClickListener {
            rotateImage()
            changeZikrAndNumOfZikr()
        }
    }

}


