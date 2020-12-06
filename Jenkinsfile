pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'echo We are in build stage'
      }
    }

    stage('Test') {
      steps {
        bat 'We are in Test stage'
      }
    }

    stage('Finish') {
      steps {
        bat 'We are in Finish stage'
      }
    }

  }
}