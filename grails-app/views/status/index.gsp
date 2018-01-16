<%--
  Created by IntelliJ IDEA.
  User: Paddy
  Date: 15/01/2018
  Time: 16:41
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<p>Status page</p>
    <head>
        <meta name="layout" content="main"/>
        <title>What are you doing?</title>
    </head>

    <body>

        <h1>What are you doing?</h1>
        <div class="updateStatusForm">
            <g:formRemote url="[action: 'updateStatus']" update="messages" name="updateStatusForm">
                <g:textArea name="message" value=""/><br/>
                <g:submitButton name="Update Status"/>
            </g:formRemote>
        </div>

    </body>
</html>