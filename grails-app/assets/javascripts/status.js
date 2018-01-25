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
                $('#allTweetsTimeline').append('<p>' + value.timestamp + ' : ' + value.status + '</p>')
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
                // append the status and timestamp to the list. Also append a button with an individual id and the tweet's id
                $('#userTimeline').append('<p id="tweetid' + returnedData.id + '" >' + value.timestamp + ' : ' + value.status + ' <button id="deleteTweet' + value.id + '" tweetId="'+ value.id +'">Delete</button>' + '</p>')
               // $('#userTimeline').attr('id', value)
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
                //append each users' real name to the users list and make it a link
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
            console.log('Message: ' + returnedData)    //returnedData is the data json object from the ajax function above
            $('#timeline').append('<p>' + returnedData + '</p>')    //appending the returnedData as a 'html line of code' onto the timeline list (using timeline id) in the gsp file
           // append the status and timestamp to the list. Also append a button with an individual id and the tweet's id
            $('#userTimeline').append('<p id="tweetid' + returnedData.id + '" >' + returnedData.timestamp + ' : ' + returnedData.status + ' <button id="deleteTweet' + returnedData.id + ' " tweetId="'+returnedData.id+'">Delete</button>' + '</p>')
            $('#allTweetsTimeline').append('<p id="tweetid' + returnedData.id + '" >' + returnedData.timestamp + ' : ' + returnedData.status + '</p>')
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

/**
 * AJAX function to delete a tweet
 */
// "button" refers to the button TAG    https://stackoverflow.com/questions/18680735/how-to-get-the-id-of-the-element-clicked-using-jquery  - first answer
// in a list of button the tag linked to the button chosen is selected and the related button id is chosen
$(document).on('click', "button", function()  {

    //get the id of the button within the button tag that was clicked
    var buttonId = $(this).attr('id')

    //log this id to the console
    console.log(buttonId)
    //print an alert to screen of the button id
    alert('button id = ' + buttonId)
    //get the id of the tweet within the button tag that has been clicked
    var tweetId = $(this).attr('tweetId')
    //log tweet id to console
    console.log(tweetId)
    // var pId = $(this).attr('id')
    // console.log(pId)
    //print an alert to screen of tweet id
    alert('tweet id = ' + tweetId)
    $.ajax({
        url: 'http://localhost:8080/wdtwitter/status/deleteTweet',
        type: 'POST',
        data: {tweet_id:tweetId},
        success: function(response) {
            console.log(response)
            $('#UserTimeline').remove('#tweetid' + tweetId)
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

