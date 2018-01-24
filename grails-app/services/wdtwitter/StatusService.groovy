package wdtwitter

import grails.converters.JSON
import grails.transaction.Transactional
import org.grails.twitter.Status
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
    //method takes in parameter newStatus json object from status.js ajax function and returns it as a map with status message, id and date created.
    def updateStatus(newStatus) {
        def status = new Status(message: newStatus)
        status.author = loggedInUser()
        status.save()
        //map returned containing status message, status id and status timestamp
        [status: newStatus, id: status.id, timestamp: status.dateCreated]
    }

//    def updateWords(newWordsObject) {
//        newWordsObject
//    }

    /*
     * Get the logged In User
     */
    def loggedInUser() {
//       def userObj = springSecurityService.currentUser
//       def userMap = [:]
//       userMap.username = userObj.username
//       userMap.realName = userObj.realName
//       return userMap as JSON
        springSecurityService.currentUser
    }

//    /*
//    * Get the name of the currently logged-in user
//    */
//     def loggedInUserName() {
//        springSecurityService.currentUser.username as JSON
//    }

/**
 * logic for updating username for logged in user
 * @param username
 * @return
 */
    def setUsername(username) {

        loggedInUser().username = username
    }

    /**
     * Get all tweet messages from the db
     */
    def getAllTweets() {

        //create a list that the extracted data from db will be put in to   -   http://docs.grails.org/3.1.1/ref/Domain%20Classes/createCriteria.html
        def messages = Status.createCriteria().list() {
            projections {
                //return back any message in db to the list
                property('message')
            }
        }
    }

    /**
     * Return logged in user's tweets from db using the author (the logged in user) as a parameter
     */
    def getUserTweets() {

        def user = loggedInUser()
        //create a list that the extracted data from db will be put in to
        def messages = Status.createCriteria().list() {
            //set the search field for messages as the author (logged in user)
            eq('author', user)
            projections {
                //return back any id, message, and dateCreated that link to the the author, to the list
                property('id')
                property('message')
                property('dateCreated')
            }
            //iterate through each row and collect the 3 pieces of data as above
            //A map will be created, with the 3 attributes above, for each row the author is in
            //Ensure that the keys are in the map in the same order as the returned properties above
        }.collect {
            [id: it[0], status:it[1], timestamp: it[2]]
        }
    }

    /**
     * Get all users names from the db
     */
    def getAllUsers() {
        //declare a variable users and assign all users to it
        def users = Person.getAll()
        //return all users real names
        users.realName

//        //create a list that the extracted data from db will be put in to   -   http://docs.grails.org/3.1.1/ref/Domain%20Classes/createCriteria.html
//        def users = Status.createCriteria().list() {
//            projections {
//                //return back any users name in db to the list
//                property('realName')
//            }
//        }
    }

    

}
