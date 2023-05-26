package com.example.taskmanager.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskmanager.Model.Task
import com.example.taskmanager.R
import com.example.taskmanager.databinding.FragmentHomeBinding
import com.example.taskmanager.ui.Task.TaskFragment

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding

    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var taskAdapter: TaskAdapter
    private val arrayList= ArrayList<Task>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        taskAdapter = TaskAdapter(arrayList)
        binding.taskRecyclerView.adapter = taskAdapter


        setFragmentResultListener(TaskFragment.RESULT_REQUEST){_ ,bundle->
            val data  = bundle.getSerializable(TaskFragment.RESULT_KEY ) as Task
            Log.e("tag","onViewCreated: " + data)
            arrayList.add(data)
        }
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)

        }
    }

    fun onTaskClick(task: Task) {
        // Обработка нажатия на элемент списка
        // Здесь вы можете реализовать необходимую логику для обработки нажатия на элемент списка
        // Например, удаление задачи из списка или выполнение других действий
        // Пример удаления задачи из списка:
    }
}