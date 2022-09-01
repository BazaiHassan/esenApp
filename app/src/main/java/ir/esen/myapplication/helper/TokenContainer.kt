package ir.esen.myapplication.helper

object TokenContainer {
    var token:String? = null

    private set

    fun updateToken(token:String?){
        TokenContainer.token = token
    }
}