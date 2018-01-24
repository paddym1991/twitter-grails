// $('elementId').on('click', function()  {
//     var elementHTML = $('#elementId').html()
//     $ajax({
//         url: 'Project url/controllerName/methodName',
//         type: "post", //HTML method "post" or "get",
//         data: elementHTML,
//         success:function(returnedData) {
//             //code to update the UI using jQuery library
//         }
//     });
// })


var $statuses = $('statuses')
var $message = $('message')


//added function to check if id 'submit' is being passed
$(function() {

    console.log($("#submit").html())
    getUser()
    getUsers()
    getTimeline()
    getUserTimeline()


})

/**
 * function called when index page is requested. This requests the logged in user JSON object and returns the username
 */
function getUser() {
    $.ajax({
        url: 'http://localhost:8080/wdtwitter/status/loggedInUser',
        type: 'GET', //HTML method "post" or "get"
        //below is a seperate function from above
        success: function(returnedData) {
           $('#currentUserName').html(returnedData.username)
        }
    })
}

/**
 * Request to return all tweets/messages
 */
function getTimeline() {
    // ajax request to get all messages
    $.ajax({
        url: 'http://localhost:8080/wdtwitter/status/allTweetsTimeline',
        type: 'GET',
        success: function(returnedData) {
            //iterate through the returned data (i.e. the messages as a JSON object)
            $.each(returnedData, function(index, value) {
                //append each message onto the allTweetsTimeline list
                $('#allTweetsTimeline').append('<p>' + value + '</p>')
            })
        }
    })
}

/**
 * request to return logged in users messages
 */
function getUserTimeline() {
    // ajax request to get all logged in user's messages
    $.ajax({
        url: 'http://localhost:8080/wdtwitter/status/userTimeline',
        type: 'GET',
        success: function(returnedData) {
            //iterate through the returned data (i.e. the user's messages as a JSON object) -   http://api.jquery.com/jquery.each/
            $.each(returnedData, function(index, value) {
                //append each message onto the userTimeline list with a delete button beside each
                $('#userTimeline').append('<p>' + value + ' <button id="deleteTweet">Delete</button>' + '</p>')
            })
        }
    })
}

/**
 * function called when index page is requested. This requests all users as a JSON object and returns the real name
 */
function getUsers() {
    $.ajax({
        url: 'http://localhost:8080/wdtwitter/status/usersList',
        type: 'GET', //HTML method "post" or "get"
        //below is a seperate function from above
        success: function(returnedData) {
            // iterate through the returned JSON object of real names
            $.each(returnedData, function(index, value) {
                //append each users' real name to the users list
                $('#usersList').append('<p>' + '<a href="#">' + value + '</a>' + '</p>')
            })
        }
    })
}



/**
 * JQuery function for adding new message when button is clicked
 * AJAX request function for adding a new message to timeline
 */
//$("#submit").on('click', function()  {                    //this on click will not work. JS is being loaded before the id from gsp is loaded
$(document).on('click', "#submit", function()  {
    console.log('gobbledigook')

    $('#submit').fadeOut(500).fadeIn(500)

    var status = $('#message').val()
    $.ajax({
        url: 'http://localhost:8080/wdtwitter/status/updateStatus',
        type: 'POST', //HTML method "post" or "get",
        data: {newStatus:status},       //set data as json object 'newStatus' that takes the params from the form
        //below is a seperate function from above
        success: function(returnedData) {
            //code to update the UI using jQuery library
            // $statuses.append('<li>message: ' + status.message)
            console.log('Message: ' + returnedData)    //returnedData is the data json object from the ajax function above
            $('#timeline').append('<p>' + returnedData + '</p>')    //appending the returnedData as a 'html line of code' onto the timeline list (using timeline id) in the gsp file
           // $('#userTimeline').append('<p>' + returnedData + '</p>')
            $('#userTimeline').append('<p>' + returnedData + ' <button id="deleteTweet">Delete</button>' + '</p>')
            $('#allTweetsTimeline').append('<p>' + returnedData + '</p>')
        }
    })
})

/**
 * AJAX function to update the logged in user's username
 */
$(document).on('click', "#update", function()  {

    var name = $('#newUsername').val()
    $.ajax({
        url: 'http://localhost:8080/wdtwitter/status/updateUsername',
        type: 'POST',
        data: {username:name},
        success: function(returnedData) {
            console.log(returnedData)
        }
    })
})



// /**
//  * JQuery function for adding new words message when button is clicked
//  * AJAX request function for adding a new words message
//  */
// $(document).on('click', "#setWords", function()  {
//
//     var words = $('#newWords').val()
//     $.ajax({
//         url: 'http://localhost:8080/wdtwitter/status/updateWords',
//         type: 'POST',
//         data: {newWordsObject:words},
//         success: function(returnedData) {
//             console.log('newWords: ' + returnedData)
//             $('#listWords').append('<p>' + returnedData + '</p>')
//         }
//     })
// })

// $(document).on('mouseover', "#currentUser", function()  {
//
//     var loggedInUser = loggedInUser()
//     $.ajax({
//         url: 'http://localhost:8080/wdtwitter/status/updateWords',
//         type: 'GET',
//         data: {User:loggedInUser},
//         success: function(returnedData) {
//             console.log('newWords: ' + returnedData)
//             $('#listWords').append('<p>' + returnedData + '</p>')
//         }
//     })
// })

