package wdtwitter

import grails.converters.JSON
import grails.transaction.Transactional
import org.grails.twitter.auth.Person
import org.springframework.security.access.annotation.Secured
import org.springframework.security.core.userdetails.User

@Transactional
class StatusService {

    def springSecurityService

    def index() {

//        def messages = currentUserTimeline()
//        return [messages:messages]

        //render('status')
        //render (view:'status/index.gsp')
        //render (view:'../views/status/index.gsp')

       // return (view:'index.gsp')
    }

    /**
     * Get the logged in user from db,
     * update status
     * Save
     * @param newStatus
     * @return
     */
    //method takes in parameter newStatus json object from status.js ajax function and returns it.
    def updateStatus(newStatus) {
        newStatus
    }

    def updateWords(newWordsObject) {
        newWordsObject
    }

    /*
     * Get the logged In User
     */
    def loggedInUser() {
//       def userObj = springSecurityService.currentUser
//       def userMap = [:]
//       userMap.username = userObj.username
//       userMap.realName = userObj.realName
//       return userMap as JSON
        springSecurityService.currentUser as JSON
    }

//    /*
//    * Get the name of the currently logged-in user
//    */
//    String loggedInUserName() {
//        springSecurityService.currentUser.username
//    }
}
