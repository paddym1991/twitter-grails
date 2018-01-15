package wdtwitter

import grails.transaction.Transactional
import org.grails.twitter.auth.Person

@Transactional
class TestingService {

    def testDBConnection() {
        def retData = Person.createCriteria().get() {
            eq("username", "peter")
            projections {
                property('realName')
            }
        }
        retData
    }

    def testLoginConnection() {
        def retData = Person.createCriteria().get() {
            eq("username", "jeff")
            projections {
                property('id')
            }
        }
        retData
    }

    def peterIdConnection() {
        def retData = Person.createCriteria().get() {
            eq("username", "peter")
            projections {
                property('id')
            }
        }
        retData
    }
}
