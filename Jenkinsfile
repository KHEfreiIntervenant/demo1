pipeline{
  agent any
  stages {
    stage('Building docker image'){
      steps{
        script{
          if(env.BRANCH_NAME == 'develop' || env.BRANCH_NAME == 'release'){
            sh 'docker build -t myflaskapp .'
          }
          else if(env.BRANCH_NAME == 'master'){
            echo 'Should do master stuff for build'
          }
        }
      }
    }
    stage('Run Docker Images'){
      parallel{
        stage('Run redis'){
          steps{
            script{
              if(env.BRANCH_NAME == 'develop' || env.BRANCH_NAME == 'release'){
                sh 'docker run -p 6379:6379 -d --name redis redis:alpine'
              }
            }
          }
        }
        stage('Run flask app'){
          steps{
            script{
              if(env.BRANCH_NAME == 'develop' || env.BRANCH_NAME == 'release'){
                sh 'docker run -p 5000:5000 -d --name myflaskapp_c myflaskapp'
              }
            }
          }
        }
      }
    }
    stage('Testing'){
      steps{
        script{
          if(env.BRANCH_NAME == 'develop'){
            sh 'python test_app.py'
          }
        }
      }
    }
    stage('Release'){
      steps{
        script{
          if(env.BRANCH_NAME == 'release'){
            echo 'deploy for staging environment'
          }
        }
      }
    }
    
    stage('Merging to master'){
      steps{
        script{
          if(env.BRANCH_NAME == 'release'){
            echo 'Merging to master'
          }
        }
      }
    }
    
    stage('Stop Containers'){
      steps{
        script{
          if(env.BRANCH_NAME == 'develop' || env.BRANCH_NAME == 'release'){
            sh 'docker rm -f myflaskapp_c'
            sh 'docker rmi -f myflaskapp'
            sh 'docker rm -f redis'
          }
        }
      }
    }
  }
}
