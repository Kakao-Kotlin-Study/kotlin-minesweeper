package view

import domain.Field

object Out {

    fun printHeightRequest() {
        println("높이를 입력해주세요 : ")
    }

    fun printWidthRequest() {
        println("너비를 입력해주세요 : ")
    }

    fun printCountRequest() {
        println("지뢰 개수를 입력해주세요 : ")
    }

    fun printMine(field: Field) {
        println(field.getRowString())
    }

}