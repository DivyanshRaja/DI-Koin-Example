package com.example.di_recyclerview.utils

object AppUtils {

    fun reverseString(input :String):String{

        var reversed= ""
        for(i in input.length-1 downTo 0){
            reversed += input[i]
        }
        return reversed
    }

    fun reverseWords(input:String):String{
        var words = ""
        val wordsArray = input.split(" ").toTypedArray()
        for(i in wordsArray.size-1 downTo 0){
            words = words + wordsArray[i] + " "
        }
        return words
    }


    fun findDulicatesCharFromString(input:String){
        for(i in input.indices){
            for(j in i+1 until input.length){
                if(input[i] == input[j]){
                    println(input[j])
                    break
                }
            }
        }
    }

    fun occurrencesCount(input:String){
        val charCountMap = input.groupingBy { it }.eachCount()
        // Print occurrences count of each character
        charCountMap.forEach { (char, count) ->
            println("'$char' occurs $count times")
        }
    }

    //  val array = intArrayOf(2,10,2,4,3,10)
    //
    //   val duplicates = findDuplicatesFromArray(array)
    //
    //   print("$duplicates ")

    fun findDuplicatesFromArray(inputArray: IntArray):Set<Int>{
        val uniqueArray  = HashSet<Int>()
        val duplicates  = HashSet<Int>()
        for(num in inputArray){
            if(!uniqueArray.add(num)){
                duplicates.add(num)
            }

        }
        print("Common Array $uniqueArray \n")
        return duplicates
    }

}