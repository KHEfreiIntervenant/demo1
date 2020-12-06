pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        bat 'docker build -t myflaskapp3 .'
      }
    }

    stage('Run') {
      parallel {
        stage('Run') {
          steps {
            bat 'docker run -d -p 5000:5000 --name myflaskapp3_c myflaskapp3'
          }
        }

        stage('Run2') {
          steps {
            bat 'docker run -d -p 6379:6379 --name myredis redis'
          }
        }

      }
    }

    stage('Test') {
      steps {
        bat 'echo We are in Testing stage'
        bat 'python test_app.py'
      }
    }

    stage('Remove Images') {
      parallel {
        stage('Remove Images') {
          steps {
            bat 'docker stop myflaskapp_c'
            bat 'docker rmi -f myflaskapp_c'
          }
        }

        stage('Remove Redis') {
          steps {
            bat 'docker stop myredis'
            bat 'docker rmi -f myredis'
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