pipeline {
  agent any
  stages {
    stage('build') {
      parallel {
        stage('build') {
          steps {
            echo 'We are in Build stage'
          }
        }

        stage('build2') {
          steps {
            echo 'We are in Build 2 stage'
          }
        }

      }
    }

    stage('test') {
      parallel {
        stage('test') {
          steps {
            echo 'We are in Test stage'
          }
        }

        stage('test2') {
          steps {
            echo 'We are in Test 2 stage'
          }
        }

      }
    }

    stage('Finish') {
      steps {
        echo 'We are in Finishing stage'
      }
    }

  }
}