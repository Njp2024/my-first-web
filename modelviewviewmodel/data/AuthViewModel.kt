package com.example.modelviewviewmodel.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.example.modelviewviewmodel.models.User
import com.example.modelviewviewmodel.navigation.ROUTE_HOME
import com.example.modelviewviewmodel.navigation.ROUTE_LOGIN
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.getInstance
import com.google.firebase.database.FirebaseDatabase

class AuthViewModel(var navController: NavController,var context: Context) {
    var mAuth:FirebaseAuth
    val progress:ProgressDialog

    init {
        mAuth= getInstance()
        progress= ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please Wait .....")

    }
    fun signup(email:String,pass:String,confpass:String){
       // progress.show()
        if (email.isBlank() ||pass.isBlank()|| confpass.isBlank()){
           // progress.dismiss()
            Toast.makeText(context,"Please email and password cannot be blank",Toast.LENGTH_LONG).show()
            return
        }else{
            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
                if (it.isSuccessful){
                    val userdata = User(email,pass)
                    val regref= FirebaseDatabase.getInstance().getReference()
                        .child("Users/"+mAuth.currentUser!!.uid)
                    regref.setValue(userdata).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(context,"Registered Successfully",Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_HOME)

                        }else{
                            Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_LOGIN)

                        }
                        //else{
                     //   navController.navigate(ROUTE_REGISTER)
                   // }
                    }
                }
            }
        }
    }

    private fun User(email: String, pass: String): User {
        TODO("Not yet implemented")
    }

    fun isloggedin(): Boolean {
        TODO("Not yet implemented")
    }
}