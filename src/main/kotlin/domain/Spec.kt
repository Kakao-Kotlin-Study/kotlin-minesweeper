package domain

class Spec(private val height: Height, private val width: Width, private val count: Count) {

    fun makeField(): Field {
        // 모두 안전한 밭
        val safeField = height.makeSafeField(width)
        // 랜덤하게 좌표 count만큼 생성
        val coords: Coordinates = count.makeRandomCoordinates()
        // 모든 좌표에 대해서 지뢰 심어 반환
        return coords.layMines(safeField)
    }

}