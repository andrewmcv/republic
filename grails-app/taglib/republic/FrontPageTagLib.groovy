package republic

class FrontPageTagLib {
    static namespace = "fp"
    static clear = """<div class="clear"></div>"""

    def header = { attrs, body ->
        List<ArticleType> types = attrs.types
        out << """<div class="grid_3 push_0"><p class="area">Area</p></div>"""
        String title = """<div class=\"tooltiptext\">Complex <b>inline</b> <i>HTML</i> in your <u>config</u></div>"""
        for (type in types) {
            out << """<div class="grid_2 push_1"><p class="header">${type}</p>${title}</div>"""
        }
        out << """<div class="grid_2 push_1"><p class="check"><input type="submit" name="Mail" value="Notify"></input></p></div>"""
        out << clear
    }

    def row = {attrs, body ->
        List<ArticleType> types = attrs.types
        Area area = attrs.area
        int count = attrs.count
        int indent = indentation(area, 0)
        def style = count % 2 == 0 ? 'even' : 'odd'
        String title = """<div class=\"tooltiptext\">Complex <b>inline</b> <i>HTML</i> in your <u>config</u></div>"""
        out << """<div class="grid_3 push_${indent}"><p class="std">${area.toString()}</p>${title}</div>"""

        // add a column for each type
        def read = (int) (Math.random() * 5)
        String toread = "<font class='" + (read == 0 ? "unhighlighted" : "highlighted") + "'>${read == 0 ? "&nbsp;" : read}</font>";
        def total = (int) (Math.random() * 27) + 1
        String all = "<font class='unhighlighted'>${total == 0 ? "&nbsp;" : total}</font>";

        for (type in types) {
            out << """<div class="grid_1 push_1"><p class="${style}">${toread}</p>${title}</div>"""
            if (type == types[-1]) {
                out << """<div class="grid_1 push_1"><p class="${style}">${all}</p>${title}</div>"""
            } else {
                out << """<div class="grid_1 push_1"><p class="${style} line">${all}</p>${title}</div>"""
            }
        }
        out << """<div class="grid_2 push_1"><p class="check"><input type="checkbox" name="notify${area.toString()}"></input></p></div>"""
        out << clear
    }

    def indentation(Area area, int soFar) {
        if (!area.parent) {
            return soFar;
        }
        indentation(area.parent, soFar + 1)
    }
}
