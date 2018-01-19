package wdtwitter

import grails.transaction.Transactional
import org.grails.twitter.auth.Person
import org.springframework.security.access.annotation.Secured

@Transactional
class StatusService {

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
}
