package com.myowencode.primaryclass.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myowencode.primaryclass.R
import com.myowencode.primaryclass.db.StudentViewModel

class StudentListFragment : Fragment() {

    private lateinit var viewModel: StudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_student_list, container, false)
        view.findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.create_student_button).setOnClickListener {
            findNavController().navigate(R.id.action_studentListFragment_to_createStudentFragment)
        }

        val adapter = StudentListAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.student_recycler)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel = ViewModelProvider(this).get(StudentViewModel::class.java)
        viewModel.students.observe(viewLifecycleOwner, Observer { students ->
            adapter.setStudentList(students)
        })

        return view
    }
}