package view

import java.io.InputStream
import java.io.PrintStream
import java.util.*

class InputView(inputStream : InputStream
    , private val outputStream : PrintStream) {
    private val scanner : Scanner;

    init{
        scanner = Scanner(inputStream)
    }

    fun getMineMapHeight(): Int {
        outputStream.println("높이를 입력하세요.")
        return getInt()
    }

    fun getMineMapWidth(): Int {
        outputStream.println("너비를 입력하세요.")
        return getInt()
    }

    fun getMineNumbers(): Int {
        outputStream.println("지뢰는 몇 개 인가요?")
        return getInt()
    }

    private fun getInt() : Int{
        val value: Int;

        try {
            value = scanner.nextInt();
        } catch (e: Exception) {
            throw IllegalArgumentException("숫자를 입력해주세요.")
        }
        return value;
    }
}