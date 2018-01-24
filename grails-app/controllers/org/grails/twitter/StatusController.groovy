package org.grails.twitter

import grails.converters.JSON
import org.grails.twitter.auth.Person
import org.springframework.security.access.annotation.Secured
import wdtwitter.StatusService



class StatusController {

    StatusService statusService
    def wdtwitterSecurityService
    def springSecurityService


    @Secured('IS_AUTHENTICATED_FULLY')
    def index() {

        //loggedInUser()
        render (view:'index.gsp')
    }

    @Secured('IS_AUTHENTICATED_FULLY')
    def updateStatus() {
        //rendering the update status method and passing the params (newStatus json object) into the call for updateStatus
        render statusService.updateStatus(params.newStatus)
    }

//    @Secured('IS_AUTHENTICATED_FULLY')
//    def updateWords() {
//        render statusService.updateWords(params.newWordsObject)
//    }

    @Secured('IS_AUTHENTICATED_FULLY')
    def loggedInUser() {
        render(statusService.loggedInUser() as JSON)
    }

//    @Secured('IS_AUTHENTICATED_FULLY')
//    def loggedInUserName() {
//        render(statusService.loggedInUserName())
//    }

    /**
     * controller method for updating username
     * @return
     */
    @Secured('IS_AUTHENTICATED_FULLY')
    def updateUsername() {
        render(statusService.setUsername(params.username))
    }

    /**
     * calling method to get all messages/tweets
     * @return JSON object of all tweets
     */
    @Secured('IS_AUTHENTICATED_FULLY')
    def allTweetsTimeline() {
        render(statusService.getAllTweets() as JSON)
    }

    /**
     * #calling method to get all logged in user's tweets
     * @return JSON object of all logged in user's tweets
     */
    @Secured('IS_AUTHENTICATED_FULLY')
    def userTimeline() {
        render(statusService.getUserTweets() as JSON)
    }

    /**
     * Calling method to return all users real names as a JSON object
     * @return JSON object of all users real names
     */
    @Secured('IS_AUTHENTICATED_FULLY')
    def usersList() {
        render(statusService.getAllUsers() as JSON)
    }

    








    //def springSecurityService

//    @Secured('IS_AUTHENTICATED_FULLY')
//    def index() {
////        def messages = currentUserTimeline()
////        return [messages:messages]
//
//        //render('status')
//        //render (view:'status/index.gsp')
//        //render (view:'../views/status/index.gsp')
//
//        render (view:'index.gsp')
//    }

//    @Secured('IS_AUTHENTICATED_FULLY')
//    def updateStatus() {
//        render 'status updated.'
//    }

//    @Secured('permitAll')
//    def updateStatus() {
//        def status = new Status(message: params.message)
//        status.author = lookupPerson()
//        status.save()
//        def messages = currentUserTimeline()
//        render template: 'messages', collection: messages, var: 'message'
//    }

//    private currentUserTimeline() {
//
//        // will result in hibernate query being sent to the database that will return all the status objects that
//        // contain an author that's username is equal to that persons username
//        def messages = Status.withCriteria {
//            author {
//                eq 'username, springSecurityService.principal.username'
//            }
//            //no more than 10 status results. 10 most recent statuses posted
//            maxResults 10
//            order 'dateCreated', 'desc'
//        }
//        messages
//    }

//    private lookupPerson() {
//        Person.get(springSecurityService.principal.id)
//    }
}
