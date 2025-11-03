fun main() {
    val str = "A man, a plan, a canal: Panama"
    println("isValidPalindrome: ${isValidPalindrome(str)}")
    println("isValidpalindrome: ${isValidpalindrome1(str)}")
}

fun isValidpalindrome1(str:String):Boolean{
    val filderStr= str.filter{it.isLetterOrDigit()}.lowercase()
    return filderStr ==filderStr.reversed()
}

fun isValidPalindrome(str: String): Boolean {
    var left = 0
    var right = str.length - 1

    while (left < right) {
        // Move left pointer to next alphanumeric character
        while (left < right && !str[left].isLetterOrDigit()) left++
        // Move right pointer to previous alphanumeric character
        while (left < right && !str[right].isLetterOrDigit()) right--

        // Compare characters ignoring case
        if (str[left].lowercaseChar() != str[right].lowercaseChar()) {
            return false
        }

        left++
        right--
    }
    return true
}
