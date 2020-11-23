pipeline{
  agent any
  stages{
    stage('build'){
      steps {
        if (env.BRANCH_NAME == 'master') {
          echo 'This is building from the master branch'
        } else if(env.BRANCH_NAME == 'develop'){
          echo 'This is building from the develop branch'
        }else if(env.BRANCH_NAME == 'release'){
          echo 'This is building from the release branch'
        }
      }
    }
    stage('test'){
      steps{
        if (env.BRANCH_NAME == 'master') {
          echo 'This is testing from the master branch'
        } else if(env.BRANCH_NAME == 'develop'){
          echo 'This is testing from the develop branch'
        }else if(env.BRANCH_NAME == 'release'){
          echo 'This is testing from the release branch'
        }
      }
    }
  }
}
