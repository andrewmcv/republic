import republic.Area
import republic.ArticleType

import javax.servlet.ServletContext

class BootStrap {

    def init = { ServletContext ctx ->
        environments {
            production {
            }
            development {
                // place dummy data for testing here
                def eng = new Area(name: 'Engineering').save()
                def bacon = new Area(name: 'Mystery', parent: eng).save()
                def data = new Area(name: 'Data', parent: eng).save()
                def sec = new Area(name: 'Information security', parent: eng).save()
                def core = new Area(name: 'Core', parent: eng).save()
                def lol = new Area(name: 'Big Game', parent: eng).save()
                def engine = new Area(name: 'Game Engine', parent: lol).save()
                def front = new Area(name: 'Front End', parent: lol).save()
                def gplay = new Area(name: 'Game Play', parent: lol).save()
                def regional = new Area(name: 'Regional', parent: lol).save()
                def services = new Area(name: 'Service Features', parent: lol).save()
                def mobile = new Area(name: 'Mobile', parent: eng).save()
                def ops = new Area(name: 'Network Operations', parent: eng).save()
                def qa = new Area(name: 'Quality Assurance', parent: eng).save()
                def web = new Area(name: 'Web', parent: eng).save()

                new ArticleType(name: 'Q&A', pos: 0).save()
                new ArticleType(name: 'Std RFC', order: 1).save()
                new ArticleType(name: 'Info RFC', order: 2).save()
                new ArticleType(name: 'Design RFC', order: 3).save()
                new ArticleType(name: 'Announce', order: 4).save()
            }
        }
    }
}
