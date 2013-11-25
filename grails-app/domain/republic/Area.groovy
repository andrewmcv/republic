package republic

class Area {
    String name

    static constraints = {
        name blank: false
        name unique: true
        parent nullable: true
    }

    static hasMany = [children:Area]
    static belongsTo = [parent:Area]

    def String toString() {
        name
    }
}
