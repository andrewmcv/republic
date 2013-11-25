package republic

class ArticleType {
    String name
    int pos

    static constraints = {
        name blank: false
        name unique: true
    }

    def String toString() {
        name
    }
}
