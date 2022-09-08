package ir.esen.myapplication.helper

object TokenContainer {
    var token:String? = null

    private set

    fun updateToken(token:String?){
        TokenContainer.token = token
    }



    var code:Int? = null

        private set

    fun updateCode(code:Int?){
        TokenContainer.code = code
    }
}