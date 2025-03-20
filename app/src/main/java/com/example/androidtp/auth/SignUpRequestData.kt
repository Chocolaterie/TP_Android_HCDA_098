package com.example.androidtp.auth

data class SignUpRequestData(var email: String = "tinkyWinky@gmail.com",
                        var password : String = "password",
                        var passwordConfirm : String = "password",
                        var pseudo : String = "User",
                        var cityCode : String = "44000",
                        var city : String = "Nantes",
                        var phone : String = "0600000000",
    ) {
}