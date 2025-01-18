package com.myowencode.primaryclass.fragments.update

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.myowencode.primaryclass.R
import com.myowencode.primaryclass.db.PrimaryClassDatabase
import java.util.Calendar

class UpdateStudentFragment : Fragment() {

    private val args by navArgs<UpdateStudentFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update_student, container, false)

        val student = args.currentStudent

        view.findViewById<EditText>(R.id.first_name).setText(student.firstName)
        view.findViewById<EditText>(R.id.last_name).setText(student.lastName)
        val picker = view.findViewById<DatePicker>(R.id.birthday_picker)
        if (student.birthDate != null) {
            val c : Calendar = Calendar.getInstance()
            c.time = student.birthDate!!
            picker.updateDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH))
        }

        var gender = R.id.female
        if (student.gender.equals(PrimaryClassDatabase.GENDER_MALE)) {
            gender = R.id.male
        }
        view.findViewById<RadioGroup>(R.id.gender).check(gender)

        return view
    }

}