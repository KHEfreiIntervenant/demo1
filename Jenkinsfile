pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        echo 'We are in Build stage'
        sh 'echo "Hello"'
      }
    }

    stage('Run') {
      parallel {
        stage('Run') {
          steps {
            echo 'We are in Run stage'
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