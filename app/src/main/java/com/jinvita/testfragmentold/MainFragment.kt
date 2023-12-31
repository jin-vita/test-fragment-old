package com.jinvita.testfragmentold

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jinvita.testfragmentold.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var listener: FragmentListener? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? FragmentListener ?: throw RuntimeException("$context must implement FragmentListener")
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnFirst.setOnClickListener { listener?.replaceFragment(requireActivity(), FirstFragment()) }
            btnSecond.setOnClickListener { listener?.replaceFragment(requireActivity(), SecondFragment()) }
        }
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}