<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Other User's Profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

<div class="col-lg-12">
    <h1>Welcome to ${realName}'s profile <button>follow</button></h1>
    <ul>
        <ul>Username: ${username}</ul>
        <ul>Email: ${email}</ul>
        <ul>Phone: ${phone}</ul>
    </ul>
</div>

<div class="row">
    <div class="col-lg-4">
        <h2>Timeline</h2>
        <ul id="otherUserTimeline"></ul>
    </div>
</div>


<content tag="end">

    <asset:javascript src="assets/javascripts/application.js"/>
    <asset:javascript src="assets/javascripts/status.js"/>
</content>


</body>

</html>