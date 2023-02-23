pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        bat 'mvn clean test -Denvironment=runDev_Grid_Cloud_Refactor'
      }
    }

  }
}