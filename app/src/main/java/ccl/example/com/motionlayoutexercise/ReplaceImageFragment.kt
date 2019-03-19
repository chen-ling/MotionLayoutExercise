package ccl.example.com.motionlayoutexercise

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ReplaceImageFragment : Fragment() {

    companion object {
        fun newInstance() = ReplaceImageFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_replace_image, container, false);
    }

}
