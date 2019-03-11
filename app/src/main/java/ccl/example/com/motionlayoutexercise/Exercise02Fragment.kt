package ccl.example.com.motionlayoutexercise

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Exercise02Fragment : Fragment() {

    companion object {
        fun newInstance() = Exercise02Fragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_exercise02, container, false)
    }
}
