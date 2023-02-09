package domain;

data class Height(val value : Int) {
    companion object{
        private const val MIN_HEIGHT = 0
    }

    init {
        if(value < MIN_HEIGHT){
            throw IllegalArgumentException("Height must be greater than $MIN_HEIGHT.");
        }
    }
}
