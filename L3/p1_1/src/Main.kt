class Birth(val year: Int, val Month: Int, val Day: Int){
    override fun toString() : String{
        return "($Day.$Month.$year)"
    }
}

class Contact(val Name: String, var Phone: String, val BirthDate: Birth){
    fun Print() {
        println("Name: $Name, Mobile: $Phone, Date: $BirthDate")
    }

}

fun Iterable<Contact>.findByName(name : String ): Contact? = find { it.Name == name }
fun Iterable<Contact>.updatePhoneNumber(name : String , newPhoneNumber : String): Contact?
{
    val contact = find{it.Name == name}
    contact?.Phone = newPhoneNumber
    return contact
}

fun main(args : Array<String>){
    val agenda = mutableListOf<Contact>()

    agenda.add(Contact("Mihai", "0744321987", Birth(1900, 11, 25)))
    agenda += Contact("George", "0761332100", Birth(2002, 3, 14))
    agenda += Contact("Liviu" , "0231450211", Birth(1999, 7, 30))
    agenda += Contact("Popescu", "0211342787", Birth(1955, 5, 12))
    for (persoana in agenda){
        persoana.Print()
    }
//    println("Agenda dupa eliminare contact [George]:")
//    agenda.removeAt(1)
//    for (persoana in agenda){
//        persoana.Print()
//    }
//    agenda.remove(Contact("Liviu" , "0231450211", Birth(1999, 7, 30)))
//    println("Agenda dupa eliminare contact [Liviu]:")
//    agenda.removeAt(1)
//    for (persoana in agenda){
//        persoana.Print()
//    }

    print("\nCautare Contact Mihai\n")
    val x = agenda.findByName("Mihai")
    x?.Print()

    print("\nInainte de actualizare contact\n")
    var phone = agenda.findByName("George")
    phone?.Print()
    print("Dupa actualizare contact\n")
    phone = agenda.updatePhoneNumber("George","112")
    phone?.Print()
}


