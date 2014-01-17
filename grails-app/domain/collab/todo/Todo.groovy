package collab.todo

class Todo {

    static belongsTo = [User, Category]

    String name
    String note
    Date createdDate
    Date dueDate
    Date completedDate
    String priority
    String status
    User owner
    Category category

    static mapping = {
        table 'todo_tbl'

        columns {
            name column: 'name_str'
            note column: 'note_str'
        }

        autoTimestamp false
        cache true
    }

    static constraints = {
        owner(nullable: false)
        name(blank:false)
        createdDate()
        priority()
        status()
        note(maxSize: 1000, nullable: true)
        completedDate(nullable: true, validator: {
            val, obj->
                if(val != null){
                    return val.after(obj.createdDate)
                }
                return true
        })
        dueDate(nullable: true)

    }

    def beforeInsert = {
        createdDate = new Date()
        lastModifiedDate = new Date()
    }

    def beforeUpdate = {
        lastModifiedDate = new Date()
    }

    String toString(){
        name
    }
}
