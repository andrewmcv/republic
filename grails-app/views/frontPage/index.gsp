<%@ page import="republic.ArticleType; republic.Area" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Republic</title>

    <script src="${resource(dir: 'js/jquery', file: 'jquery-1.9.1.js')}"></script>
    <link href="${resource(dir: 'css', file: 'republic.css')}" rel="stylesheet" type="text/css" />
    <script src="${resource(dir: 'js/jquery.qtip.custom', file: 'jquery.qtip.min.js')}"></script>
    <link href="${resource(dir: 'js/jquery.qtip.custom', file: 'jquery.qtip.min.css')}" rel="stylesheet" type="text/css" />

    <r:script>
        // Create the tooltips only when document ready
        $(document).ready(function()
        {
            // MAKE SURE YOUR SELECTOR MATCHES SOMETHING IN YOUR HTML!!!
            $('p').each(function() {
                $(this).qtip({
                    style: { classes: 'qtip-bootstrap' },
                    content: {
                        text: $(this).next('.tooltiptext')
                    }
                });
            });
        });
    </r:script>
    <r:layoutResources/>
</head>
<body>

<%
    def areas = Area.findAll()
    def types = ArticleType.findAll(sort: 'pos')
    def count = 0
%>

<g:render template="/title"/>

<div style="height:30px"></div>

<g:form name="frontpage" action="notify" id="1">
    <div style="margin-left:10px;">
        <div class="container_16">
            <fp:header types="${types}"></fp:header>
            <g:each var="toplevel" in="${ areas.grep{ !it.parent }.sort{ it.name } }">
                <fp:row types="${types}" area="${toplevel}" count="${count++}"></fp:row>
                <g:each var="sub1" in="${ areas.grep{ it.parent == toplevel }.sort{ it.name } }">
                    <fp:row types="${types}" area="${sub1}" count="${count++}"></fp:row>
                    <g:each var="sub2" in="${ areas.grep{ it.parent == sub1 }.sort{ it.name } }">
                        <fp:row types="${types}" area="${sub2}" count="${count++}"></fp:row>
                    </g:each>
                </g:each>
            </g:each>
        </div>
    </div>
</g:form>



<r:layoutResources/>

</body>
</html>