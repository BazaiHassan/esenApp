package ir.esen.myapplication.profile

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.gson.JsonObject
import ir.esen.myapplication.R
import ir.esen.myapplication.animations.auth.dataModel.ResponseAuthUser
import ir.esen.myapplication.animations.auth.viewModel.AuthUserViewModel
import ir.esen.myapplication.animations.auth.viewModel.CheckUserViewModel
import ir.esen.myapplication.animations.dataModel.ResponseAnimation
import ir.esen.myapplication.helper.TokenContainer
import kotlinx.android.synthetic.main.bottom_sheet_verify.*
import kotlinx.android.synthetic.main.user_login_false.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val authUserViewModel: AuthUserViewModel by viewModel()
    private val checkUserViewModel: CheckUserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //checkUserViewModel.checkUserLogin()
        btn_login.setOnClickListener {
            if (edt_login_phone.text.toString() == "") {
                edt_login_phone.error = "شماره موبایل را وارد کنید"
            } else {
                progress_code_send.visibility = View.VISIBLE
                btn_login.visibility = View.GONE

                authUserViewModel.authUserViewModel(edt_login_phone.text.toString())
                showDialog()

            }
        }

    }


    private fun showDialog() {

        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottom_sheet_verify)

        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        dialog.window!!.attributes.windowAnimations = R.style.DialogAnimation
        dialog.window!!.setGravity(Gravity.BOTTOM)
        dialog.setCancelable(false)
        dialog.show()
        dialog.btn_code_verify.setOnClickListener {
            authUserViewModel.authUserLiveData.observe(viewLifecycleOwner) {
                val userInputCode = dialog.txt_verify_code_bs.text.toString().toInt()
                if (userInputCode == it.code){
                    Toast.makeText(context,"Logged In",Toast.LENGTH_LONG).show()
                    replaceFragments(ProfileFragment())
                    //TODO: Token should be saved into sharedPref.
                    dialog.dismiss()
                }else{
                    Toast.makeText(context,"کد وارد شده اشتباه است.",Toast.LENGTH_LONG).show()

                }
            }
        }

        dialog.btn_close_bs_verification.setOnClickListener {
            dialog.dismiss()
        }


    }

    private fun replaceFragments(fragment: Fragment) {
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.nav_host_fragment, fragment)
        fragmentTransaction?.commit()
    }
}