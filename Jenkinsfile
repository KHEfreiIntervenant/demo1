pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        echo 'We are in Build stage'
        sh 'docker build -t myflaskapp3 .'
      }
    }

    stage('Run') {
      parallel {
        stage('Run') {
          steps {
            echo 'We are in Run stage'
            sh 'docker run -d -p 5000:5000 --name myflaskapp3_c myflaskapp3'
          }
        }

        stage('Run 2') {
          steps {
            echo 'We are in Test 2 stage'
            sh 'docker run -d -p 6379:6379 --name myredis redis '
          }
        }

      }
    }

    stage('Test') {
      steps {
        echo 'We are in the Testing stage'
        sh 'python test_app.py'
      }
    }

    stage('Remove Images') {
      parallel {
        stage('Remove Images') {
          steps {
            sh 'docker stop myflaskapp3_c'
            sh 'docker rmi -f myflaskapp3_c'
          }
        }

        stage('error') {
          steps {
            sh 'docker stop myredis'
            sh 'docker rmi -f myredis'
          }
        }

      }
    }

    stage('Finish') {
      steps {
        echo 'The pipeline is finished'
      }
    }

  }
}