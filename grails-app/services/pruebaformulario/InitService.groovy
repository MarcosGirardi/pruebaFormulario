package pruebaformulario

import grails.transaction.Transactional

@Transactional
class InitService {

    def init() {

      def userRole = SecRole.findByAuthority('ROLE_USER') ?: new SecRole(authority: 'ROLE_USER').save(failOnError: true)
      def adminRole = SecRole.findByAuthority('ROLE_ADMIN') ?: new SecRole(authority: 'ROLE_ADMIN').save(failOnError: true)

      def adminUser = SecUser.findByUsername('admin') ?: new SecUser(
          username: 'admin',
          password: 'admin',
          enabled: true).save(failOnError: true)
      if (!adminUser.authorities.contains(adminRole)) {
          SecUserSecRole.create adminUser, adminRole
      }
      def userUser = SecUser.findByUsername('user') ?: new SecUser(
          username: 'user',
          password: 'user',
          enabled: true).save(failOnError: true)
      if (!userUser.authorities.contains(userRole)) {
          SecUserSecRole.create userUser, userRole
      }

      def sudo = SecUser.findByUsername('sudo') ?: new SecUser(
          username: 'sudo',
          password: 'sudo',
          enabled: true).save(failOnError: true)
      if (!sudo.authorities.contains(adminRole)) {
          SecUserSecRole.create sudo, adminRole
      }
      if (!sudo.authorities.contains(userRole)) {
          SecUserSecRole.create sudo, userRole
      }

    }
}
