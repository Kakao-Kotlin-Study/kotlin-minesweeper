package domain;

data class Width(val value : Int) {
    companion object{
        private const val MIN_WIDTH = 0
    }

    init {
        if(value < MIN_WIDTH){
            throw IllegalArgumentException("Height must be greater than $MIN_WIDTH."); // TODO : 상수화
        }
    }
}
