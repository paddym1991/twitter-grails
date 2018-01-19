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

})




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
        }
    })
})


$(document).on('click', "#setWords", function()  {

    var words = $('#newWords').val()
    $.ajax({
        url: 'http://localhost:8080/wdtwitter/status/updateWords',
        type: 'POST',
        data: {newWordsObject:words},
        success: function(returnedData) {
            console.log('newWords: ' + returnedData)
            $('#listWords').append('<p>' + returnedData + '</p>')
        }
    })
})