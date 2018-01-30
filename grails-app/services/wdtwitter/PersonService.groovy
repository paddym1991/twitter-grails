package wdtwitter

import grails.transaction.Transactional
import org.grails.twitter.auth.Person

@Transactional
class PersonService {

    def springSecurityService

    def serviceMethod() {

    }

    def userProfile(id) {

    }

    /**
     * Get shown user from the db
     */
    def getShownUser(id) {
        //declare a variable user and assign a user to it based on the id parameter
        def user = Person.get(id)
        //return the user
        user
    }

}
