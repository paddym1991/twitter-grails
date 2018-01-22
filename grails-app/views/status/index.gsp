<%--
  Created by IntelliJ IDEA.
  User: Paddy
  Date: 15/01/2018
  Time: 16:41
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>

    <head>
        <meta name="layout" content="main"/>
        <title>What are you doing?</title>
    </head>

    <body>


    %{--<sec:ifLoggedIn>--}%
        %{--<h1>Welcome <sec:username/><p id="user"></p></h1>--}%
    %{--</sec:ifLoggedIn>--}%

    <h1>Welcome <span id="currentUserName"></span></h1>


    <div>
        <button id="currentUser">Show user</button>
    </div>

        <h2>What are you doing?</h2>
        <p>message: <input type="text" id="message"></p><br/>
        <button id="submit">Update Status</button>
    <div>
        <h2>Timeline</h2>
        <p>'time/date</p>
        <ul id="timeline"></ul>
    </div>

    <div>
        <h3>Set new words</h3>
        <p> New Words: <input type="text" id="newWords"></p>
        <button id="setWords">Update Words</button>
        <h3>newWords</h3>
        <ul id="listWords"></ul>
    </div>


    <content tag="end">

        <asset:javascript src="assets/javascripts/application.js"/>
        <asset:javascript src="assets/javascripts/status.js"/>
    </content>
    %{--<h1>What are you doing?</h1>--}%
    %{--<p>message: <input type="text" id="message"></p><br/>--}%
    %{--<button id="submit">Update Status</button>--}%


        %{--<h1>What are you doing?</h1>--}%
        %{--<div class="updateStatusForm">--}%
            %{--<g:form url="[action: 'updateStatus']" update="messages" name="updateStatusForm">--}%
                %{--<g:textArea name="message" value=""/><br/><br/>--}%
                %{--<g:submitButton name="Update Status"/>--}%
            %{--</g:form>--}%
        %{--</div>--}%
    %{--<div id="messages">--}%
        %{--<g:render template="messages" collection="${messages}" var="message"/>--}%
    %{--</div>--}%



    </body>


</html>

%{--<script>--}%
    %{--$(function() {--}%


        %{--$('#updateStatus').on('click', function() {--}%
            %{--$('#updateStatus').toggle()--}%
        %{--})--}%


    %{--})--}%
%{--</script>--}%