pipeline{
  agent any
  stages{
    stage('build'){
      steps {
        script{
          if (env.BRANCH_NAME == 'master') {
            
            echo 'This is building from the master branch'
            
          } else if(env.BRANCH_NAME == 'develop'){
            
            echo 'This is building from the develop branch'
            echo 'Building the images'
            parallel {
              stage('Build Flask Docker Image'){
                sh 'docker build -t myflaskapp .' 
              }
              stage('Run Docker Image') {
                steps {
                  echo 'Running Flask app'
                  sh 'docker run -p 5000:5000 -d --name  myflaskapp  myflaskapp'
                }
              }

              stage('Run Redis') {
                steps {
                  echo 'Running redis'
                  sh '#docker run -p 6379:6379 -d --name redis redis:alpine'
                }
              }
            }
            
          }else if(env.BRANCH_NAME == 'release'){
            
            echo 'This is building from the release branch'
            
          }
        }
      }
    }
    stage('test'){
      steps{
        script{
          if (env.BRANCH_NAME == 'master') {
            
            echo 'This is testing from the master branch'
            
          } else if(env.BRANCH_NAME == 'develop'){
            
            echo 'This is testing from the develop branch'
            sh 'python test_app.py'
            
          }else if(env.BRANCH_NAME == 'release'){
            
            echo 'This is testing from the release branch'
            
          }
        }
      }
    }
    stage('Stop Containers') {
        steps {
          
          script{
          if (env.BRANCH_NAME == 'master') {
            
            echo 'This is building from the master branch'
            
          } else if(env.BRANCH_NAME == 'develop'){
            
            echo 'This is Stopping Containers from the develop branch'
            sh 'docker rm -f myflaskapp'
            sh 'docker rmi myflaskapp'
          }else if(env.BRANCH_NAME == 'release'){
            
            echo 'This is building from the release branch'
            
          }
        }
      }
    }
  }
}
