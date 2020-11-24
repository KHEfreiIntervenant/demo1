pipeline{
  agent any
  
  stages {
    
/*   stage('Docker images down first time'){
      steps{
        catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
          sh 'docker rm -f redis'
          sh 'docker rm -f myflaskapp_c'
          sh 'docker rmi -f myflaskapp'
          sh 'docker rm -f redis'
          sh 'docker rm -f myflaskapp_c'
          sh 'docker rmi -f myflaskapp'
        }
      }
    }*/
    
    stage('Build Flask app'){
      steps{
         script{
          if(env.BRANCH_NAME == 'develop' || env.BRANCH_NAME == 'release'){
            sh 'docker build -t myflaskapp .'
          }
        }
      }
    }
    stage('Run docker images'){
      parallel{
        stage('Run Redis'){
          steps{
            script{
              if(env.BRANCH_NAME == 'develop' || env.BRANCH_NAME == 'release'){
                sh 'docker run -d -p 6379:6379 --name redis redis:alpine'
              }
            }
          }
        }
        stage('Run Flask App'){
          steps{
            script{
              if(env.BRANCH_NAME == 'develop' || env.BRANCH_NAME == 'release'){
                sh 'docker run -d -p 5000:5000 --name myflaskapp_c myflaskapp'
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
          }else if( env.BRANCH_NAME == 'release') {
            echo 'release-specific test'
          }
        }
      }
    }
    stage('Docker images down'){
      steps{
        script{
          if(env.BRANCH_NAME == 'develop'){
            sh 'docker rm -f redis'
            sh 'docker rm -f myflaskapp_c'
            sh 'docker rmi -f myflaskapp'
          }
        }
      }
	}
      stage('creating release branch'){
        steps{
          if(env.BRANCH_NAME == 'develop'){
            echo 'branch into release'
          }
        }
      }
    }
}
