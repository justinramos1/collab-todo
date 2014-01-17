package collab.todo

class User {

    static transients = ["confirmPassword"]

    String userName
    String firstName
    String lastName
    String confirmPassword
    static mapping = {

    }

    static hasMany = [todos: Todo, categories: Category]

    static constraints = {
        userName(blank: false,unique: true)
        firstName(blank: false)
        lastName(blank: false)
    }

    String toString(){
        "$lastName, $firstName"
    }
}
